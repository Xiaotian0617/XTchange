package com.ailu.oneToken.websocket;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import okhttp3.*;

import java.math.BigDecimal;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 每个url对应一个websocket连接
 * <p>
 * 使用示例
 * new WSListener()
 */
public class WSListener extends WebSocketListener {

    private Proxy proxy ;

    private static OkHttpClient client = new OkHttpClient.Builder()
            .readTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .retryOnConnectionFailure(false)
            .build();

    /**
     * 用于定时发送ping 和 websocket重连时延迟
     */
    private static ScheduledExecutorService single = Executors.newSingleThreadScheduledExecutor();

    private String url;
    private List<String> sendText = new ArrayList<>();


    private HashMap<String, BiConsumer<WebSocket, String>> eventListener = new HashMap<>();

    private String ping;
    private int interval;
    private ScheduledFuture<?> intervalPing;

    private boolean isPrint;


    private Function<String, Info> messageParser;
    private Consumer<Info> messageHandler;
    private BiConsumer<WebSocket, String> messageEventListener;

    public WSListener() {
        this("");
    }


    /**
     * 新建立一个websocket连接，也可以使用 {@link WSListener#url(String)} 方法设置
     *
     * @param url websocket地址 ws:// ro wss://
     */
    public WSListener(String url) {
        this.url = url;
    }

    /**
     * 设置websocket url
     *
     * @param url ws:// or wss://
     */
    public WSListener url(String url) {
        this.url = url;
        return this;
    }

    /**
     * 设置要发送的订阅信息，发送内容一般会在 {@link WSListener#event(String, BiConsumer)} 的open事件里发送
     *
     * @param sendText eg: subscribe text
     */
    public WSListener send(List<String> sendText) {
        this.sendText.addAll(sendText);
        return this;
    }

    /**
     * 设置要发送的订阅信息
     *
     * @param sendText eg: subscribe text
     */
    public WSListener send(String sendText) {
        this.sendText.add(sendText);
        return this;
    }

    /**
     * 设置websocket收到的message信息解析器，不设置 {@link WSListener#message(Consumer)} 不会收到解析的信息
     */
    public WSListener parse(Function<String, Info> parser) {
        this.messageParser = parser;
        return this;
    }

    /**
     * websocket解析后的信息
     *
     * @param consumer
     */
    public WSListener message(Consumer<Info> consumer) {
        this.messageHandler = consumer;
        return this;
    }

    /**
     * websocket解析后的信息
     *
     * @param isPrint
     */
    public WSListener setPrintLog(boolean isPrint) {
        this.isPrint = isPrint;
        return this;
    }

    /**
     * websocket事件监听
     *
     * @param eventype 事件类型， open / message / closed / error
     * @param consumer 事件处理
     */
    public WSListener event(String eventype, BiConsumer<WebSocket, String> consumer) {
        this.eventListener.put(eventype, consumer);
        if ("message".equals(eventype)) {
            this.messageEventListener = consumer;
        }
        return this;
    }

    /**
     * 获取用户设置的事件监听，如用户没设置会使用默认的事件(打印事件信息)
     *
     * @param eventype 事件类型
     * @return
     */
    private BiConsumer<WebSocket, String> event(String eventype) {
        return this.eventListener.getOrDefault(eventype, (ws, str) -> System.out.println(eventype + ":" + str));
    }

    /**
     *  设置请求代理
     */
    public WSListener setProxy(Proxy proxy){
        this.proxy = proxy;
        client = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .proxy(proxy)
                .retryOnConnectionFailure(false)
                .build();
        return this;
    }


    @Override
    public void onOpen(WebSocket webSocket, Response response) {
        event("open").accept(webSocket, response.toString());
        Optional.ofNullable(sendText).ifPresent(strings -> strings.forEach(webSocket::send));

        if (ping != null) {
            intervalPing = single.scheduleAtFixedRate(() -> {
                webSocket.send(ping);
            }, 0, interval, TimeUnit.SECONDS);
        }
    }



    @Override
    public void onMessage(WebSocket webSocket, String text) {
        if (isPrint){
            event("message").accept(webSocket, String.format("%s",text));
        }
        if (messageEventListener != null) {
            messageEventListener.accept(webSocket, text);
        }

        if (messageParser != null && messageHandler != null) {
            Info info = messageParser.apply(text);
            if (info != null) {
                messageHandler.accept(info);
            }
        }
    }

    @Override
    public void onClosed(WebSocket webSocket, int code, String reason) {
        event("closed").accept(webSocket, String.format("[%s]%s", code, reason));
    }

    @Override
    public void onClosing(WebSocket webSocket, int code, String reason) {
        event("closing").accept(webSocket, String.format("[%s]%s", code, reason));
    }

    @Override
    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        event("error").accept(webSocket, t.getMessage() + "-" + response);

        if (intervalPing != null) intervalPing.cancel(true);
        single.schedule(() -> client.newWebSocket(webSocket.request(), this), 2, TimeUnit.SECONDS);
    }

    /**
     * 开始websocket连接
     */
    public void start(Request req) {
        client.newWebSocket(req, this);
    }

    /**
     * 开始websocket连接
     */
    public void start() {
        Request req = new Request.Builder().url(url).build();
        client.newWebSocket(req, this);
    }

    /**
     * 设置websocket要循环发送内容和时间
     * @param ping 发送内容
     * @param interval 时间间隔 以秒为单位
     * @return
     */
    public WSListener ping(String ping, int interval) {
        this.ping = ping;
        this.interval = interval;
        return this;
    }


    /**
     * message返回的信息解析模板
     */
    @Data
    public static class Info<T> {

        /**
         * account_symbol : null
         * currency : eth
         * amount : 0.1
         * from_address : 0x1598f402c73f722a09006ba54c2d6cc6ce9a6eb2
         * target_address : 0x38022036073b3781848fde3299e907f407e9e5b9
         * fee : 1.05E-4
         * address_tag : null
         * exchange_deposit_id : 0xed4c29dbd0b7d8b265d842db599f6e899f746d602cc82f5d37a45cd3b3d3bf51
         * status : success
         * create_time : null
         * last_update : 2018-12-26T07:07:43+08:00
         * exchange_update : 2018-12-26T07:07:43+08:00
         * tags : {"deposit_type":null}
         */

        @JSONField(name = "account_symbol")
        private Object accountSymbol;
        @JSONField(name = "currency")
        private String currency;
        @JSONField(name = "amount")
        private BigDecimal amount;
        @JSONField(name = "from_address")
        private String fromAddress;
        @JSONField(name = "target_address")
        private String targetAddress;
        @JSONField(name = "fee")
        private BigDecimal fee;
        @JSONField(name = "address_tag")
        private Object addressTag;
        @JSONField(name = "exchange_deposit_id")
        private String exchangeDepositId;
        @JSONField(name = "status")
        private String status;
        @JSONField(name = "create_time")
        private Object createTime;
        @JSONField(name = "last_update")
        private String lastUpdate;
        @JSONField(name = "exchange_update")
        private String exchangeUpdate;
        @JSONField(name = "tags")
        private TagsBean tags;

        public Object getAccountSymbol() {
            return accountSymbol;
        }

        public void setAccountSymbol(Object accountSymbol) {
            this.accountSymbol = accountSymbol;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public BigDecimal getAmount() {
            return amount;
        }

        public void setAmount(BigDecimal amount) {
            this.amount = amount;
        }

        public String getFromAddress() {
            return fromAddress;
        }

        public void setFromAddress(String fromAddress) {
            this.fromAddress = fromAddress;
        }

        public String getTargetAddress() {
            return targetAddress;
        }

        public void setTargetAddress(String targetAddress) {
            this.targetAddress = targetAddress;
        }

        public BigDecimal getFee() {
            return fee;
        }

        public void setFee(BigDecimal fee) {
            this.fee = fee;
        }

        public Object getAddressTag() {
            return addressTag;
        }

        public void setAddressTag(Object addressTag) {
            this.addressTag = addressTag;
        }

        public String getExchangeDepositId() {
            return exchangeDepositId;
        }

        public void setExchangeDepositId(String exchangeDepositId) {
            this.exchangeDepositId = exchangeDepositId;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Object getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Object createTime) {
            this.createTime = createTime;
        }

        public String getLastUpdate() {
            return lastUpdate;
        }

        public void setLastUpdate(String lastUpdate) {
            this.lastUpdate = lastUpdate;
        }

        public String getExchangeUpdate() {
            return exchangeUpdate;
        }

        public void setExchangeUpdate(String exchangeUpdate) {
            this.exchangeUpdate = exchangeUpdate;
        }

        public TagsBean getTags() {
            return tags;
        }

        public void setTags(TagsBean tags) {
            this.tags = tags;
        }

        public static class TagsBean {
            /**
             * deposit_type : null
             */

            @JSONField(name = "deposit_type")
            private Object depositType;

            public Object getDepositType() {
                return depositType;
            }

            public void setDepositType(Object depositType) {
                this.depositType = depositType;
            }
        }
    }
}

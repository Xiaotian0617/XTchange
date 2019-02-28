package com.ailu.oneToken.websocket;

import com.ailu.oneToken.api.OneToken;
import com.ailu.oneToken.constant.APIConstants;
import com.ailu.oneToken.enums.ContentTypeEnum;
import com.ailu.oneToken.utils.Signature;
import com.alibaba.fastjson.support.retrofit.Retrofit2ConverterFactory;
import okhttp3.Headers;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.net.InetSocketAddress;
import java.net.Proxy;

import static com.ailu.oneToken.websocket.OneTokenPrivateListener.OneTokenApi.*;

/**
 * NOTE:
 *
 * @Version 1.0
 * @Since JDK1.8
 * @Author mr.wang
 * @Company Henan ailu
 * @Date 2018/12/14 10:17
 */
public class OneTokeListener {

    public interface OneTokenApi{
        /**
         * 账户信息订阅接口
         * eg   : {account_symbol} 形式大致为：huobip/ot-user1
         * wss://1token.trade/api/v1/ws/trade/{account_symbol}
         * 签名验证 打开websocket连接时需要通过HTTP headers做验证:
         *
         * Api-Nonce: 一个递增的数字，0到2^53
         *
         * Api-Key: 你的 onetoken API key
         *
         * Api-Signature: 请求签名，计算方法hex(HMAC_SHA256(ot_secret, verb + path + nonce + data))，这里的path为/ws/{account_name}，
         * 例如/ws/ot-user1，ot-user1是account symbol中的账户名部分。
         *
         * Api-Meta: OT Account name（可选）.
         */
        String TICK_WS_URL = "wss://1token.trade/api/v1/ws/tick";
        String CANDLE_WS_URL = "wss://1token.trade/api/v1/ws/candle";
        //24小时涨跌
        String HIGHLOW_WS_URL = "wss://1token.trade/api/v1/ws/low-freq-quote-v2";
        String ACCOUNT_WS_URL = "wss://1token.trade/api/v1/ws/trade/%s/%s";
        String REST_BASE_RUL = OneToken.baseUrl;

        /**
         * // 订阅账户信息
         * {"uri":"sub-info"}
         *
         * // 订阅成功响应
         * {"action": "sub-info", "status": "ok"}
         *
         * // 推送信息格式
         * {"action": "info","status": "ok", "data": {acc-info}}
         *
         * // 订阅订单变化
         * {"uri":"sub-order"}
         *
         * // 订阅成功响应
         * {"action": "sub-order", "status": "ok"}
         *
         * // 推送信息格式
         * {"action": "order","status": "ok", "data": [order]}
         *
         * //错误信息格式
         * {"action": "sub-info", "status": "failed", "message": "error message"}
         */
        String SEND_MSG = "{\"uri\":\"batch-subscribe\",\"contracts\":[\"okef/btc.usd.t\",\"okef/ltc.usd.t\",\"okef/eth.usd.t\",\"okef/etc.usd.t\",\"okef/bch.usd.t\",\"okef/eos.usd.t\",\"okef/xrp.usd.t\",\"okef/btg.usd.t\"]}";

        /**
         * 1token websocket接口, {@link WSListener#start()} 方法最后调用
         * 当用户首次订阅订单信息时，将会收到一份当前挂单列表，之后每当交易所推送订单相关信息时，1token会将发生变化的订单推送到客户端
         */
        default WSListener ws() {
            return new WSListener()
                    .url(TICK_WS_URL)
                    .ping("{'url':'ping'}",5)
                    .parse(OneTokeListener::parse);
        }

        /**
         * 1token websocket接口, {@link WSListener#start()} 方法最后调用
         * 当用户首次订阅订单信息时，将会收到一份当前挂单列表，之后每当交易所推送订单相关信息时，1token会将发生变化的订单推送到客户端
         */
        default WSListener wsByUrl(String url) {
            return new WSListener()
                    .url(url)
                    .ping("{'url':'ping'}",5)
                    .parse(OneTokeListener::parse);
        }

        static Headers headers() {
            final Headers.Builder builder = new Headers.Builder();
            builder.add(APIConstants.CONTENT_TYPE, ContentTypeEnum.APPLICATION_JSON.contentType());
            builder.add(APIConstants.APIKEY,APP_KEY);
            String nonce = Signature.getNonce();
            builder.add(APIConstants.APINONCE, nonce);
            builder.add(APIConstants.APISIGNATURE,getSignature(APP_SECRET,nonce, null));
            return builder.build();
        }

    }

    private static WSListener.Info parse(String text) {
        System.out.println(text);
        return new WSListener.Info();
    }

    public static OneTokenApi oneTokenApi = new Retrofit.Builder()
            .baseUrl(OneTokenApi.REST_BASE_RUL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(new Retrofit2ConverterFactory())
            .build()
            .create(OneTokenApi.class);

    public static void main(String[] args) {
        try {
            WSListener ws = oneTokenApi.ws();
            //String url = String.format(OneTokenApi.ACCOUNT_WS_URL,"okef","liujianshu");
            Request req = new Request.Builder()//.headers(OneTokenApi.headers())
                    .url(OneTokenApi.TICK_WS_URL).build();
            ws.url(OneTokenApi.TICK_WS_URL)
                    .message(msg-> System.out.println(msg)).start(req);
        }catch (Throwable e){
            e.printStackTrace();
        }
    }

}

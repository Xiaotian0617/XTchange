package com.al.bcoin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.support.retrofit.Retrofit2ConverterFactory;
import lombok.Data;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * api doc https://docs.bitfinex.com/v1/docs
 */
public class Bitfinex {

    public interface Api {

        String BASE_URL = "https://api.bitfinex.com/";
        String WS_URL = "wss://api.bitfinex.com/ws/2";

        /**
         * A list of symbol names. 5 req/min
         *
         * @return
         */
        @GET("v1/symbols")
        Call<List<String>> symbols();

        /**
         * The ticker is a high level overview of the state of the market.
         * It shows you the current best bid and ask, as well as the last trade price.
         * It also includes information such as daily volume and how much the price has moved over the last day.
         * 30 req/min
         *
         * @param symbol {@link Api#symbols()} 获取
         * @return
         */
        @GET("v1/pubticker/{symbol}")
        Call<String> ticker(@Path("symbol") String symbol);

        /**
         * Provides a way to access charting candle info
         */

        /**
         * @param timeFrame '1m', '5m', '15m', '30m', '1h', '3h', '6h', '12h', '1D', '7D', '14D', '1M'
         * @param symbol    symbol  eg. tBTCUSD, fBTC
         * @return
         */
        @GET("v2/candles/trade:{tf}:{symbol}/{se}")
        Call<String> kline(@Path("tf") String timeFrame, @Path("symbol") String symbol, @Path("se") String section);

        default WSListener ws() {
            return new WSListener()
                    .url(WS_URL)
                    .parse(Bitfinex::paser);
        }

        List<String> defaultSymbols = Arrays.asList("btcusd", "ltcusd", "ltcbtc", "ethusd", "ethbtc", "etcbtc", "etcusd", "rrtusd", "rrtbtc", "zecusd", "zecbtc", "xmrusd", "xmrbtc", "dshusd", "dshbtc", "btceur", "xrpusd", "xrpbtc", "iotusd", "iotbtc", "ioteth", "eosusd", "eosbtc", "eoseth", "sanusd", "sanbtc", "saneth", "omgusd", "omgbtc", "omgeth", "bchusd", "bchbtc", "bcheth", "neousd", "neobtc", "neoeth", "etpusd", "etpbtc", "etpeth", "qtmusd", "qtmbtc", "qtmeth", "avtusd", "avtbtc", "avteth", "edousd", "edobtc", "edoeth", "btgusd", "btgbtc", "datusd", "datbtc", "dateth", "qshusd", "qshbtc", "qsheth", "yywusd", "yywbtc", "yyweth", "gntusd", "gntbtc", "gnteth", "sntusd", "sntbtc", "snteth", "ioteur", "batusd", "batbtc", "bateth", "mnausd", "mnabtc", "mnaeth", "funusd", "funbtc", "funeth", "zrxusd", "zrxbtc", "zrxeth", "tnbusd", "tnbbtc", "tnbeth", "spkusd", "spkbtc", "spketh");

        default WSListener wsAll() throws IOException {
            List<String> body = symbols().execute().body();

            WSListener ws = ws();
            for (String symbol : Optional.ofNullable(body).orElse(defaultSymbols)) {
                String s = symbol.toUpperCase();
                ws.send(MarketSubscibe.toJson(s));
                ws.send(KlineSubscribe1m.toJson(s));
                ws.send(KlineSubscribe1D.toJson(s));
                ws.send(TradeSubscribe.toJson(s));
            }

            return ws;
        }
    }

    private static HashMap<Integer, Subscribe> cache = new HashMap<>();

    private static WSListener.Info paser(String text) {

        return Optional.of(text)
                .filter(s -> !s.contains("hb") || !s.contains("info"))
                .filter(Bitfinex::cacheSubscribe)
                .map(JSON::parse)
                .filter(JSONArray.class::isInstance)
                .map(o -> mapper(((JSONArray) o)))
                .orElse(null);
    }

    private static boolean cacheSubscribe(String text) {
        if (text.contains("subscribed")) {
            Subscribe subscribe = JSON.parseObject(text, Subscribe.class);
            if (subscribe.pair != null) {
                subscribe.coin = subscribe.pair.substring(0, 3);
                subscribe.unit = subscribe.pair.substring(3, 6);
            }
            if (subscribe.key != null) {
                String[] keys = subscribe.key.split(":");
                subscribe.coin = keys[2].substring(1, 4);
                subscribe.unit = keys[2].substring(4, 7);
                subscribe.kline = keys[1];
            }
            cache.put(subscribe.chanId, subscribe);
            return false;
        }
        // go on if event is not subscribed
        return true;
    }

    private static WSListener.Info mapper(JSONArray o) {
        Subscribe sub = cache.get(o.getInteger(0));
        WSListener.Info<String> info = new WSListener.Info<>();
        info.coin = sub.coin;
        info.unit = sub.unit;
        info.type = sub.channel;
        info.kline = sub.kline;
        info.data = o.getString(1);
        return info;
    }

    @Data
    private static class Subscribe {
        private String event;
        private String channel;
        private int chanId;
        private String pair;
        private String key;

        private String coin;
        private String unit;
        private String kline;
    }

    /**
     * 订阅行情
     */
    @Data
    static class MarketSubscibe {
        private String event = "subscribe";
        private String channel = "ticker";
        private int chanId;
        private String pair;

        public static String toJson(String pair) {
            MarketSubscibe marketSubscibe = new MarketSubscibe();
            marketSubscibe.pair = pair.toUpperCase();
            return JSON.toJSONString(marketSubscibe);
        }
    }

    /**
     * 订阅K线
     */
    //{"event":"subscribe","channel":"candles","key":"trade:1m:tBTCUSD"}
    @Data
    static class KlineSubscribe1m {
        private String event = "subscribe";
        private String channel = "candles";
        private int chanId;
        private String key = "trade:1m:t";

        public static String toJson(String pair) {
            KlineSubscribe1m klineSubscribe1m = new KlineSubscribe1m();
            klineSubscribe1m.key += pair.toUpperCase();
            return JSON.toJSONString(klineSubscribe1m);
        }
    }

    /**
     * 订阅K线
     */
    //{"event":"subscribe","channel":"candles","key":"trade:1m:tBTCUSD"}
    @Data
    static class KlineSubscribe1D {
        private String event = "subscribe";
        private String channel = "candles";
        private int chanId;
        private String key = "trade:1D:t";

        public static String toJson(String pair) {
            KlineSubscribe1m klineSubscribe1m = new KlineSubscribe1m();
            klineSubscribe1m.key += pair.toUpperCase();
            return JSON.toJSONString(klineSubscribe1m);
        }
    }

    /**
     * 订阅交易
     */
    //订阅实例： {"event":"subscribe","pair":"BTCUSD","channel":"trades"}
    //第一次返回实例：{"event":"subscribed","channel":"trades","chanId":2,"symbol":"tBTCUSD","pair":"BTCUSD"}
    @Data
    static class TradeSubscribe {
        private String event = "subscribe";
        private String channel = "trades";
        private int chanId;
        private String pair;

        public static String toJson(String pair) {
            TradeSubscribe tradeSubscribe = new TradeSubscribe();
            tradeSubscribe.pair = pair.toUpperCase();
            return JSON.toJSONString(tradeSubscribe);
        }
    }


    public static Api bitfinexApi = new Retrofit.Builder()
            .baseUrl(Api.BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(new Retrofit2ConverterFactory())
            .build()
            .create(Api.class);

    public static void main(String[] args) {
        try {
            bitfinexApi.wsAll()
                    .message(info -> System.out.println("info:" + info))
                    .start();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

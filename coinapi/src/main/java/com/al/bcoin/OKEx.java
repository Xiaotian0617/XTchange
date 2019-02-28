package com.al.bcoin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.retrofit.Retrofit2ConverterFactory;
import lombok.Data;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * okex.com api
 * doc url: https://github.com/okcoin-okex/API-docs-OKEx.com
 *
 * <code>
 * okexApi.ws()
 *        .send("{'event':'addChannel','channel':'ok_sub_futureusd_btc_kline_this_week_1min'}") //可以重复调用，也可以传list
 *        .parse()
 *        .message(info -> System.out.println("info:" + info))       //获取message信息
 *        .event("message", (webSocket, s) -> System.out.println("raw message:" + s))  //可以message事件获取
 *        .start();
 * </code>
 *
 *
 *
 */
public class OKEx {

    public interface Api {

        String WS_URL = "wss://real.okex.com:10440/websocket/okexapi";
        String REST_BASE_RUL = "https://www.okex.com/api/v1/";
        String[] FUTURE_SYMBOL = {"btc", "ltc", "eth", "etc", "bch", "xrp", "eos", "btg"};
        String[] CONTRACT_TYPE = {"this_week", "next_week", "quarter"};

        // X:symbol
        List<String> spotChannels = Arrays.asList(
                "ok_sub_spot_X_ticker",
                "ok_sub_spot_X_deals",
                "ok_sub_spot_X_kline_1min",
                "ok_sub_spot_X_kline_1day"
        );

        // Y:this_week/next_week/quarter
        List<String> futureChannels = Arrays.asList(
                "ok_sub_futureusd_X_ticker_Y",
                "ok_sub_futureusd_X_trade_Y",
                "ok_sub_futureusd_X_kline_Y_1min",
                "ok_sub_futureusd_X_kline_Y_1day"
        );


        /**
         * 获取OKEX合约行情
         *
         * @param symbol 交易对
         * @param type   合约类型: this_week:当周   next_week:下周   quarter:季度
         * @return
         */
        @GET("future_ticker.do")
        Call<String> ticker(@Query("symbol") String symbol, @Query("contract_type") String type);


        /**
         * 获取OKEX合约深度信息
         *
         * @param symbol 交易对
         * @param type   合约类型: this_week:当周   next_week:下周   quarter:季度
         * @param size   1-200
         * @param merge  可不传，默认0 ，1为合并深度
         * @return asks:卖方深度 bids:买方深度
         */
        @GET("future_depth.do")
        Call<String> depth(@Query("symbol") String symbol
                , @Query("contract_type") String type
                , @Query("size") Integer size
                , @Query("merge") Integer merge);

        /**
         * 获取OKEX合约交易记录信息
         *
         * @param symbol 交易对
         * @param type   合约类型: this_week:当周   next_week:下周   quarter:季度
         * @return
         */
        @GET("future_trades.do")
        Call<String> trades(@Query("symbol") String symbol
                , @Query("contract_type") String type);


        /**
         * @param symbol 交易对，如 ltc_btc 等
         * @return
         */
        @GET("ticker.do")
        Call<String> ticker(@Query("symbol") String symbol);

        /**
         * @param symbol 交易对，如 ltc_btc 等
         * @return
         */
        @GET("depth.do")
        Call<String> depth(@Query("symbol") String symbol);


        /**
         * @param symbol 交易对，如 ltc_btc 等
         * @param since  可传空(默认返回最近成交600条)
         * @return
         */
        @GET("trades.do")
        Call<String> trades(@Query("symbol") String symbol, @Query("since") Long since);

        /**
         * @param symbol 交易对，如 ltc_btc 等
         * @param type   如 1min 指1分钟
         * @param size   指定获取数据的条数,默认全部获取
         * @param ts     时间戳，返回该时间戳以后的数据(例如1417536000000) 默认全部获取
         * @return
         */
        @GET("kline.do")
        Call<String> kline(@Query("symbol") String symbol,
                           @Query("type") String type,
                           @Query("size") Integer size,
                           @Query("since") Long ts);

        @GET("https://www.okex.com/v2/spot/markets/products")
        Call<Products> products();

        /**
         * okex websocket接口, {@link WSListener#start()} 方法最后调用
         */
        default WSListener ws() {
            return new WSListener()
                    .url(WS_URL)
                    .ping("{'event':'ping'}", 30)
                    .parse(OKEx::parse);
        }

        /**
         * okex websocket接口, {@link WSListener#start()} 方法最后调用
         */
        default WSListener wsAll() throws Exception {
            Products body = products().execute().body();
            WSListener listener = ws();

            body.data.stream()
                    .filter(symbol -> symbol.online == 1)
                    .map(Products.Symbol::getSymbol)
                    .flatMap(symbol -> spotChannels.stream().map(ch -> ch.replace("X", symbol)))
                    .map(s -> String.format("{'event':'addChannel','channel':'%s'}", s))
                    .forEach(listener::send);


            futureChannels.stream()
                    .flatMap(ch -> Arrays.stream(FUTURE_SYMBOL).map(symbol -> ch.replace("X", symbol)))
                    .flatMap(ch -> Arrays.stream(CONTRACT_TYPE).map(contract -> ch.replace("Y", contract)))
                    .map(s -> String.format("{'event':'addChannel','channel':'%s'}", s))
                    .forEach(listener::send);


            return listener;
        }
    }

    private static final Pattern PATTERN = Pattern.compile("ok_sub_(spot|futureusd)_(.+)_(ticker|depth|deals|trades|kline)_?(this_week|next_week|quarter)?_?(1min|1day)?");

    public static WSListener.Info parse(String text) {
        try {
            if (!text.startsWith("[")) return null;
            JSONObject obj = JSON.parseArray(text).getJSONObject(0);
            String channel = obj.getString("channel");

            Matcher matcher = PATTERN.matcher(channel);
            if (!matcher.find() || matcher.groupCount() != 5) return null;

            WSListener.Info info = new WSListener.Info();
            info.spotFu = matcher.group(1);
            String[] symbol = matcher.group(2).split("_");
            info.coin = symbol[0];
            if ("futureusd".equals(info.spotFu)) {
                info.unit = "usd";
            } else {
                info.unit = symbol[1];
            }

            info.type = matcher.group(3);
            info.contract = matcher.group(4);
            info.kline = matcher.group(5);
            info.data = obj.getString("data");
            return info;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    public static Api okexApi = new Retrofit.Builder()
            .baseUrl(Api.REST_BASE_RUL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(new Retrofit2ConverterFactory())
            .build()
            .create(Api.class);

    @Data
    public static class Products {
        int code;
        List<Symbol> data;

        @Data
        public static class Symbol {
            int online;
            String symbol;
        }
    }

    public static void main(String[] args) {
        try {

            //订阅所有信息，包括所有币币和合约的 行情，交易和K线(1min和1day)

//            okexApi.wsAll()
//                    .message(info -> System.out.println("info:" + info))
//                    .start();

            //自定义订阅
            okexApi.ws()
                    .send("{'event':'addChannel','channel':'ok_sub_futureusd_btc_kline_this_week_1min'}") // send可以重复调用，也可以传list
                    .message(info -> System.out.println("info:" + info))       // 获取解析后的message信息
                    .event("message", (webSocket, s) -> System.out.println("raw message:" + s))  // 可以通过message事件获取原始字符串
                    .start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.al.bcoin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.support.retrofit.Retrofit2ConverterFactory;
import lombok.Data;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AiCoin {

    /**
     * aicoin api 接口
     */
    public interface Api {

        /**
         * 获取aicoin所有信息，包括交易所，交易对
         */
        @GET("https://www.aicoin.net.cn/api/markets-all")
        @Headers({
                "referer: https://www.aicoin.net.cn/",
                "user-agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36"
        })
        Call<MarketAll> getMarketAll();


        /**
         * 获取aicoin 最新K线信息
         *
         * @param symbol 交易对，对应marketall中的coins key
         * @param step   K线间隔时间 秒为单位，如1分钟K线为60，1天为86400
         */
        @GET("https://widget.aicoin.net.cn/chart/api/data/period")
        @Headers({
                "referer: https://widget.aicoin.net.cn/chart/",
                "user-agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36"
        })
        Call<KlineInfo> getKline(@Query("symbol") String symbol, @Query("step") Integer step);


        /**
         * 获取历史K线
         *
         * @param symbol 交易对，对应marketall中的coins key
         * @param step   K线间隔时间 秒为单位，如1分钟K线为60，1天为86400
         * @param time   K线向前历史翻页，1为向前翻一页
         * @param count  getKline请求时返回的count值
         * @return
         */
        @POST("https://widget.aicoin.net.cn/chart/api/data/periodHistory")
        @Headers({
                "origin: https://widget.aicoin.net.cn",
                "referer: https://widget.aicoin.net.cn/chart/",
                "user-agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36"
        })
        Call<List<String>> getHistoryKline(@Query("symbol") String symbol,
                                           @Query("step") Integer step,
                                           @Query("times") Integer time,
                                           @Query("count") String count);


        /**
         * 连续获取历史K线, 由于需要一页一页向前翻页，所以通过回调listener来获取结果
         *
         * @param step     k线间隔时间
         * @param listener k线获取回调
         * @param filter   过滤交易所，如所有交易所的都需要，传null
         */
        default void getKlineAll(Integer step, KlineListener listener, Predicate<Coin> filter) throws IOException, InterruptedException {
            MarketAll market = getMarketAll().execute().body();
            System.out.println("total coins:" + market.coins.size());
            for (Coin coin : market.coins.values()) {
                if (filter != null && !filter.test(coin)) continue;
                getKlineByCoin(coin, step, listener);
                Thread.sleep(1000);
            }
        }

        /**
         * 获取某个交易对所有历史K线
         */
        default void getKlineByCoin(Coin coin, Integer step, KlineListener listener) throws IOException, InterruptedException {
            KlineInfo info = getKline(coin.symbol, step).execute().body();
            listener.kline(coin, info.data.stream().map(Kline::new).collect(Collectors.toList()));
            int time = 1;
            String count = info.count;
            while (true) {
                List<String> result = getHistoryKline(coin.symbol, step, time++, count).execute().body();
                if (result == null || result.size() == 0) break;
                listener.kline(coin, result.stream().map(Kline::new).collect(Collectors.toList()));
                Thread.sleep(1000);
            }
        }
    }

    /**
     * k线抓取listener
     */
    public interface KlineListener {
        void kline(Coin coin, List<Kline> kline);
    }

    @Data
    public static class MarketAll {
        private HashMap<String, Coin> coins;
    }

    @Data
    public static class KlineInfo {
        private String count;
        private List<String> data;
    }

    @Data
    public static class Coin {
        private String coin;  //币种
        private String currency; //交易币种
        private String fullName; //币种全称
        private String symbol;  //交易所+币种+交易币种
        private String mid;     //交易所名
    }

    @Data
    public static class Kline {
        private String ts; //timestamp
        private BigDecimal open;
        private BigDecimal high;
        private BigDecimal low;
        private BigDecimal close;
        private BigDecimal vol;

        public Kline(String klineStr) {
            JSONArray parse = JSON.parseArray(klineStr);
            ts = parse.getString(0);
            open = parse.getBigDecimal(1);
            high = parse.getBigDecimal(2);
            low = parse.getBigDecimal(3);
            close = parse.getBigDecimal(4);
            vol = parse.getBigDecimal(5);
        }
    }

    public static Api AiCoinApi = new Retrofit.Builder()
            .baseUrl("https://empty")
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(new Retrofit2ConverterFactory())
            .build()
            .create(Api.class);


    public static void main(String[] args) {
        try {
            KlineListener listener = (coin, kline) -> System.out.println("done! 交易对:" + coin + ",k线：" + kline);

            int oneday = 86400;
            // 获取aicoin所有K线信息，最后一个参数为filter, 传空表示取所有交易所交易对K线信息
            AiCoinApi.getKlineAll(oneday, listener, coin -> coin.mid.contains("bitfinex"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

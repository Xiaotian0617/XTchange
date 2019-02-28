package com.al.dbspider.base.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface AiCoin {

    String[] tabs = {"bigone","okex","binance","zb","gate","bitfinex","bitflyer","huobipro","bibox","bitstamp","coinegg","rightbtc","poloniex","bittrex","bitmex","liqui","kraken","aex","others"};

    /**
     * https://www.aicoin.net.cn/api/mobile/home?column=default&tab=bigone
     * 手机版主页接口
     * @return
     */
    @GET("https://www.aicoin.net.cn/api/mobile/home?column=default&tab=bigone")
    Call<String> pairs(@Query("tab") String tab);

    /**
     * https://widget.aicoin.net.cn/chart/api/data/period?symbol=okcoinfuturesbtcquarterusd&step=900
     * @param symbol aicoin币symbol
     * @param second k线类型，s为单位，如1分钟K线就传60
     * @return
     */
    @GET("chart/api/data/period")
    Call<String> kline(@Query("symbol") String symbol, @Query("step") int second);

    default Call<String> kline(String symbol){
        return kline(symbol,60);
    }

    default List<Call<String>> allPairs(){
        return Stream.of(tabs).map(this::pairs).collect(Collectors.toList());
    }

}

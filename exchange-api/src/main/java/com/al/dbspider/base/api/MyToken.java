package com.al.dbspider.base.api;


import org.apache.commons.codec.digest.DigestUtils;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * http://app.mytoken.io/
 */
public interface MyToken {

    //https://api2.mytoken.org/market/topmarketlist?timestamp=1516766687198&code=b855ceba8415b77d530d250e42f7f686&v=1.4.0&platform=m&
    @GET("market/topmarketlist/?v=1.4.0&platform=m")
    @Headers("user-agent:Mozilla/5.0 (iPhone; CPU iPhone OS 9_1 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Version/9.0 Mobile/13B143 Safari/601.1")
    Call<String> marketList(@Query("timestamp") Long ts, @Query("code") String code);

    default Call<String> marketList() {
        long ts = System.currentTimeMillis();
        return marketList(ts, code(ts));
    }

    /**
     * https://api2.mytoken.org/currency/kline?market_id=126&symbol=BTC&anchor=USD&period=15m&timestamp=1516774993820&code=05d660e5e483f0c7b7fccc78b637be23&v=1.4.0&platform=m&
     *
     * @param marketId
     * @param symbol
     * @param unit
     * @param ts
     * @param type     1m
     * @param code
     * @return
     */
    @GET("currency/kline/?v=1.4.0&platform=m")
    Call<String> kline(@Query("market_id") String marketId,
                       @Query("symbol") String symbol,
                       @Query("anchor") String unit,
                       @Query("period") String type,
                       @Query("limit") int limit,
                       @Query("timestamp") Long ts,
                       @Query("code") String code);

    default Call<String> kline(String marketId, String symbole, String unit) {
        long ts = System.currentTimeMillis();
        return kline(marketId, symbole, unit, "1m", 10, ts, code(ts));
    }

    //https://api2.mytoken.org/ticker/pairlist?page=1&market_id=338&timestamp=1516856937176&code=47e2619e8dc581edb1b4ba30be0dbe22&v=1.4.0&platform=m
    @GET("ticker/pairlist/?v=1.4.0&platform=m")
    Call<String> pair(@Query("market_id") String marketId,
                      @Query("page") int page,
                      @Query("timestamp") Long ts,
                      @Query("code") String code);

    default Call<String> pair(String marketId, int page) {
        long ts = System.currentTimeMillis();
        return pair(marketId, page, ts, code(ts));
    }

    /**
     * 计算mytoken中的验证参数.
     * code = md5(t+'9527'+t.substr(0,6));
     * 其中t为当前时间戳字符串, 加上9527再加上t的前6位，计算md5即为code
     *
     * @param ts 当前时间戳
     * @return code
     */
    default String code(Long ts) {
        String t = String.valueOf(ts);
        return DigestUtils.md5Hex(t.concat("9527").concat(t.substring(0, 6)));
    }
}

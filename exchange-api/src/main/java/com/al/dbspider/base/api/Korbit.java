package com.al.dbspider.base.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.Arrays;
import java.util.List;

/**
 * file:spider
 * <p>
 * 文件简要说明
 *
 * @author 10:52  王楷
 * @version 10:52 V1.0
 * @par 版权信息：
 * 2018 Copyright 河南艾鹿网络科技有限公司 All Rights Reserved.
 */
public interface Korbit {

    List<String> list = Arrays.asList("btc_krw","btc_krw","btg_krw","etc_krw","eth_krw","xrp_krw");

    /**
     * Returns the ticker for all markets.
     *
     * @return
     */
    @GET("v1/ticker")
    Call<String> getTickerAll(@Query("currency_pair") String symbol);

}

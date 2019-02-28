package com.okcoin.okex.open.api.service.swap.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.okcoin.okex.open.api.bean.spot.result.Ledger;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

/**
 * NOTE:
 *
 * @Version 1.0
 * @Since JDK1.8.191
 * @Author mr.wang
 * @Company Henan ailu
 * @Date 2019-01-08 14:02
 */
public interface SwapTradeAPI {

    @GET("/api/swap/v3/position")
    Call<String> getPosition();

    @GET("/api/swap/v3/{instrument_id}/position")
    Call<JSONObject> getInstrumentPosition(@Path("instrument_id") String instrumentId);

    @GET("/api/swap/v3/accounts")
    Call<JSONObject> getAccounts();

    @GET("/api/swap/v3/{currency}/accounts/")
    Call<JSONObject> getAccountsByCurrency(@Path("currency") String currency);

    @GET("/api/swap/v3/orders/{instrument_id}")
    Call<JSONObject> getOrders(@Path("instrument_id") String instrumentId, @Query("status") Integer status,
                               @Query("from") Integer from, @Query("to") Integer to, @Query("limit") Integer limit);

    @GET("/api/swap/v3/accounts/{instrument_id}/ledger")
    Call<JSONArray> getLedger(@Path("instrument_id") String instrumentId,
                              @Query("from") Integer from, @Query("to") Integer to, @Query("limit") Integer limit);


}

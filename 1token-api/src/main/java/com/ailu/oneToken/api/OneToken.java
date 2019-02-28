package com.ailu.oneToken.api;

import com.ailu.oneToken.service.impl.AccountServiceImpl;
import com.alibaba.fastjson.JSONObject;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * NOTE:
 *
 * @Version 1.0
 * @Since JDK1.8
 * @Author mr.wang
 * @Company Henan ailu
 * @Date 2018/12/13 17:09
 */
public interface OneToken {

    String baseUrl = "https://1token.trade/api/v1/";

    @GET("quote/single-tick/{exchange}/{contract}")
    Call<String> getTickByExchange(@Path("exchange") String exchange,@Path("contract") String contract);

    @GET("quote/ticks?")
    Call<String> getTicksByExchange(@Query("exchange") String exchange);

    @GET("basic/support-exchanges-v2")
    Call<String> getSupportExchanges();

    @GET("basic/contracts")
    Call<String> getContracts(@Query("exchange") String exchange);

    @GET("trade/{exchange}/{accountName}/orders")
    Call<String> getOrders(@Path("exchange") String exchange, @Path("accountName") String accountName);

    @GET("trade/{exchange}/{accountName}/dealt-order/orders?")
    Call<String> getOrdersHistory(@Path("exchange") String exchange, @Path("accountName") String accountName,@Query("start") Long start,@Query("end") Long end,@Query("state") String state);

    @GET("trade/{exchange}/{accountName}/orders?")
    Call<String> getOrders(@Path("exchange") String exchange, @Path("accountName") String accountName,
                           @Query("state") String state,@Query("client_oid") String client_oid,@Query("exchange_oid") String exchange_oid,@Query("contract") String contract);

    @GET("trade/{exchange}/{accountName}/trans")
    Call<String> getTrans(@Path("exchange") String exchange,@Path("accountName") String accountName);

    @GET("trade/{exchange}/{accountName}/dealt-order/trans")
    Call<String> getTransHistory(@Path("exchange") String exchange, @Path("accountName") String accountName,@Query("start") Long start,@Query("end") Long end);

    @GET("trade/{exchange}/{accountName}/trans?")
    Call<String> getTrans(@Path("exchange") String exchange,@Path("accountName") String accountName,@Query("count") String count,@Query("contract") String contract);

    @GET("trade/{exchange}/{accountName}/info")
    Call<String> getInfo(@Path("exchange") String exchange,@Path("accountName") String accountName);

    /**
     * 下单
     * {
     *   "contract": "string",
     *   "bs": "b",
     *   "price": 0,
     *   "amount": 0,
     *   "client_oid": "string",
     *   "options": {
     *     "additionalProp1": "string",
     *     "additionalProp2": "string",
     *     "additionalProp3": "string"
     *   }
     * }
     * @param exchange
     * @param accountName
     * @param jsonObject
     * @return
     */
    @POST("trade/{exchange}/{accountName}/orders")
    Call<String> placeOrder(@Path("exchange") String exchange, @Path("accountName") String accountName, @QueryMap JSONObject jsonObject);


    /**
     * 取消订单
     * @param exchange
     * @param accountName
     * @param exchangeOid
     * @param clientOid
     * @return
     */
    @DELETE("trade/{exchange}/{accountName}/orders")
    Call<String> cancelOrder(@Path("exchange") String exchange, @Path("accountName") String accountName, @Query("client_oid") String clientOid,@Query("exchange_oid") String exchangeOid);

    /**
     * 取消全部订单
     * @param exchange
     * @param accountName
     * @param contract
     * @return
     */
    @DELETE("trade/{exchange}/{accountName}/orders/all")
    Call<String> cancelAllOrder(@Path("exchange") String exchange, @Path("accountName") String accountName, @Query("contract") String contract);




    /**
     * Generate a new sub account of the given parent account.
     *
     * @return a new sub account which associate with 1token's parent account.
     *
     * @see {@link AccountServiceImpl#genNewSubAccount}
     */
    @POST("user/add-account")
    Call<String> genNewSubAccount(@Body JSONObject jsonObject);


    /**
     * Add asset to a sub account.
     * @param exchange      exchange.
     * @param subAccount    sub account
     * @param jsonObject    body params.
     * @return
     *
     * @see {@link AccountServiceImpl#addAsset2SubAccount}
     */
    @POST("user/account/{exchange}/{sub_account}/add-asset")
    Call<String> addAsset2SubAccount(@Path("exchange") String exchange,
                                     @Path("sub_account")String subAccount,
                                     @Body JSONObject jsonObject);


    /**
     * Get sub account list.
     * @param category
     * @param parent    parent account.
     * @return
     */
    @GET("user/accounts-v2")
    Call<String> getSubAccountList(@Query("category")String category,
                                   @Query("parent")String parent);


    /**
     * Generate a tx address associate with given currency.
     * @param currency  currency of the address, e.g. eth
     * @return
     */
    @POST("premium/wallet/address")
    Call<String> genCurrencyAddress(@Query("currency")String currency);


    /**
     * query the list of the given currency.
     * @param currency  currency of the address, e.g. eth
     * @return
     */
    @GET("premium/wallet/address")
    Call<String> getCurrencyAddressList(@Query("currency")String currency);

}

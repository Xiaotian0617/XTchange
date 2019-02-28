package com.ailu.bitmex.api;

import com.ailu.bitmex.bean.account.*;
import com.ailu.bitmex.bean.marketdata.BitmexPrivateOrder;
import com.ailu.bitmex.bean.marketdata.BitmexPublicOrder;
import com.ailu.bitmex.bean.marketdata.BitmexPublicTrade;
import com.ailu.bitmex.bean.marketdata.results.BitmexSymbolsAndPromptsResult;
import com.ailu.bitmex.bean.trade.BitmexPosition;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.Date;
import java.util.List;

/**
 * NOTE:
 *
 * @Version 1.0
 * @Since JDK1.8
 * @Author mr.wang
 * @Company Henan ailu
 * @Date 2018/12/13 17:09
 */
public interface Bitmex {

    String baseReq = "https://www.bitmex.com";

    String baseUrl = "https://www.bitmex.com/";


    @GET("api/v1/user")
    Call<BitmexAccount> getAccount();

    @GET("api/v1/user/wallet")
    Call<BitmexWallet> getWallet(@Query("currency") String currency);

    // Get a history of all of your wallet transactions (deposits, withdrawals, PNL)

    @GET("api/v1/user/walletHistory")
    Call<List<BitmexWalletTransaction>> getWalletHistory(@Query("count") String count, @Query("start") String start, @Query("reverse") String reverse);

    @GET("api/v1/user/walletHistory")
    Call<List<BitmexWalletTransaction>> getWalletHistory(@Query("currency") String currency);

    // Get a summary of all of your wallet transactions (deposits, withdrawals, PNL)

    @GET("api/v1/user/walletSummary")
    Call<List<BitmexWalletTransaction>> getWalletSummary(@Query("currency") String currency);

    @GET("api/v1/user/margin")
    Call<BitmexMarginAccount> getMarginAccountStatus(@Query("currency") String currency);

    @GET("api/v1/user/margin?currency=all")
    Call<List<BitmexMarginAccount>> getMarginAccountsStatus();

    @GET("api/v1/trade")
    Call<BitmexPublicTrade[]> getTrades(@Query("symbol") String currencyPair, @Query("reverse") Boolean reverse);

    @GET("api/v1/orderBook/L2")
    Call<BitmexPublicOrder[]> getDepth(@Query("symbol") String currencyPair, @Query("depth") Double depth);

    @GET("api/v1/position")
    Call<List<BitmexPosition>> getPositions();

    @GET("api/v1/position")
    Call<List<BitmexPosition>> getPositions(@Query("filter") String filter);

    @GET("api/v1/instrument")
    Call<List<BitmexTicker>> getTickers(@Query("count") Integer count,
                                  @Query("start") Integer start,
                                  @Query("reverse") Boolean reverse);

    @GET("api/v1/instrument")
    Call<List<BitmexTicker>> getTicker(@Query("filter") String filter);

    @GET("api/v1/instrument/active")
    Call<List<BitmexTicker>> getActiveTickers();

    @GET("api/v1/instrument/activeIntervals")
    Call<BitmexSymbolsAndPromptsResult> getPromptsAndSymbols();

    @GET("api/v1/order")
    Call<List<BitmexPrivateOrder>> getOrders(@Query("symbol") String symbol,@Query("filter") String filter,
                                       @Query("count") Integer count,
                                       @Query("start") Integer start,
                                       @Query("reverse") Boolean reverse,
                                       @Query("startTime") Date startTime,
                                       @Query("endTime") Date endTime);


}

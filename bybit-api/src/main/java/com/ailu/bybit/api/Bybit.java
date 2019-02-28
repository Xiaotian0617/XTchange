package com.ailu.bybit.api;

import com.ailu.bybit.bean.ResultBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

import java.util.Map;

/**
 * NOTE:
 *
 * @Version 1.0
 * @Since JDK1.8
 * @Author mr.wang
 * @Company Henan ailu
 * @Date 2018/12/13 17:09
 */
public interface Bybit {

    String baseReq = "https://";

    //String baseUrl = "https://api-testnet.bybit.com/";
    String baseUrl = "https://api.bybit.com/";

    /**
     * 获取用户仓位
     *
     * @param requestMap
     * @return
     */
    @GET("position/list")
    Call<ResultBody> getPositionList(@QueryMap Map<String, Object> requestMap);

    /**
     * 查询用户杠杆
     *
     * @param requestMap
     * @return
     */
    @GET("user/leverage")
    Call<ResultBody> getLeverage(@QueryMap Map<String, Object> requestMap);

    /**
     * 修改用户杠杆
     *
     * @param requestMap
     * @return
     */
    @POST("user/leverage/save")
    Call<ResultBody> saveLeverAge(@Body Map<String, Object> requestMap);


    /**
     * 更新保证金
     *
     * @param requestMap
     * @return
     */
    @POST("position/change-position-margin")
    Call<ResultBody> changePositionMargin(@Body Map<String, Object> requestMap);


    /**
     * 查询条件委托单
     *
     * @param requestMap
     * @return
     */
    @GET("open-api/stop-order/list")
    Call<ResultBody> getStopOrderList(@QueryMap Map<String, Object> requestMap);

    /**
     * 创建条件委托单
     *
     * @param requestMap
     * @return
     */
    @POST("open-api/stop-order/create")
    Call<ResultBody> stopOrderCreate(@Body Map<String, Object> requestMap);

    /**
     * 撤销条件委托单
     *
     * @param requestMap
     * @return
     */
    @POST("open-api/stop-order/cancel")
    Call<ResultBody> stopOrderCancel(@Body Map<String, Object> requestMap);

    /**
     * 查询活动委托单
     *
     * @param requestMap
     * @return
     */
    @GET("open-api/order/list")
    Call<ResultBody> getOrderList(@QueryMap Map<String, Object> requestMap);

    /**
     * 创建活动委托单
     *
     * @param requestMap
     * @return
     */
    @POST("open-api/order/create")
    Call<ResultBody> createOrder(@QueryMap Map<String, Object> requestMap);

    /**
     * 撤销活动委托单
     *
     * @param requestMap
     * @return
     */
    @POST("open-api/order/cancel")
    Call<ResultBody> cancelOrder(@QueryMap Map<String, Object> requestMap);


}

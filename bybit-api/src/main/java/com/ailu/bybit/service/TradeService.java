package com.ailu.bybit.service;

import com.ailu.bybit.bean.Order;
import com.ailu.bybit.bean.Trans;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.NonNull;
import retrofit2.http.Query;

import java.util.List;

/**
 * NOTE:
 * 1token的交易信息调用服务
 *
 * @Version 1.0
 * @Since JDK1.8
 * @Author mr.wang
 * @Company Henan ailu
 * @Date 2018/12/15 14:21
 */
public interface TradeService {

    /**
     * 创建活动委托单
     *
     * @param apiKey
     * @param secret
     * @param side
     * @param symbol
     * @param orderType
     * @param qty
     * @param price
     * @param timeInForce
     * @return
     */
    Order crateOrder(String apiKey, String secret, String side, String symbol, String orderType, Integer qty, Integer price, String timeInForce);


    /**
     * 撤销活动委托单
     *
     * @param apiKey
     * @param secret
     * @param orderId
     * @return
     */
    Order cancelOrder(String apiKey, String secret, String orderId);

    /**
     * 查询活动委托单
     *
     * @param apiKey
     * @param secret
     * @return
     */
    List<Order> getOrder(String apiKey, String secret);
}

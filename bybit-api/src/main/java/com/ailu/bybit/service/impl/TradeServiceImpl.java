package com.ailu.bybit.service.impl;

import com.ailu.bybit.bean.Order;
import com.ailu.bybit.bean.Position;
import com.ailu.bybit.bean.ResultBody;
import com.ailu.bybit.client.BybitClient;
import com.ailu.bybit.service.BaseService;
import com.ailu.bybit.service.TradeService;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * NOTE:
 *
 * @Version 1.0
 * @Since JDK1.8
 * @Author mr.wang
 * @Company Henan ailu
 * @Date 2018/12/15 15:14
 */
public class TradeServiceImpl implements TradeService, BaseService {

    private BybitClient bybitClient;

    public TradeServiceImpl(BybitClient bybitClient) {
        this.bybitClient = bybitClient;
    }

    @Override
    public Order crateOrder(String apiKey, String secret, String side, String symbol, String orderType, Integer qty, Integer price, String timeInForce) {
        Map<String, Object> param = new HashMap<>();
        param.put("side", side);
        param.put("symbol", symbol);
        param.put("order_type", orderType);
        param.put("qty", qty);
        param.put("price", price);
        param.put("time_in_force", timeInForce);
        Map<String, Object> requestParam = signByRequestParam(param, apiKey, secret);
        ResultBody resultBody = this.bybitClient.client.executeSync(this.bybitClient.api.createOrder(requestParam));
        Object result = resultBody.getResult();
        return strToModel(result, Order.class);
    }


    @Override
    public Order cancelOrder(String apiKey, String secret, String orderId) {
        Map<String, Object> param = new HashMap<>();
        param.put("order_id", orderId);
        Map<String, Object> requestParam = signByRequestParam(param, apiKey, secret);
        ResultBody resultBody = this.bybitClient.client.executeSync(this.bybitClient.api.cancelOrder(requestParam));
        Object result = resultBody.getResult();
        return strToModel(result, Order.class);
    }

    @Override
    public List<Order> getOrder(String apiKey, String secret) {
        Map<String, Object> requestParam = signByRequestParam(Collections.EMPTY_MAP, apiKey, secret);
        ResultBody resultBody = this.bybitClient.client.executeSync(this.bybitClient.api.getOrderList(requestParam));
        Object result = resultBody.getResult();
        String resultStr = result.toString();
        JSONObject jsonObject = JSONObject.parseObject(resultStr);
        Object data = jsonObject.get("data");
        return strToModels(data, Order.class);
    }

}

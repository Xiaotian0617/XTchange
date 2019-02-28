package com.ailu.bybit.service.impl;

import com.ailu.bybit.bean.Position;
import com.ailu.bybit.bean.ResultBody;
import com.ailu.bybit.bean.StopOrder;
import com.ailu.bybit.client.BybitClient;
import com.ailu.bybit.service.AccountService;
import com.ailu.bybit.service.BaseService;
import com.alibaba.fastjson.JSONObject;

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
 * @Date 2018/12/15 15:02
 */
public class AccountServiceImpl implements AccountService, BaseService {

    private BybitClient bybitClient;

    public AccountServiceImpl(BybitClient bybitClient) {
        this.bybitClient = bybitClient;
    }


    @Override
    public List<Position> getPosition(String apiKey, String secret) {
        Map<String, Object> requestParam = signByRequestParam(Collections.EMPTY_MAP, apiKey, secret);
        ResultBody resultBody = this.bybitClient.client.executeSync(this.bybitClient.api.getPositionList(requestParam));
        Object result = resultBody.getResult();
        return strToModels(result, Position.class);
    }

    @Override
    public JSONObject getLeverage(String apiKey, String secret) {
        Map<String, Object> requestParam = signByRequestParam(Collections.EMPTY_MAP, apiKey, secret);
        ResultBody resultBody = this.bybitClient.client.executeSync(this.bybitClient.api.getLeverage(requestParam));
        Object result = resultBody.getResult();
        return strToJSONObject(result);
    }

    @Override
    public Boolean saveLeverage(String apiKey, String secret, Integer leverage, String symbol) {
        Map<String, Object> param = new HashMap<>();
        param.put("leverage", leverage);
        param.put("symbol", symbol);
        Map<String, Object> requestParam = signByRequestParam(param, apiKey, secret);
        ResultBody resultBody = this.bybitClient.client.executeSync(this.bybitClient.api.saveLeverAge(requestParam));
        Boolean result = resultBody.getRetCode() == 0 ? true : false;
        return result;
    }

    @Override
    public List<StopOrder> getStopOrderList(String apiKey, String secret) {
        Map<String, Object> requestParam = signByRequestParam(Collections.EMPTY_MAP, apiKey, secret);
        ResultBody resultBody = this.bybitClient.client.executeSync(this.bybitClient.api.getStopOrderList(requestParam));
        Object result = resultBody.getResult();
        String resultStr = result.toString();
        JSONObject jsonObject = JSONObject.parseObject(resultStr);
        Object data = jsonObject.get("data");
        return strToModels(data, StopOrder.class);
    }


}

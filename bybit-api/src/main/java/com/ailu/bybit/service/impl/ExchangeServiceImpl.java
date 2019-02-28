//package com.ailu.bybit.service.impl;
//
//import com.ailu.bybit.api.OneToken;
//import com.ailu.bybit.client.APIClient;
//import com.ailu.bybit.client.BybitClient;
//import com.ailu.bybit.service.BaseService;
//import com.ailu.bybit.service.ExchangeService;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//
///**
// * NOTE:
// *
// * @Version 1.0
// * @Since JDK1.8.191
// * @Author mr.wang
// * @Company Henan ailu
// * @Date 2019-01-08 09:45
// */
//public class ExchangeServiceImpl implements ExchangeService,BaseService {
//
//    private APIClient client;
//    private OneToken api;
//
//    public ExchangeServiceImpl(BybitClient oneTokenClient) {
//        this.client = oneTokenClient.client;
//        this.api = oneTokenClient.api;
//    }
//
//    /**
//     * 根据交易所获取 Ticks 类型
//     *
//     * @param exchange
//     * @return 集合
//     */
//    @Override
//    public JSONArray getTicksByExchange(String exchange) {
//        return strToJSONArray(client.executeSync(this.api.getTicksByExchange(exchange)));
//    }
//
//    /**
//     * 根据交易所和币对获取 Tick 类型
//     *
//     * @param exchange
//     * @param contract
//     * @return
//     */
//    @Override
//    public JSONObject getTickByExchange(String exchange, String contract) {
//        return strToJSONObject(client.executeSync(this.api.getTickByExchange(exchange,contract)));
//    }
//
//    /**
//     * 获取1token支持的交易所信息
//     *
//     * @return
//     */
//    @Override
//    public JSONArray getSupportExchange() {
//        return strToJSONArray(client.executeSync(this.api.getSupportExchanges()));
//    }
//
//    /**
//     * 获取1token支持的全部交易对
//     *
//     * @return
//     */
//    @Override
//    public JSONArray getContracts(String exchange) {
//        return strToJSONArray(client.executeSync(api.getContracts(exchange)));
//    }
//}

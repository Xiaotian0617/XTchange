package com.ailu.oneToken.service.impl;

import com.ailu.oneToken.api.OneToken;
import com.ailu.oneToken.bean.Order;
import com.ailu.oneToken.bean.Trans;
import com.ailu.oneToken.client.APIClient;
import com.ailu.oneToken.client.OneTokenClient;
import com.ailu.oneToken.service.BaseService;
import com.ailu.oneToken.service.TradeService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

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

    private APIClient client;
    private OneToken api;

    public TradeServiceImpl(OneTokenClient oneTokenClient) {
        this.client = oneTokenClient.client;
        this.api = oneTokenClient.api;
    }

    /**
     * 获取订单列表
     * 必填参数 exchange 交易所标识 eg:okex合约 okef,okex现货 okex
     *
     * @param exchange
     * @param accountName
     * @return
     */
    @Override
    public List<Order> getOrders(String exchange, String accountName) {
        return strToModels(this.client.executeSync(this.api.getOrders(exchange,accountName)),Order.class);
    }

    /**
     * 根据请求参数获取订单列表
     * @param exchange
     * @param accountName
     * @param state  订单状态  Available values : waiting, pending, withdrawing, withdrawn, dealt, part-deal-pending, part-deal-withdrawn, part-deal-withdrawing, error-order, active, end
     * @param client_oid  用户定义的订单号，最多支持9个订单号，用逗号分隔
     * @param exchange_oid  交易所生成的订单号，最多支持9个订单号，用逗号分隔
     * @param contract  类似于binance/btc.usdt
     * @return
     */
    @Override
    public List<Order> getOrders(String exchange, String accountName,String state,String client_oid,String exchange_oid,String contract) {
        return strToModels(this.client.executeSync(this.api.getOrders(exchange,accountName,state,client_oid,exchange_oid,contract)),Order.class);
    }

    /**
     * 获取成交历史
     * 必填参数 exchange 交易所标识 eg:okex合约 okef,okex现货 okex
     *
     * @param exchange
     * @param accountName
     * @param start       起始时间 时间戳
     * @param end
     * @return
     */
    @Override
    public List<Trans> getTransHistory(String exchange, String accountName, Long start, Long end) {
        return strToModels(this.client.executeSync(this.api.getTransHistory(exchange,accountName,start,end)),Trans.class);
    }

    /**
     * 获取成交记录列表
     *
     * @param exchange
     * @param accountName
     * @return
     */
    @Override
    public List<Trans> getTrans(String exchange, String accountName) {
        return strToModels(this.client.executeSync(this.api.getTrans(exchange,accountName)),Trans.class);
    }

    /**
     * 根据请求参数获取成交记录列表
     * 必填参数 exchange 交易所标识 eg:okex合约 okef,okex现货 okex
     * @param exchange
     * @param accountName
     * @param count 返回成交记录的条数
     * @param contract  类似于binance/btc.usdt。对于部分交易所，如果不输入此参数可以返回所有交易对的成交记录，根据交易所实际情况而定。
     * @return
     */
    @Override
    public List<Trans> getTrans(String exchange, String accountName, String count, String contract) {
        return strToModels(this.client.executeSync(this.api.getTrans(exchange,accountName,count,contract)),Trans.class);
    }

    /**
     * 获取订单列表
     * 必填参数 exchange 交易所标识 eg:okex合约 okef,okex现货 okex
     *
     * @param exchange
     * @param accountName
     * @param start       起始时间 时间戳
     * @param end
     * @param state       Available values : withdrawn, dealt, part-deal-withdrawn, end
     * @return
     */
    @Override
    public List<Order> getOrdersHistory(String exchange, String accountName, Long start, Long end, String state) {
        return strToModels(this.client.executeSync(this.api.getOrdersHistory(exchange,accountName,start,end,state)),Order.class);
    }

    /**
     * 创建订单
     * 必填参数 exchange 交易所标识 eg:okex合约 okef,okex现货 okex
     *
     * @param exchange
     * @param accountName
     * @param jsonObject
     * @return
     */
    @Override
    public JSONObject placeOrder(String exchange, String accountName, JSONObject jsonObject) {
        return strToModel(this.client.executeSync(this.api.placeOrder(exchange,accountName, jsonObject)),JSONObject.class);
    }

    /**
     * 取消订单
     * @param exchange
     * @param accountName
     * @param clientOid  用户定义的订单号，最多支持9个订单号，用逗号分隔
     * @param exchangeOid  交易所生成的订单号，最多支持9个订单号，用逗号分隔。
     * @return
     */
    @Override
    public JSONArray cancelOrder(String exchange, String accountName, String clientOid, String exchangeOid) {
        return strToModel(this.client.executeSync(this.api.cancelOrder(exchange, accountName, clientOid,exchangeOid)),JSONArray.class);
    }

    /**
     * 取消全部订单
     *
     * @param exchange
     * @param accountName
     * @param contract    eg:  类似于binance/btc.usdt。对于部分交易所，如果不输入此参数可以撤销所有交易对的订单，根据交易所实际情况而定。
     * @return
     */
    @Override
    public JSONObject cancelAllOrder(String exchange, String accountName, String contract) {
        return strToModel(this.client.executeSync(this.api.cancelAllOrder(exchange, accountName, contract)),JSONObject.class);
    }

    private static String getOrderByLexicographic(Map<String, Object> maps) {
        String value = JSON.toJSONString(maps, SerializerFeature.MapSortField);
        return value.replace(":",": ").replace(",",", ");
    }


}

package com.ailu.oneToken.service;

import com.ailu.oneToken.bean.Order;
import com.ailu.oneToken.bean.Trans;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.NonNull;
import retrofit2.http.Query;

import java.util.List;

/**
 * NOTE:
 *  1token的交易信息调用服务
 *
 * @Version 1.0
 * @Since JDK1.8
 * @Author mr.wang
 * @Company Henan ailu
 * @Date 2018/12/15 14:21
 */
public interface TradeService{

    /**
     * 获取订单列表
     * 必填参数 exchange 交易所标识 eg:okex合约 okef,okex现货 okex
     * @return
     */
    List<Order> getOrders(@NonNull String exchange,@NonNull String accountName);


    /**
     * 根据请求参数获取订单列表
     * 必填参数 exchange 交易所标识 eg:okex合约 okef,okex现货 okex
     * @param exchange
     * @param accountName
     * @param state  订单状态  Available values : waiting, pending, withdrawing, withdrawn, dealt, part-deal-pending, part-deal-withdrawn, part-deal-withdrawing, error-order, active, end
     * @param client_oid  用户定义的订单号，最多支持9个订单号，用逗号分隔
     * @param exchange_oid  交易所生成的订单号，最多支持9个订单号，用逗号分隔
     * @param contract  类似于binance/btc.usdt
     * @return
     */
    List<Order> getOrders(@NonNull String exchange,@NonNull String accountName,String state,String client_oid,String exchange_oid,String contract);

    /**
     * 获取成交历史
     * 必填参数 exchange 交易所标识 eg:okex合约 okef,okex现货 okex
     * @param start 起始时间 时间戳
     * @return
     */
    List<Trans> getTransHistory(@NonNull String exchange,@NonNull String accountName,@NonNull Long start,@NonNull Long end);

    /**
     * 获取成交记录列表
     * 必填参数 exchange 交易所标识 eg:okex合约 okef,okex现货 okex
     * @return
     */
    List<Trans> getTrans(@NonNull String exchange, @NonNull String accountName);


    /**
     * 根据请求参数获取成交记录列表
     * 必填参数 exchange 交易所标识 eg:okex合约 okef,okex现货 okex
     * @param exchange
     * @param accountName
     * @param count 返回成交记录的条数
     * @param contract  类似于binance/btc.usdt。对于部分交易所，如果不输入此参数可以返回所有交易对的成交记录，根据交易所实际情况而定。
     * @return
     */
    List<Trans> getTrans(@NonNull String exchange, @NonNull String accountName, String count, String contract);

    /**
     * 获取订单列表
     * 必填参数 exchange 交易所标识 eg:okex合约 okef,okex现货 okex
     * @param start 起始时间 时间戳
     * @param state  Available values : withdrawn, dealt, part-deal-withdrawn, end
     * @return
     */
    List<Order> getOrdersHistory(@NonNull String exchange,@NonNull String accountName,@NonNull Long start,@NonNull Long end,@NonNull String state);


    /**
     *  创建订单
     * 必填参数 exchange 交易所标识 eg:okex合约 okef,okex现货 okex
     * @param exchange
     * @param accountName
     * @param jsonObject
     * @return
     */
    JSONObject placeOrder(@NonNull String exchange, @NonNull String accountName,@NonNull JSONObject jsonObject);

    /**
     * 取消订单
     * @param exchange
     * @param accountName
     * @param clientOid  用户定义的订单号，最多支持9个订单号，用逗号分隔
     * @param exchangeOid  交易所生成的订单号，最多支持9个订单号，用逗号分隔。
     * @return
     */
    JSONArray cancelOrder(@NonNull String exchange, @NonNull String accountName, @Query("client_oid") String clientOid,@Query("exchange_oid") String exchangeOid);

    /**
     * 取消全部订单
     * @param exchange
     * @param accountName
     * @param contract eg:  类似于binance/btc.usdt。对于部分交易所，如果不输入此参数可以撤销所有交易对的订单，根据交易所实际情况而定。
     * @return
     */
    JSONObject cancelAllOrder(@NonNull String exchange, @NonNull String accountName, @Query("contract") String contract);

}

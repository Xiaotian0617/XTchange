package com.ailu.oneToken.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * NOTE:
 *  1token 交易所信息查询
 * @Version 1.0
 * @Since JDK1.8
 * @Author mr.wang
 * @Company Henan ailu
 * @Date 2019年01月08日09:42:44
 */
public interface ExchangeService {

    /**
     * 根据交易所获取 Ticks 类型
     * @param exchange
     * @return 集合
     */
    JSONArray getTicksByExchange(String exchange);

    /**
     * 根据交易所和币对获取 Tick 类型
     * @param exchange
     * @param contract
     * @return
     */
    JSONObject getTickByExchange(String exchange,String contract);

    /**
     * 获取1token支持的交易所信息
     * @return
     */
    JSONArray getSupportExchange();

    /**
     * 获取1token支持的全部交易对
     * @return
     */
    JSONArray getContracts(String exchange);

}

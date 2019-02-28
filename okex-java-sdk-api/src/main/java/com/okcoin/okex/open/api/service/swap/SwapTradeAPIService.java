package com.okcoin.okex.open.api.service.swap;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.okcoin.okex.open.api.bean.futures.CursorPageParams;

/**
 * NOTE:
 *
 * @Version 1.0
 * @Since JDK1.8
 * @Author mr.wang
 * @Company Henan ailu
 * @Date 2018/12/24 14:30
 */
public interface SwapTradeAPIService {

    /**
     * Get the swap contract product position
     *
     * @param instrumentId The id of the futures contract eg: BTC-USD-SWAP"
     */
    JSONObject getInstrumentPosition(String instrumentId);

    String getPosition();

    JSONObject getAccount();

    /**
     * Get all of futures contract order list
     *
     * @param status   Order status: 0: waiting for transaction 1: 1: part of the deal 2: all transactions.
     * @param from    Paging content after requesting this id .
     * @param to     Paging content prior to requesting this id.
     * @param limit    Number of results per request. Maximum 100. (default 100)
     *                 {@link CursorPageParams}
     * @return
     */
    JSONObject getOrders(String instrument_id, Integer status, Integer from, Integer to, Integer limit);


    JSONArray getLegers(String instrument_id, Integer from, Integer to, Integer limit);
}

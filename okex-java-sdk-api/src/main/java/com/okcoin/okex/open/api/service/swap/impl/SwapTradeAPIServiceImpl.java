package com.okcoin.okex.open.api.service.swap.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.okcoin.okex.open.api.client.APIClient;
import com.okcoin.okex.open.api.config.APIConfiguration;
import com.okcoin.okex.open.api.service.swap.SwapTradeAPIService;

/**
 * NOTE:
 *
 * @Version 1.0
 * @Since JDK1.8.191
 * @Author mr.wang
 * @Company Henan ailu
 * @Date 2019-01-08 14:01
 */
public class SwapTradeAPIServiceImpl implements SwapTradeAPIService {

    private APIClient client;
    private SwapTradeAPI api;

    public SwapTradeAPIServiceImpl(APIConfiguration config) {
        this.client = new APIClient(config);
        this.api = client.createService(SwapTradeAPI.class);
    }

    /**
     * Get the swap contract product position
     *
     * @param instrumentId The id of the futures contract eg: BTC-USD-SWAP"
     */
    @Override
    public JSONObject getInstrumentPosition(String instrumentId) {
        return this.client.executeSync(this.api.getInstrumentPosition(instrumentId));
    }

    @Override
    public String getPosition() {
        return this.client.executeSync(this.api.getPosition());
    }

    @Override
    public JSONObject getAccount() {
        return this.client.executeSync(this.api.getAccounts());
    }

    /**
     * Get all of futures contract order list
     *
     * @param instrument_id
     * @param status        Order status: 0: waiting for transaction 1: 1: part of the deal 2: all transactions.
     * @param from          Paging content after requesting this id .
     * @param to            Paging content prior to requesting this id.
     * @param limit         Number of results per request. Maximum 100. (default 100)
     * @return
     */
    @Override
    public JSONObject getOrders(String instrument_id, Integer status, Integer from, Integer to, Integer limit) {
        return this.client.executeSync(this.api.getOrders(instrument_id,status,from,to,limit));
    }

    @Override
    public JSONArray getLegers(String instrument_id, Integer from, Integer to, Integer limit) {
        return this.client.executeSync(this.api.getLedger(instrument_id,from,to,limit));
    }
}

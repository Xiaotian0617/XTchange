package com.ailu.bitmex.service.impl;

import com.ailu.bitmex.bean.BitmexResult;
import com.ailu.bitmex.bean.account.BitmexTicker;
import com.ailu.bitmex.bean.marketdata.BitmexPrivateOrder;
import com.ailu.bitmex.bean.trade.BitmexPosition;
import com.ailu.bitmex.client.BitmexClient;
import com.ailu.bitmex.service.AccountService;
import com.ailu.bitmex.service.BaseService;
import com.ailu.bitmex.service.TradeService;

import java.util.Date;
import java.util.List;

/**
 * NOTE:
 *
 * @Version 1.0
 * @Since JDK1.8
 * @Author mr.wang
 * @Company Henan ailu
 * @Date 2018/12/15 15:02
 */
public class TradeServiceImpl implements TradeService, BaseService {

    private BitmexClient bitmexClient;

    public TradeServiceImpl(BitmexClient bitmexClient) {
        this.bitmexClient = bitmexClient;
    }


     @Override
    public BitmexResult getOrders(String symbol,String filter,
                                          Integer count,
                                          Integer start,
                                          Boolean reverse,
                                          Date startTime,
                                          Date endTime) {
         BitmexResult resultBody = this.bitmexClient.client.executeSync(this.bitmexClient.api.getOrders(symbol,filter, count, start, reverse, startTime, endTime));
        return resultBody;
    }

    @Override
    public BitmexResult getOrders(String symbol,String filter) {
        return getOrders(symbol,filter,null,null,null,null,null);
    }


    @Override
    public BitmexResult getOrders() {
        return getOrders(null,null,null,null,null,null,null);
    }

}

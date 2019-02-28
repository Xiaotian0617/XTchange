package com.ailu.bitmex.service;

import com.ailu.bitmex.bean.BitmexResult;
import com.ailu.bitmex.bean.account.BitmexTicker;
import com.ailu.bitmex.bean.marketdata.BitmexPrivateOrder;
import com.ailu.bitmex.bean.trade.BitmexPosition;

import java.util.Date;
import java.util.List;

/**
 * NOTE:
 * 1token 账户信息调用接口
 *
 * @Version 1.0
 * @Since JDK1.8
 * @Author mr.wang
 * @Company Henan ailu
 * @Date 2018/12/15 14:31
 */
public interface TradeService extends BaseService {

    BitmexResult getOrders(String symbol,
                            String filter,
                            Integer count,
                            Integer start,
                            Boolean reverse,
                            Date startTime,
                            Date endTime);

    BitmexResult getOrders(String symbol,String filter);

    BitmexResult getOrders();

}

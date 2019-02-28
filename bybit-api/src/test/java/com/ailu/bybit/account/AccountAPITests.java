package com.ailu.bybit.account;

import com.ailu.bybit.BaseTests;
import com.ailu.bybit.bean.Account;
import com.ailu.bybit.bean.Order;
import com.ailu.bybit.bean.Position;
import com.ailu.bybit.bean.StopOrder;
import com.ailu.bybit.client.BybitClient;
import com.ailu.bybit.service.AccountService;
import com.ailu.bybit.service.impl.AccountServiceImpl;
import com.ailu.bybit.service.impl.TradeServiceImpl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

@Slf4j
public class AccountAPITests extends BaseTests {

    @Test
    public void getPosition() {
        AccountService accountService = new AccountServiceImpl(new BybitClient(config()));
        List<Position> positions = accountService.getPosition(appKey, secert);
        log.info(JSON.toJSONString(positions));
    }

    @Test
    public void getLeverage() {
        AccountService accountService = new AccountServiceImpl(new BybitClient(config()));
        JSONObject account = accountService.getLeverage(appKey, secert);
        log.info(account.toJSONString());
    }

    @Test
    public void saveLeverage() {
        AccountService accountService = new AccountServiceImpl(new BybitClient(config()));
        Boolean result = accountService.saveLeverage(appKey, secert, 100, "BTCUSD");
        log.info("save leverage : ",result);
    }

    //活动委托单接口调用测试
    @Test
    public void crateOrder() {
        TradeServiceImpl tradeService = new TradeServiceImpl(new BybitClient(config()));
        Order order = tradeService.crateOrder(appKey, secert, "Buy", "BTCUSD", "Limit", 1, 3800, "FillOrKill");
        log.info(JSONObject.toJSONString(order));
    }

    @Test
    public void getOrder() {
        TradeServiceImpl tradeService = new TradeServiceImpl(new BybitClient(config()));
        List<Order> order = tradeService.getOrder(appKey, secert);
        log.info(JSONObject.toJSONString(order));
    }

    @Test
    public void getStopOrderList() {
        AccountService accountService = new AccountServiceImpl(new BybitClient(config()));
        List<StopOrder> stopOrderList = accountService.getStopOrderList(appKey, secert);
        log.info(JSONObject.toJSONString(stopOrderList));
    }

    @Test
    public void cancelOrder() {
        TradeServiceImpl tradeService = new TradeServiceImpl(new BybitClient(config()));
        Order order = tradeService.cancelOrder(appKey, secert, "100005");
        log.info(JSONObject.toJSONString(order));
    }

}

//package com.ailu.bybit.trade;
//
//import com.ailu.bybit.BaseTests;
//import com.ailu.bybit.bean.Order;
//import com.ailu.bybit.bean.Trans;
//import com.ailu.bybit.client.BybitClient;
//import com.ailu.bybit.service.TradeService;
//import com.ailu.bybit.service.impl.TradeServiceImpl;
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Test;
//
//import java.util.List;
//
///**
// * NOTE:
// *
// * @Version 1.0
// * @Since JDK1.8
// * @Author mr.wang
// * @Company Henan ailu
// * @Date 2018/12/15 15:27
// */
//@Slf4j
//public class TradeTest extends BaseTests {
//
//    @Test
//    public void getOrders(){
//        TradeService tradeService = new TradeServiceImpl(new BybitClient(config()));
//        List<Order> orders = tradeService.getOrders("okef", "liujianshu");
//        log.info(JSON.toJSONString(orders));
//    }
//
//    @Test
//    public void getOrderHistory(){
//        TradeService tradeService = new TradeServiceImpl(new BybitClient(config()));
//        Long end = System.currentTimeMillis();
//        Long start = end-900000;
//        List<Order> orders = tradeService.getOrdersHistory("okef", "liujianshu",start,end,"end");
//        log.info(JSON.toJSONString(orders));
//    }
//
//    @Test
//    public void getOrdersByParam(){
//        TradeService tradeService = new TradeServiceImpl(new BybitClient(config()));
//        List<Order> orders = tradeService.getOrders("okef", "liujianshu","active","okef//eth.usd.q-20190109-103606-cqrnkbq670nbj6twm85sa20bxs1","okef//eth.usd.q-2114543081659393",null);
//        log.info(JSON.toJSONString(orders));
//    }
//
//    @Test
//    public void getTrans(){
//        TradeService tradeService = new TradeServiceImpl(new BybitClient(config()));
//        List<Trans> trans = tradeService.getTrans("okef", "liujianshu");
//        log.info(JSON.toJSONString(trans));
//    }
//
//    @Test
//    public void getTransByParam(){
//        TradeService tradeService = new TradeServiceImpl(new BybitClient(config()));
//        List<Trans> trans = tradeService.getTrans("okef", "liujianshu","1",null);
//        log.info(JSON.toJSONString(trans));
//    }
//
//    @Test
//    public void placeOrder(){
//        TradeService tradeService = new TradeServiceImpl(new BybitClient(config()));
//        JSONObject jsonObject = JSON.parseObject("{\"bs\":\"b\",\"amount\":\"1\",\"price\":\"2\",\"contract\":\"okef/eth.usd.q\",\"options\":{\"close\":\"false\"},\"exchange\":\"okef\"}");
//        JSONObject result = tradeService.placeOrder("okef", "liujianshu",jsonObject);
//        log.info(result.toJSONString());
//    }
//
//    @Test
//    public void cancelOrder(){
//        TradeService tradeService = new TradeServiceImpl(new BybitClient(config()));
//        JSONArray jsonArray = tradeService.cancelOrder("okef", "liujianshu", "okef/eth.usd.q-20181217-112304-c3nsh8168lq8wu5rwttx79movzc", null);
//        log.info(jsonArray.toJSONString());
//    }
//
//    @Test
//    public void cancelAllOrder(){
//        TradeService tradeService = new TradeServiceImpl(new BybitClient(config()));
//        JSONObject jsonObject = tradeService.cancelAllOrder("okef", "liujianshu", null);
//        log.info(jsonObject.toJSONString());
//    }
//
//}

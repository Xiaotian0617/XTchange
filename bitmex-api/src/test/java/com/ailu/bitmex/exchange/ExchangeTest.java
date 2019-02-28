//package com.ailu.bitmex.exchange;
//
//import com.ailu.bitmex.BaseTests;
//import com.ailu.bitmex.client.BybitClient;
//import com.ailu.bitmex.service.ExchangeService;
//import com.ailu.bitmex.service.impl.ExchangeServiceImpl;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Test;
//
///**
// * NOTE:
// *
// * @Version 1.0
// * @Since JDK1.8
// * @Author mr.wang
// * @Company Henan ailu
// * @Date 2019年01月08日09:51:43
// */
//@Slf4j
//public class ExchangeTest extends BaseTests {
//
//    @Test
//    public void getTicksByExchange(){
//        ExchangeService exchangeService = new ExchangeServiceImpl(new BybitClient(config()));
//        log.info(exchangeService.getTicksByExchange("okef").toJSONString());
//    }
//
//    @Test
//    public void getTickByExchange(){
//        ExchangeService exchangeService = new ExchangeServiceImpl(new BybitClient(config()));
//        log.info(exchangeService.getTickByExchange("okef","btc.usd.q").toJSONString());
//    }
//
//    @Test
//    public void getSupportExchange(){
//        ExchangeService exchangeService = new ExchangeServiceImpl(new BybitClient(config()));
//        log.info(exchangeService.getSupportExchange().toJSONString());
//    }
//
//    @Test
//    public void getContracts(){
//        ExchangeService exchangeService = new ExchangeServiceImpl(new BybitClient(config()));
//        log.info(exchangeService.getContracts("okef").toJSONString());
//    }
//
//}

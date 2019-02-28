package com.ailu.bitmex.trade;

import com.ailu.bitmex.BaseTests;
import com.ailu.bitmex.bean.BitmexResult;
import com.ailu.bitmex.bean.marketdata.BitmexPrivateOrder;
import com.ailu.bitmex.client.BitmexClient;
import com.ailu.bitmex.service.TradeService;
import com.ailu.bitmex.service.impl.TradeServiceImpl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;

/**
 * NOTE:
 *
 * @Version 1.0
 * @Since JDK1.8
 * @Author mr.wang
 * @Company Henan ailu
 * @Date 2018/12/15 15:27
 */
@Slf4j
public class TradeTest extends BaseTests {

    @Test
    public void getOrders(){
        TradeService tradeService = new TradeServiceImpl(new BitmexClient(config()));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("open",true);
        BitmexResult orders = tradeService.getOrders("xbt",null,30,0,true,null,null);
        log.info(JSON.toJSONString(orders));
    }
}

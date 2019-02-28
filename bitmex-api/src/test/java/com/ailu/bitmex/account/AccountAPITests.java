package com.ailu.bitmex.account;

import com.ailu.bitmex.bean.BitmexResult;
import com.ailu.bitmex.bean.account.BitmexAccount;
import com.ailu.bitmex.bean.account.BitmexMarginAccount;
import com.ailu.bitmex.bean.account.BitmexTicker;
import com.ailu.bitmex.bean.account.BitmexWallet;
import com.ailu.bitmex.bean.trade.BitmexPosition;
import com.ailu.bitmex.client.BitmexClient;
import com.ailu.bitmex.service.AccountService;
import com.ailu.bitmex.service.impl.AccountServiceImpl;
import com.ailu.bitmex.BaseTests;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;

@Slf4j
public class AccountAPITests extends BaseTests {

    @Test
    public void getPosition() {
        AccountService accountService = new AccountServiceImpl(new BitmexClient(config()));
        BitmexResult positions = accountService.getPosition("{\"symbol\": \"XBTM15\"}");
        log.info(JSON.toJSONString(positions));
    }

    @Test
    public void getBitmexWallet() {
        AccountService accountService = new AccountServiceImpl(new BitmexClient(config()));
        BitmexResult xbt = accountService.getWallet("XBt");
        log.info(JSON.toJSONString(xbt));
    }

    @Test
    public void getBitmexMargin() {
        AccountService accountService = new AccountServiceImpl(new BitmexClient(config()));
        BitmexResult xbt = accountService.getMargin("XBt");
        log.info(JSON.toJSONString(xbt));
    }


}

package com.okcoin.okex.open.api.test.swap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.okcoin.okex.open.api.bean.account.param.Transfer;
import com.okcoin.okex.open.api.bean.account.param.Withdraw;
import com.okcoin.okex.open.api.bean.account.result.Currency;
import com.okcoin.okex.open.api.bean.account.result.Wallet;
import com.okcoin.okex.open.api.bean.account.result.WithdrawFee;
import com.okcoin.okex.open.api.bean.spot.result.Ledger;
import com.okcoin.okex.open.api.service.account.AccountAPIService;
import com.okcoin.okex.open.api.service.account.impl.AccountAPIServiceImpl;
import com.okcoin.okex.open.api.service.swap.SwapTradeAPIService;
import com.okcoin.okex.open.api.service.swap.impl.SwapTradeAPIServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.List;

public class SwapAPITests extends SwapAPIBaseTests {

    private static final Logger LOG = LoggerFactory.getLogger(SwapAPITests.class);

    private SwapTradeAPIService swapTradeAPIService;

    @Before
    public void before() {
        this.config = this.config();
        this.swapTradeAPIService = new SwapTradeAPIServiceImpl(this.config) {
        };
    }

    @Test
    public void account(){
        JSONObject account = swapTradeAPIService.getAccount();
        System.out.println(account.toJSONString());
    }

    @Test
    public void getLedger(){
        JSONArray account = swapTradeAPIService.getLegers("ETH-USD-SWAP",null,null,null);
        System.out.println(account.size());
        System.out.println(JSON.toJSONString(account));
    }

    @Test
    public void getPosition(){
        String account = swapTradeAPIService.getPosition();
        System.out.println(account);
    }

    @Test
    public void getInstrumentPosition(){
        JSONObject account = swapTradeAPIService.getInstrumentPosition("ETH-USD-SWAP");
        System.out.println(JSON.toJSONString(account));
    }

}

package com.ailu.oneToken.account;

import com.ailu.oneToken.BaseTests;
import com.ailu.oneToken.bean.Account;
import com.ailu.oneToken.client.OneTokenClient;
import com.ailu.oneToken.enums.AccountEnum;
import com.ailu.oneToken.service.AccountService;
import com.ailu.oneToken.service.impl.AccountServiceImpl;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
public class AccountAPITests extends BaseTests {

    @Test
    public void getAccount(){
        AccountService accountService = new AccountServiceImpl(new OneTokenClient(config()));
        Account account = accountService.getAccount("okef", "liujianshu");
        log.info(JSON.toJSONString(account));
    }





    /**
     * Get account test.
     */
    @Test
    public void getAccountListTest(){
        try {
            accountService.getSubAccountList(AccountEnum.OKEFLDD)
            .stream().forEach(o-> System.out.println(o));
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
    }


    /**
     * Get account list with purge sub account test.
     */
    @Test
    public void getPurgeAccountListTest(){
        try {
            accountService.getPurgeSubAccountList(AccountEnum.OKEFLDD)
                    .stream().forEach(o-> System.out.println(o));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue(false);
        }
    }

    /**
     * Add asset to sub account Test.
     */
    @Test
    public void addAsset2SubAccountTest(){
        try {
           boolean success = accountService.addAsset2SubAccount(AccountEnum.BICOIN.getExchange(),
                   "bicoin_0","eth",BigDecimal.valueOf(0.01));
           Assert.assertTrue(success);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue(false);
        }
    }

    /**
     * Generate a new sub account for specified account test.
     */
    @Test
    public void genNewSubAccountEnumTest(){
        try {
            boolean success = accountService.genNewSubAccount(AccountEnum.BICOIN,"bicoin_9");
            Assert.assertTrue(success);
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
    }

    /**
     * Generate a new sub account for specified account test.
     */
    @Test
    public void genNewCurrencyTxAddressTest(){
        try {
            String addr = accountService.genNewTxAddress("eth");
            System.out.println(addr);
            Assert.assertTrue(addr.length()>0);
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
    }


    /**
     * Generate a new sub account for specified account test.
     */
    @Test
    public void getTxAddressListTest(){
        try {
            List<String> list = accountService.getTxAddressList("eth");
            list.stream().forEach(o-> System.out.println(o));
            Assert.assertTrue(!list.isEmpty());
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
    }


    /**
     * Generate a new sub account for specified account test.
     */

    @Ignore
    @Test
    public void genNewSubAccountTest(){
        try {
            accountService.genNewSubAccount("okex","okex/liujianshu","liujianshu_x");
            Assert.assertTrue(true);
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
    }



    protected static AccountService accountService;
    @BeforeClass
    public static void init(){
        accountService = new AccountServiceImpl(new OneTokenClient(config()));
    }

}

package org.knowm.xchange.bitmex;

import com.alibaba.fastjson.JSON;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.bitmex.dto.account.BitmexMarginAccount;
import org.knowm.xchange.bitmex.dto.account.BitmexWallet;
import org.knowm.xchange.bitmex.dto.account.BitmexWalletTransaction;
import org.knowm.xchange.bitmex.dto.marketdata.BitmexPrivateOrder;
import org.knowm.xchange.bitmex.dto.trade.BitmexPosition;
import org.knowm.xchange.bitmex.service.BitmexAccountService;
import org.knowm.xchange.bitmex.service.BitmexTradeService;
import org.knowm.xchange.dto.account.AccountInfo;
import si.mazi.rescu.HttpStatusIOException;

import java.io.IOException;
import java.util.List;

/**
 * NOTE:
 *
 * @Version 1.0
 * @Since JDK1.8
 * @Author mr.wang
 * @Company 洛阳艾鹿网络有限公司
 * @Date 2018/12/3 15:16
 */
public class test {

    public static void main(String[] args) throws IOException {

        ExchangeSpecification exSpec = new BitmexExchange().getDefaultExchangeSpecification();
        exSpec.setUserName("34387");
        exSpec.setApiKey("qLum40u5ArTB2Dp_MNK5L7wU");
        exSpec.setSecretKey("Va5XwrR5XIcBXu4iu8R5MUMiUH3BehPAlryqxKBPTfJtjR9R");
        //exSpec.setApiKey("i2jK51Vd9yRdLI8pRYSwKkmN");
        //exSpec.setSecretKey("UcMCoSgvSWbw95gWvbyX9T7wk7ix5zkWpVYAav3R2K5iAZT8");
        exSpec.setProxyHost("127.0.0.1");
        exSpec.setProxyPort(1087);
        Exchange bitmex = ExchangeFactory.INSTANCE.createExchange(exSpec);

        try {
            // Get the account information
            BitmexAccountService accountService = new BitmexAccountService(bitmex);

//            AccountInfo accountInfo = accountService.getAccountInfo();
//            System.out.println(accountInfo.toString());



            BitmexWallet wallet = accountService.getWallet();
            System.out.println("wallet:"+JSON.toJSONString(wallet));

            List<BitmexMarginAccount> bitmexMarginAccountsStatus = accountService.getBitmexMarginAccountsStatus();
            System.out.println("accoutnStatus:"+JSON.toJSONString(bitmexMarginAccountsStatus));

            List<BitmexWalletTransaction> bitmexWalletHistory = accountService.getBitmexWalletHistory("0","100","true");
            System.out.println("walletHistory:"+JSON.toJSONString(bitmexWalletHistory));

            BitmexTradeService bitmexTradeService = new BitmexTradeService(bitmex);
            List<BitmexPosition> bitmexPositions = bitmexTradeService.getBitmexPositions();
            System.out.println("postion:"+JSON.toJSONString(bitmexPositions));

            List<BitmexPrivateOrder> bitmexOrders = bitmexTradeService.getBitmexOrders();
            System.out.println("orders:"+JSON.toJSONString(bitmexOrders));
        }catch (HttpStatusIOException e){
            e.printStackTrace();
        }
    }

}

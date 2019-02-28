package org.knowm.xchange.bitfinex.v1;

import com.alibaba.fastjson.JSON;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.bitfinex.v1.dto.account.BitfinexBalancesResponse;
import org.knowm.xchange.bitfinex.v1.dto.trade.BitfinexActivePositionsResponse;
import org.knowm.xchange.bitfinex.v1.service.BitfinexAccountService;
import org.knowm.xchange.bitfinex.v1.service.BitfinexTradeService;
import org.knowm.xchange.dto.account.AccountInfo;
import org.knowm.xchange.dto.trade.OpenOrders;

import java.io.IOException;

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

        ExchangeSpecification exSpec = new BitfinexExchange().getDefaultExchangeSpecification();
        //exSpec.setUserName("34387");
        exSpec.setApiKey("me3yDyg0pF37Ye1LehTzqfOLqsBeSaWoUnMima47pFe");
        exSpec.setSecretKey("tnw1EaWkBbHgom9N3eiwyJ0i3FfcaGy39QHxIbswexQ");
        exSpec.setProxyHost("127.0.0.1");
        exSpec.setProxyPort(1087);
        Exchange bitfinex = ExchangeFactory.INSTANCE.createExchange(exSpec);

        // Get the account information
        BitfinexAccountService accountService = new BitfinexAccountService(bitfinex);

        BitfinexTradeService bitfinexTradeService = new BitfinexTradeService(bitfinex);
        AccountInfo accountInfo = accountService.getAccountInfo();
        System.out.println(accountInfo.toString());

        BitfinexBalancesResponse[] bitfinexAccountInfo = accountService.getBitfinexAccountInfo();
        System.out.println(JSON.toJSONString(bitfinexAccountInfo));

        OpenOrders openOrders = bitfinexTradeService.getOpenOrders();
        System.out.println(JSON.toJSONString(openOrders));

        BitfinexActivePositionsResponse[] bitfinexActivePositions = bitfinexTradeService.getBitfinexActivePositions();
        System.out.println(JSON.toJSONString(bitfinexActivePositions));

    }

}

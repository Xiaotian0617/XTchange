package com.okcoin.okex.open.api.test.margin;

import com.okcoin.okex.open.api.config.APIConfiguration;
import com.okcoin.okex.open.api.enums.I18nEnum;
import com.okcoin.okex.open.api.test.BaseTests;

/**
 * Account api basetests
 *
 * @author hucj
 * @version 1.0.0
 * @date 2018/7/04 18:23
 */
public class MarginAPIBaseTests extends BaseTests {

    public APIConfiguration config() {
        APIConfiguration config = new APIConfiguration();

        config.setEndpoint("https://www.okex.com");


        config.setApiKey("");
        config.setSecretKey("");

        config.setPassphrase("");
        config.setPrint(true);
        config.setI18n(I18nEnum.ENGLISH);
        config.setEnableProxy(true);
        config.setProxyUrl("127.0.0.1");
        config.setProxyPort(1087);
        return config;
    }
    String from = "0";
    String to = "0";
    String limit = "0";
    String status = "all";

    String instrument_id = "ETH-USDT";

}

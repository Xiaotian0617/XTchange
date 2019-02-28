package com.okcoin.okex.open.api.test.account;

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
public class AccountAPIBaseTests extends BaseTests {

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


}

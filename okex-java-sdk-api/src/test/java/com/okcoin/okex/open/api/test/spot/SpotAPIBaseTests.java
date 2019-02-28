package com.okcoin.okex.open.api.test.spot;

import com.okcoin.okex.open.api.config.APIConfiguration;
import com.okcoin.okex.open.api.enums.I18nEnum;
import com.okcoin.okex.open.api.test.BaseTests;

public class SpotAPIBaseTests extends BaseTests {

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

package com.ailu.oneToken;

import com.ailu.oneToken.api.OneToken;
import com.ailu.oneToken.client.OneTokenClient;
import com.ailu.oneToken.config.APIConfiguration;
import com.ailu.oneToken.service.AccountService;
import com.ailu.oneToken.service.impl.AccountServiceImpl;
import org.junit.BeforeClass;

/**
 * Account api basetests
 *
 * @author hucj
 * @version 1.0.0
 * @date 2018/7/04 18:23
 */
public class BaseTests {

    // account
    static String appKey = "";
    static String secert = "";


    public static APIConfiguration config() {
        APIConfiguration config = new APIConfiguration();
        //设置基础url
        config.setEndpoint(OneToken.baseUrl);

        config.setApiKey(appKey);
        config.setSecretKey(secert);
        //设置是否输出请求详细日志
        config.setPrint(true);
        config.setEnableProxy(false);
        config.setProxyUrl("127.0.0.1");
        config.setProxyPort(1087);
        return config;
    }
}

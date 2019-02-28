package com.ailu.bitmex;

import com.ailu.bitmex.api.Bitmex;
import com.ailu.bitmex.config.APIConfiguration;

/**
 * Account api basetests
 *
 * @author hucj
 * @version 1.0.0
 * @date 2018/7/04 18:23
 */
public class BaseTests {

    //测试
    public String appKey = "";
    public String secert = "";

    public APIConfiguration config() {
        APIConfiguration config = new APIConfiguration();
        //设置基础url
        config.setEndpoint(Bitmex.baseUrl);

        config.setApiKey(appKey);
        config.setSecretKey(secert);
        //设置是否输出请求详细日志
        config.setPrint(true);
        config.setEnableProxy(true);
        config.setProxyUrl("127.0.0.1");
        config.setProxyPort(1087);
        return config;
    }


}

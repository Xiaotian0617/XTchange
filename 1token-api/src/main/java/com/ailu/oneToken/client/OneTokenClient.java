package com.ailu.oneToken.client;

import com.ailu.oneToken.api.OneToken;
import com.ailu.oneToken.config.APIConfiguration;

/**
 * NOTE:
 *
 * @Version 1.0
 * @Since JDK1.8
 * @Author mr.wang
 * @Company Henan ailu
 * @Date 2018/12/14 10:45
 */
public class OneTokenClient {

    public APIClient client;
    public OneToken api;

    public OneTokenClient(APIConfiguration apiConfiguration) {
        this.client = new APIClient(apiConfiguration);
        this.api = client.createService(OneToken.class);
    }

    private static APIConfiguration config(String apiKey, String secretKey, String passphrase, boolean proxyEnable, String url, String port) {
        final APIConfiguration config = new APIConfiguration();
        config.setEndpoint(OneToken.baseUrl);
        // apiKey，api注册成功后页面上有
        config.setApiKey(apiKey);
        // secretKey，api注册成功后页面上有
        config.setSecretKey(secretKey);
        config.setPassphrase(passphrase);
        config.setPrint(true);
        if (proxyEnable) {
            config.setEnableProxy(true);
            config.setProxyUrl(url);
            config.setProxyPort(Integer.valueOf(port));
        }
        return config;
    }

}

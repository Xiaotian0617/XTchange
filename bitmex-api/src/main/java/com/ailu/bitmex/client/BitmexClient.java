package com.ailu.bitmex.client;

import com.ailu.bitmex.api.Bitmex;
import com.ailu.bitmex.config.APIConfiguration;

/**
 * NOTE:
 *
 * @Version 1.0
 * @Since JDK1.8
 * @Author mr.wang
 * @Company Henan ailu
 * @Date 2018/12/14 10:45
 */
public class BitmexClient {

    public APIClient client;
    public Bitmex api;

    public BitmexClient(APIConfiguration apiConfiguration) {
        this.client = new APIClient(apiConfiguration);
        this.api = client.createService(Bitmex.class);
    }

    private static APIConfiguration config(String apiKey, String secretKey, String passphrase, boolean proxyEnable, String url, String port) {
        final APIConfiguration config = new APIConfiguration();
        config.setEndpoint(Bitmex.baseUrl);
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

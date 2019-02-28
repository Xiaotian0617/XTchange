package com.al.bcoin;

import okhttp3.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * NOTE:
 *
 * @Version 1.0
 * @Since JDK1.8
 * @Author mr.wang
 * @Company 洛阳艾鹿网络有限公司
 * @Date 2018/7/25 17:39
 */
public class BaseExchange {

    static SocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 1080);
    static Proxy proxy = new Proxy(Proxy.Type.HTTP,socketAddress);

    public static OkHttpClient.Builder buildOkHttpClientBuilder() {
        return new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .proxy(proxy)
                .readTimeout(20, TimeUnit.SECONDS).addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        Headers headers = request.headers();
                        Request.Builder builder = request.newBuilder();
                        builder.addHeader("serial-number", UUID.randomUUID().toString());
                        Request request1 = builder.build();
                        return chain.proceed(request1);
                    }
                });
    }

}

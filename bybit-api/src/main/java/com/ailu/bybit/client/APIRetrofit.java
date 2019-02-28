package com.ailu.bybit.client;

import com.ailu.bybit.client.CustomConvertFactory;
import com.ailu.bybit.config.APIConfiguration;
import com.alibaba.fastjson.support.retrofit.Retrofit2ConverterFactory;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * API Retrofit
 *
 * @author Tony Tian
 * @version 1.0.0
 * @date 2018/3/8 15:40
 */
public class APIRetrofit {


    private APIConfiguration config;
    private OkHttpClient client;

    public APIRetrofit(APIConfiguration config, OkHttpClient client) {
        this.config = config;
        this.client = client;
    }

    /**
     * Get a retrofit 2 object.
     */
    public Retrofit retrofit() {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.client(this.client);
//        builder.addConverterFactory(ScalarsConverterFactory.create());
//        builder.addConverterFactory(GsonConverterFactory.create());
//        builder.addCallAdapterFactory(RxJavaCallAdapterFactory.create());
        builder.addConverterFactory(new CustomConvertFactory());
        builder.addConverterFactory(new Retrofit2ConverterFactory());
        builder.baseUrl(this.config.getEndpoint());
        return builder.build();
    }
}

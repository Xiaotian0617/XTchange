package com.ailu.bitmex.client;

import com.ailu.bitmex.api.Bitmex;
import com.ailu.bitmex.bean.BitmexResult;
import com.ailu.bitmex.config.APIConfiguration;
import com.ailu.bitmex.exception.APIException;
import com.ailu.bitmex.utils.DateUtils;
import com.ailu.bitmex.utils.HttpHeadersEnum;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import org.apache.commons.lang3.StringUtils;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

/**
 * OKEX API Client
 *
 * @author Tony Tian
 * @version 1.0.0
 * @date 2018/3/8 13:43
 */
@Slf4j
public class APIClient {

    private final APIConfiguration config;
    private final OkHttpClient client;
    private final Retrofit retrofit;
    private final ApiHttp apiHttp;

    /**
     * Initialize the apis client
     */
    public APIClient(final APIConfiguration config) {
        if (config == null || StringUtils.isEmpty(config.getEndpoint())) {
            throw new RuntimeException("The APIClient params can't be empty.");
        }
        this.config = config;
        this.client = new APIHttpClient(config).client();
        this.retrofit = new APIRetrofit(config, this.client).retrofit();
        this.apiHttp = new ApiHttp(config, this.client);
    }

    /**
     * Initialize the retrofit operation service
     */
    public <T> T createService(final Class<T> service) {
        return this.retrofit.create(service);
    }

    /**
     * Synchronous send request
     */
    public BitmexResult executeSync(final Call<?> call) {
        try {
            final Response response = call.execute();
            if (this.config.isPrint()) {
                this.printResponse(response);
            }
            if (response.isSuccessful()) {
                Object obj = response.body();
                BitmexResult bitmexResult = new BitmexResult();
                bitmexResult.setXRateLimitLimit(Long.valueOf(response.headers().get("x-ratelimit-limit")));
                bitmexResult.setXRateLimitRemaining(Long.valueOf(response.headers().get("x-ratelimit-remaining")));
                bitmexResult.setXRateLimitReset(Long.valueOf(response.headers().get("x-ratelimit-reset")));
                bitmexResult.setData(obj);
                return bitmexResult;
            } else {
                throw new APIException(response.errorBody().string());
            }
        } catch (final IOException e) {
            throw new APIException("APIClient executeSync exception.", e);
        }
    }

    private void printResponse(final Response response) {
        final StringBuilder responseInfo = new StringBuilder();
        responseInfo.append("\n\tResponse").append("(").append(DateUtils.timeToString(null, 4)).append("):");
        if (response != null) {
            final String limit = response.headers().get(HttpHeadersEnum.OK_LIMIT.header());
            if (StringUtils.isNotEmpty(limit)) {
                responseInfo.append("\n\t\t").append("Headers: ");
                responseInfo.append("\n\t\t\t").append(HttpHeadersEnum.OK_BEFORE.header()).append(": ").append(response.headers().get(HttpHeadersEnum.OK_BEFORE.header()));
                responseInfo.append("\n\t\t\t").append(HttpHeadersEnum.OK_AFTER.header()).append(": ").append(response.headers().get(HttpHeadersEnum.OK_AFTER.header()));
                responseInfo.append("\n\t\t\t").append(HttpHeadersEnum.OK_FROM.header()).append(": ").append(response.headers().get(HttpHeadersEnum.OK_FROM.header()));
                responseInfo.append("\n\t\t\t").append(HttpHeadersEnum.OK_TO.header()).append(": ").append(response.headers().get(HttpHeadersEnum.OK_TO.header()));
                responseInfo.append("\n\t\t\t").append(HttpHeadersEnum.OK_LIMIT.header()).append(": ").append(limit);
            }
            responseInfo.append("\n\t\t").append("Status: ").append(response.code());
            responseInfo.append("\n\t\t").append("Message: ").append(response.message());
            responseInfo.append("\n\t\t").append("Body: ").append(JSON.toJSONString(response.body()));
        } else {
            responseInfo.append("\n\t\t").append("\n\tRequest Error: response is null");
        }
        log.info(responseInfo.toString());
    }

}

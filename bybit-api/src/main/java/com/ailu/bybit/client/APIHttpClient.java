package com.ailu.bybit.client;

import com.ailu.bybit.api.Bybit;
import com.ailu.bybit.config.APIConfiguration;
import com.ailu.bybit.constant.APIConstants;
import com.ailu.bybit.enums.ContentTypeEnum;
import com.ailu.bybit.exception.APIException;
import com.ailu.bybit.utils.DateUtils;
import com.ailu.bybit.utils.Signature;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.Buffer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;

/**
 * API OkHttpClient.
 *
 * @author mr.wang
 * @version 1.0.0
 * @date 2018/3/8 14:14
 */
@Slf4j
public class APIHttpClient {

    private final APIConfiguration config;

    public APIHttpClient(final APIConfiguration config) {
        this.config = config;
    }

    /**
     * Get a ok http 3 client object. <br/>
     * Declare:
     * <blockquote><pre>
     *  1. Set default client args:
     *         connectTimeout=30s
     *         readTimeout=30s
     *         writeTimeout=30s
     *         retryOnConnectionFailure=true.
     *  2. Set request headers:
     *      Content-Type: application/json; charset=UTF-8  (default)
     *      Cookie: locale=en_US        (English)
     *      OK-ACCESS-KEY: (Your setting)
     *      OK-ACCESS-SIGN: (Use your setting, auto sign and add)
     *      OK-ACCESS-TIMESTAMP: (Auto add)
     *      OK-ACCESS-PASSPHRASE: Your setting
     *  3. Set default print api info: false.
     * </pre></blockquote>
     */
    public OkHttpClient client() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(new HttpLogger());
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        final OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        clientBuilder.connectTimeout(this.config.getConnectTimeout(), TimeUnit.SECONDS);
        clientBuilder.readTimeout(this.config.getReadTimeout(), TimeUnit.SECONDS);
        clientBuilder.writeTimeout(this.config.getWriteTimeout(), TimeUnit.SECONDS);
        clientBuilder.retryOnConnectionFailure(this.config.isRetryOnConnectionFailure());
        //add proxy
        if (this.config.isEnableProxy()){
            clientBuilder.proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(this.config.getProxyUrl(), this.config.getProxyPort())));
        }
        clientBuilder.addInterceptor((Interceptor.Chain chain) -> {
            final Request.Builder requestBuilder = chain.request().newBuilder();
            final String timestamp = DateUtils.getUnixTime();
            requestBuilder.headers(this.headers(chain.request(), timestamp));
            final Request request = requestBuilder.build();
            if (this.config.isPrint()){
                printRequest(request);
            }
            return chain.proceed(request);
        });
        clientBuilder.addInterceptor(logging);
        return clientBuilder.build();
    }

    public class HttpLogger implements HttpLoggingInterceptor.Logger {
        @Override
        public void log(String message) {
            log.info("HttpLogInfo {}", message);
        }
    }

    private Headers headers(final Request request, final String timestamp) throws IOException {
        final Headers.Builder builder = new Headers.Builder();
        if (APIConstants.POST.equalsIgnoreCase(method(request))){
            builder.add(APIConstants.CONTENT_TYPE, ContentTypeEnum.APPLICATION_JSON.contentType());
            builder.add(APIConstants.CONTENT_LENGTH,requestPath(request).length()+"");
            builder.add(APIConstants.HOST, Bybit.baseUrl.substring(0,Bybit.baseUrl.length()-1).replace(Bybit.baseReq,""));
        }/*else {
            builder.add(APIConstants.CONTENT_TYPE, ContentTypeEnum.APPLICATION_FORM.contentType());
        }*/
        return builder.build();
    }

    /**
     *  生成1token的Signature
     * @param secretKey
     * @param verb 请求方式 GET POST
     * @param signPath
     * @param nonce
     * @param body
     * @return
     */
    private String getSignature(String secretKey, String verb, String signPath, String nonce, String body) {
        return Signature.signature(secretKey,verb,signPath,nonce,body);
    }

    private String url(final Request request) {
        return request.url().toString();
    }

    private String method(final Request request) {
        return request.method().toUpperCase();
    }

    private String requestPath(final Request request) {
        String url = this.url(request);
        String requestPath = url.replace(this.config.getEndpoint(), APIConstants.EMPTY);;
        return requestPath;
    }

    private String queryString(final Request request) {
        final String url = this.url(request);
        String queryString = APIConstants.EMPTY;
        if (url.contains(APIConstants.QUESTION)) {
            queryString = url.substring(url.lastIndexOf(APIConstants.QUESTION) + 1);
        }
        return queryString;
    }

    private String body(final Request request) throws IOException {
        final RequestBody requestBody = request.body();
        String body = APIConstants.EMPTY;
        if (requestBody != null) {
            final Buffer buffer = new Buffer();
            requestBody.writeTo(buffer);
            body = buffer.readString(APIConstants.UTF_8);
        }
        return body;
    }

    private void printRequest(final Request request) {
        final String method = this.method(request);
        final String body;
        try {
            body = this.body(request);
        } catch (final IOException e) {
            throw new APIException("Request get body io exception.", e);
        }
        final StringBuilder requestInfo = new StringBuilder();
        requestInfo.append("\n").append("\tSecret-Key: ").append(this.config.getSecretKey());
        requestInfo.append("\n\tRequest").append("(").append(DateUtils.timeToString(null, 4)).append("):");
        requestInfo.append("\n\t\t").append("Url: ").append(this.url(request));
        requestInfo.append("\n\t\t").append("Method: ").append(method);
        requestInfo.append("\n\t\t").append("Headers: ");
        final Headers headers = request.headers();
        if (headers != null && headers.size() > 0) {
            for (final String name : headers.names()) {
                requestInfo.append("\n\t\t\t").append(name).append(": ").append(headers.get(name));
            }
        }
        requestInfo.append("\n\t\t").append("Body: ").append(body);
        log.info(requestInfo.toString());
    }
}

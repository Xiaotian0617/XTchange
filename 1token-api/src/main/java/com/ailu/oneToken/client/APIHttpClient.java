package com.ailu.oneToken.client;

import com.ailu.oneToken.config.APIConfiguration;
import com.ailu.oneToken.constant.APIConstants;
import com.ailu.oneToken.enums.ContentTypeEnum;
import com.ailu.oneToken.utils.DateUtils;
import com.ailu.oneToken.utils.Signature;
import com.okcoin.okex.open.api.exception.APIException;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import okio.Buffer;
import org.apache.commons.lang3.RandomUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;

import static com.ailu.oneToken.constant.APIConstants.EMPTY;
import static com.ailu.oneToken.constant.APIConstants.QUESTION;

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

    public static boolean debug;

    public APIHttpClient(final APIConfiguration config) {
        this.config = config;
        debug = config.isPrint();
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
        final OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        clientBuilder.connectTimeout(this.config.getConnectTimeout(), TimeUnit.SECONDS);
        clientBuilder.readTimeout(this.config.getReadTimeout(), TimeUnit.SECONDS);
        clientBuilder.writeTimeout(this.config.getWriteTimeout(), TimeUnit.SECONDS);
        clientBuilder.retryOnConnectionFailure(this.config.isRetryOnConnectionFailure());
        //add proxy
        if (this.config.isEnableProxy()){
            clientBuilder.proxy(new java.net.Proxy(Proxy.Type.HTTP, new InetSocketAddress(this.config.getProxyUrl(), this.config.getProxyPort())));
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
        return clientBuilder.build();
    }

    private Headers headers(final Request request, final String timestamp) throws IOException {
        final Headers.Builder builder = new Headers.Builder();
        builder.add(APIConstants.ACCEPT, ContentTypeEnum.APPLICATION_JSON.contentType());
        builder.add(APIConstants.CONTENT_TYPE, ContentTypeEnum.APPLICATION_JSON.contentType());
        builder.add(APIConstants.APIKEY,this.config.getApiKey());
        String nonce = Signature.getNonce();
        builder.add(APIConstants.APINONCE, nonce);
        String body = body(request);
        builder.add(APIConstants.APISIGNATURE,getSignature(this.config.getSecretKey(),method(request),requestPath(request),nonce, body));
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


    /**
     * Get request path of sign method.
     * @param request
     * @return
     */
    private String requestPath(final Request request) {
        String url = this.url(request);
        if(url.contains(QUESTION)){
            url = url.split("\\?")[0];
        }
        if (url.endsWith("/")) {
            url = url.substring(0, url.length() - 1);
        }
        url = url.replace(config.getEndpoint(), EMPTY);
        return url.substring(url.indexOf("/"));
    }


    private String queryString(final Request request) {
        final String url = this.url(request);
        String queryString = APIConstants.EMPTY;
        if (url.contains(QUESTION)) {
            queryString = url.substring(url.lastIndexOf(QUESTION) + 1);
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

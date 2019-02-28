package com.ailu.oneToken.websocket;

import com.ailu.oneToken.constant.APIConstants;
import com.ailu.oneToken.enums.ContentTypeEnum;
import com.ailu.oneToken.utils.Signature;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.retrofit.Retrofit2ConverterFactory;
import okhttp3.Headers;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.util.Optional;

/**
 * OneToken 私有 ws 订阅
 * @author mr.wang
 * @version 1.0.0
 * @date 2019/1/22 10:43
 */
public class OneTokenPrivateListener {

    public interface OneTokenApi{

        String BASE_URL = "https://cdn.1tokentrade.cn";

        String WALLET_URL = "wss://cdn.1tokentrade.cn/api/v1/ws/premium";

        String APP_KEY = "ceTfjwDt-5cyazWGQ-vFgalbBe-x0y5jwL4";

        String APP_SECRET = "W7RLhtdO-YRHjFv1a-cZ9kWJvp-YONaAWgo";

        default WSListener ws() {
             return new WSListener()
                    .url(WALLET_URL)
                    .ping("{\"uri\":\"ping\"}",5)
                    .parse(OneTokenPrivateListener::parse);
        }

        static Headers headers(String appKey,String secret) {
            final Headers.Builder builder = new Headers.Builder();
            builder.add(APIConstants.CONTENT_TYPE, ContentTypeEnum.APPLICATION_JSON.contentType());
            builder.add(APIConstants.APIKEY,appKey);
            String nonce = Signature.getNonce();
            builder.add(APIConstants.APINONCE, nonce);
            builder.add(APIConstants.APISIGNATURE,getSignature(secret,nonce, null));
            return builder.build();
          }

        static String getSignature(String appSecret, String nonce, String body){
            return Signature.signature(appSecret,"GET","/wallet/ws",nonce,body);
        }

    }

    private static WSListener.Info parse(String text) {
           return Optional.of(text).filter(str->!"\"uri\": \"pong\"".contains(text)).map(OneTokenPrivateListener::apply).orElse(null);
    }

    private static WSListener.Info apply(String text) {
        return JSONObject.parseObject(text,WSListener.Info.class);
    }

    public static OneTokenPrivateListener.OneTokenApi oneTokenApi = new Retrofit.Builder()
            .baseUrl(OneTokenApi.BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(new Retrofit2ConverterFactory())
            .build()
            .create(OneTokenPrivateListener.OneTokenApi.class);

    public static void main(String[] args) {
        try {
            WSListener ws = oneTokenApi.ws();
            Request req = new Request.Builder().headers(OneTokenApi.headers(OneTokenApi.APP_KEY,OneTokenApi.APP_SECRET))
                    .url(OneTokenApi.WALLET_URL).build();
            ws.setPrintLog(true).message(msg-> System.out.println(msg)).start(req);
        }catch (Throwable e){
            e.printStackTrace();
        }
    }

}


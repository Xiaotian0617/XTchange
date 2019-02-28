package com.al.dbspider.base.api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * file:spider
 * <p>
 * 文件简要说明
 *
 * @author 19:40  王楷
 * @version 19:40 V1.0
 * @par 版权信息：
 * 2018 Copyright 河南艾鹿网络科技有限公司 All Rights Reserved.
 */
public interface TopCoin {

    /**
     * 发送Websocket信息通知
     * @param json
     * @return
     */
    @POST("/api/flushws")
    @Headers({"Content-Type: application/json"})
    Call<String> sendInfo(@Body String json);

}

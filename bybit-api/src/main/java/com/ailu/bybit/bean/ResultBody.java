package com.ailu.bybit.bean;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * bybit 返回的格式基类
 *
 * @author mr.wang
 * @version 1.0.0
 * @date 2019/1/12 11:17
 */
public class ResultBody {


    /**
     * ret_code : 0 错误码 - 正确,
     * ret_msg : ok 错误消息,
     * ext_code :
     * time_now : 1539778407.210858  UTC时间戳
     * rate_limit_status : 0 当前时间区间内(1分钟)该类型接口剩余访问次数
     */

    @JSONField(name = "ret_code")
    private Integer retCode;
    @JSONField(name = "ret_msg")
    private String retMsg;
    @JSONField(name = "ext_code")
    private String extCode;
    @JSONField(name = "time_now")
    private String timeNow;
    @JSONField(name = "rate_limit_status")
    private Integer rateLimitStatus;
    private Object result;

    public Integer getRetCode() {
        return retCode;
    }

    public void setRetCode(Integer retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public String getExtCode() {
        return extCode;
    }

    public void setExtCode(String extCode) {
        this.extCode = extCode;
    }

    public String getTimeNow() {
        return timeNow;
    }

    public void setTimeNow(String timeNow) {
        this.timeNow = timeNow;
    }

    public Integer getRateLimitStatus() {
        return rateLimitStatus;
    }

    public void setRateLimitStatus(Integer rateLimitStatus) {
        this.rateLimitStatus = rateLimitStatus;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}

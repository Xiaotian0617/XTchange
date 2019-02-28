package com.ailu.bybit.service;

import com.ailu.bybit.bean.Position;
import com.ailu.bybit.bean.StopOrder;
import com.ailu.bybit.service.BaseService;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * NOTE:
 * 1token 账户信息调用接口
 *
 * @Version 1.0
 * @Since JDK1.8
 * @Author mr.wang
 * @Company Henan ailu
 * @Date 2018/12/15 14:31
 */
public interface AccountService extends BaseService {

    List<Position> getPosition(String apiKey, String secret);

    JSONObject getLeverage(String apiKey, String secret);

    Boolean saveLeverage(String apiKey, String secret, Integer leverage, String symbol);

    List<StopOrder>  getStopOrderList(String apiKey, String secret);


}

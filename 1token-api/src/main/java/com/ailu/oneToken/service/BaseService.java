package com.ailu.oneToken.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * NOTE:
 *
 * @Version 1.0
 * @Since JDK1.8
 * @Author mr.wang
 * @Company Henan ailu
 * @Date 2018/12/15 15:06
 */
public interface BaseService{

    default <T> List<T> strToModels(String str,Class clazz){
        return JSONArray.parseArray(str,clazz);
    }

    default <T> T strToModel(String str,Class clazz){
        return (T) JSONObject.parseObject(str, clazz);
    }

    default JSONArray strToJSONArray(String str){return JSONArray.parseArray(str);}

    default JSONObject strToJSONObject(String str){return JSONObject.parseObject(str);}

}

package com.ailu.bybit.service;

import com.ailu.bybit.utils.HMACSHA256Util;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * NOTE:
 *
 * @Version 1.0
 * @Since JDK1.8
 * @Author mr.wang
 * @Company Henan ailu
 * @Date 2018/12/15 15:06
 */
public interface BaseService {

    default <T> List<T> strToModels(Object obj, Class clazz) {
        if (obj == null) {
            return null;
        }
        return JSONArray.parseArray(obj.toString(), clazz);
    }

    default <T> T strToModel(Object obj, Class clazz) {
        if (obj == null) {
            return null;
        }
        return (T) JSONObject.parseObject(obj.toString(), clazz);
    }

    default JSONArray strToJSONArray(Object obj) {
        if (obj == null) {
            return null;
        }
        return JSONArray.parseArray(obj.toString());
    }

    default JSONObject strToJSONObject(Object obj) {
        if (obj == null) {
            return null;
        }
        return JSONObject.parseObject(obj.toString());
    }

    default Map<String, Object> signByRequestParam(Map<String, Object> requestPath, String apiKey, String secret) {
        Long nowTime = System.currentTimeMillis();
        Map<String, Object> sortedMap = new TreeMap<>(new MapKeyComparator());
        sortedMap.put("api_key", apiKey);
        sortedMap.put("timestamp", nowTime);
        sortedMap.put("recv_window",10000);
        sortedMap.putAll(requestPath);
        Map<String, Object> requestMap = new LinkedHashMap<>();
        requestMap.putAll(sortedMap);
        StringBuilder param_str = new StringBuilder();
        requestMap.entrySet().forEach(map -> {
            param_str.append(map.getKey());
            param_str.append("=");
            param_str.append(map.getValue());
            param_str.append("&");
        });
        String substring = param_str.substring(0, param_str.length() - 1);
        String sign = HMACSHA256Util.HMACSHA256(substring.getBytes(), secret.getBytes());
        requestMap.put("sign", sign);
        return requestMap;
    }

    class MapKeyComparator implements Comparator<String> {

        @Override
        public int compare(String str1, String str2) {

            return str1.compareTo(str2);
        }
    }

}

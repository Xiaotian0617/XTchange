package com.ailu.bitmex.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.DigestException;
import java.util.Map;

public class Signature {
    public Signature() {
    }

    private static final String MAC_NAME = "HmacSHA1";
    private static final String ENCODING = "UTF-8";

    /**
     * 使用 HMAC-SHA1 签名方法对对encryptText进行签名
     * @param encryptText 被签名的字符串
     * @param encryptKey  密钥
     * @return
     * @throws Exception
     */
    public static byte[] HmacSHA1Encrypt(String encryptText, String encryptKey) throws Exception {
        byte[] data=encryptKey.getBytes(ENCODING);
        //根据给定的字节数组构造一个密钥,第二参数指定一个密钥算法的名称
        SecretKey secretKey = new SecretKeySpec(data, MAC_NAME);
        //生成一个指定 Mac 算法 的 Mac 对象
        Mac mac = Mac.getInstance(MAC_NAME);
        //用给定密钥初始化 Mac 对象
        mac.init(secretKey);

        byte[] text = encryptText.getBytes(ENCODING);
        //完成 Mac 操作
        return mac.doFinal(text);
    }

    public static byte[] HmacSHA256Encrypt(String encryptText, String encryptKey) throws Exception {
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(encryptKey.getBytes(), "HmacSHA256");
        sha256_HMAC.init(secret_key);
        return sha256_HMAC.doFinal(encryptText.getBytes());
    }


    public static String signature(String secretKey, String verb, String signPath, String nonce,Map<String, Object> maps) throws DigestException {
        String prex = verb+signPath+nonce;
        String decrypt = prex;
        if (maps!=null&&!maps.isEmpty()){
            decrypt += getOrderByLexicographic(maps);
        }
        try {
            byte[] messageDigest = HmacSHA256Encrypt(decrypt,secretKey);
            StringBuffer hexString = new StringBuffer();

            for(int i = 0; i < messageDigest.length; ++i) {
                String shaHex = Integer.toHexString(messageDigest[i] & 255);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }

                hexString.append(shaHex);
            }

            return hexString.toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DigestException("签名错误！");
        }
    }

    private static String getOrderByLexicographic(Map<String, Object> maps) {
        String value = JSON.toJSONString(maps, SerializerFeature.MapSortField);
        return value.replace(":",": ").replace(",",", ");
    }

    public static String signature(String secretKey, String verb, String signPath, String nonce, String body) {
        JSONObject jsonObject = JSONObject.parseObject(body);
        try {
            return signature(secretKey,verb,signPath,nonce,jsonObject);
        } catch (DigestException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String signature(String secretKey){
        try {
            byte[] messageDigest = HmacSHA256Encrypt("",secretKey);
            StringBuffer hexString = new StringBuffer();

            for(int i = 0; i < messageDigest.length; ++i) {
                String shaHex = Integer.toHexString(messageDigest[i] & 255);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }

                hexString.append(shaHex);
            }

            return hexString.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}

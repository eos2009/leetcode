package com.chenfei.leetcode.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;

import java.util.List;

/**
 * @author chenfei
 * @description
 * @since 2018/10/18
 */
public class JsonUtil {

    /**
     * 对象转换为字符串
     * @param o
     * @return
     */
    public static String toString(Object o){
        return JSON.toJSONString(o);
    }

    /**
     * 字符串转对象
     * @param str
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T parse(String str, Class<T> clazz){
        return JSON.parseObject(str,clazz, Feature.OrderedField);
    }

    /**
     * 字符串转数组对象
     * @param str
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> parseArray(String str, Class<T> clazz){
        return JSON.parseArray(str,clazz);
    }

    /**
     * 字符串转json字符串
     * @param str
     * @return
     */
    public static String toJsonString(String str){
        return toJsonString(str,str);
    }
    /**
     * 字符串转json字符串
     * @param key
     * @param value
     * @return
     */
    public static String toJsonString(String key, String value){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(key,value);
        return jsonObject.toJSONString();
    }
}

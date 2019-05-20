package com.project.wangyimingcongraduation.util;

import com.google.gson.Gson;

/**
 * @Author: Create by FENGJINGJU
 * @Date: 2019/4/6 20:03
 */
public class GsonUtil {

    /**
     * 将Json字符串转换为实体
     * @param jsonString
     * @param t
     * @param <T>
     * @return
     */
    public static <T> T transferJsonStringToObject(String jsonString, Class<T> t) {
        return new Gson().fromJson(jsonString, t);
    }

    /**
     * 将实体或List转换为Json字符串
     * @param object
     * @return
     */
    public static String transferJsonStringFromListOrObject(Object object){
        return new Gson().toJson(object);
    }
}

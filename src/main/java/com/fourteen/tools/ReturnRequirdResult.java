package com.fourteen.tools;

import com.alibaba.fastjson.JSON;
import com.fourteen.pojo.ResultReturn;

public class ReturnRequirdResult {

    public static String resultToJson(int code) {
        return resultToJson(null, 1, code);
    }

    public static String resultToJson(Object object) {
        return resultToJson(object, 1, 0);
    }

    public static String resultToJson(Object object, int count) {
        return resultToJson(object, count, 0);
    }

    public static String resultToJson(Object object, int count, int code) {
        ResultReturn resultReturn = new ResultReturn(String.valueOf(code), "", String.valueOf(count), object);
        return JSON.toJSONString(resultReturn);
    }



}

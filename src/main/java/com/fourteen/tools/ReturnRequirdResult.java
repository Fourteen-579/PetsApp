package com.fourteen.tools;

import com.alibaba.fastjson.JSON;
import com.fourteen.pojo.ResultReturn;

public class ReturnRequirdResult {
    public static String resultToJson(Object object){
        return resultToJson(object,1);
    }

    public static String resultToJson(Object object,int count){
        ResultReturn resultReturn = new ResultReturn("0", "", String.valueOf(count), object);
        return JSON.toJSONString(resultReturn);
    }

}

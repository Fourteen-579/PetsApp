package com.fourteen.dao;

import com.fourteen.pojo.App;

import java.util.Map;

public interface AppMapper {

//    查询现有的应用信息
    App query();

//    修改应用信息
    int updateApp(Map map);

}

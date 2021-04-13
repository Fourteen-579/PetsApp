package com.fourteen.dao;

import com.fourteen.pojo.RescueInfor;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RescueInforMapper {

    List<RescueInfor> queryAll();

    //分页查询
    List<RescueInfor> queryByLimit(@Param("page") int page, @Param("limit") int limit);

    //查询总数据量
    int countRescueInfor();


    int UpdateRescueInfor(Map map);


    int deleteRescueInforById(@Param("id") String id);

    int addRescueInfor(Map map);
    
}

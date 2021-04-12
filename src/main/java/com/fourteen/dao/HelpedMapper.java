package com.fourteen.dao;

import com.fourteen.pojo.Helped;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface HelpedMapper {

    List<Helped> queryAll();

    //分页查询
    List<Helped> queryByLimit(@Param("page") int page, @Param("limit") int limit);

    //查询总数据量
    int countHelped();

    //    更新用户数据
    int updateHelped(Map map);

    //    删除用户根据id
    int deleteHelpedById(@Param("id") String id);

    //    增加用户
    int addHelped(Map map);
}

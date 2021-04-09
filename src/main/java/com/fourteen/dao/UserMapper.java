package com.fourteen.dao;

import com.fourteen.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    int addUser(User user);

    List<User> queryAll();

    //分页查询
    List<User> queryByLimit(@Param("page") int page, @Param("limit") int limit);

    //查询总数据量
    int countUser();

    int UpdateUser(Map map);

}

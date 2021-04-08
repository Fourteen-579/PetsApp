package com.fourteen.dao;

import com.fourteen.pojo.User;

import java.util.List;

public interface UserMapper {
    int addUser(User user);

    List<User> queryAll();

}

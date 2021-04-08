package com.fourteen.service;

import com.fourteen.pojo.User;

import java.util.List;


public interface UserService {
    int addUser(User user);

    List<User> queryAll();
}

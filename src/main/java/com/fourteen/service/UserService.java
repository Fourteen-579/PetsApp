package com.fourteen.service;

import com.fourteen.pojo.User;

import java.util.List;


public interface UserService {
    int addUser(User user);

    String queryAll();

    String queryByLimit(int page,int limit);
}

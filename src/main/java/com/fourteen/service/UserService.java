package com.fourteen.service;

import com.fourteen.pojo.User;

import java.util.HashMap;
import java.util.Map;


public interface UserService {
    int addUser(User user);

    String queryAll();

    String queryByLimit(int page,int limit);

    String updateUser(Map map);

    String deleteUserById(Map map);

    String addUser(HashMap<String,String> map);
}

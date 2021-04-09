package com.fourteen.service.impl;

import com.alibaba.fastjson.JSON;
import com.fourteen.dao.UserMapper;
import com.fourteen.pojo.ResultReturn;
import com.fourteen.pojo.User;
import com.fourteen.service.UserService;
import com.fourteen.tools.ReturnRequirdResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public String queryAll() {
        List<User> list = userMapper.queryAll();
        return ReturnRequirdResult.resultToJson(list,list.size());
    }

    @Override
    public String queryByLimit(int page, int limit) {
        if (page > 1) {
            page = limit * (page - 1);
        } else if (page == 1) {
            page = 0;
        }
        List<User> list = userMapper.queryByLimit(page, limit);
        int countUser = userMapper.countUser();
        return ReturnRequirdResult.resultToJson(list,countUser);
    }
}

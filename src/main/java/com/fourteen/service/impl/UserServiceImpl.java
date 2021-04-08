package com.fourteen.service.impl;

import com.fourteen.dao.UserMapper;
import com.fourteen.pojo.User;
import com.fourteen.service.UserService;
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
    public List<User> queryAll() {
        return userMapper.queryAll();
    }
}

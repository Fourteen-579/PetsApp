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
import java.util.Map;

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
        return ReturnRequirdResult.resultToJson(list, list.size());
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
        return ReturnRequirdResult.resultToJson(list, countUser);
    }

    @Override
    public String updateUser(Map map) {
        //将获取的数据取出并转换为字符串
        String field = map.get("field").toString();
        String value = map.get("value").toString();
        String id = map.get("id").toString();
        map.clear();
        //将正确的形式放入map中
        map.put(field, value);
        map.put("id", id);
        int i = userMapper.UpdateUser(map);
        int code = 0;
        if (i != 1)
            code = 404;
        return ReturnRequirdResult.resultToJson(code);
    }
}

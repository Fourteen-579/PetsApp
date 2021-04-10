package com.fourteen.service.impl;

import com.alibaba.fastjson.JSON;
import com.fourteen.dao.UserMapper;
import com.fourteen.pojo.ResultReturn;
import com.fourteen.pojo.User;
import com.fourteen.service.UserService;
import com.fourteen.tools.CreateId;
import com.fourteen.tools.ReturnRequirdResult;
import com.fourteen.tools.UploadFile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
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

    @Override
    public String deleteUserById(Map map) {
        int i = userMapper.deleteUserById((String) map.get("id"));
        int code = 0;
        if (i != 1)
            code = 404;
        return ReturnRequirdResult.resultToJson(code);
    }

    @Override
    public String addUser(HashMap<String,String> map) {
        map.put("id", CreateId.getUUID());
        String location = "四川";
        switch (Integer.valueOf(map.get("location"))){
            case -1:
                location = "隐藏";
                break;
            case 1:
                location = "浙江";
                break;
            case 2:
                location = "黑龙江";
                break;
            case 3:
                location = "新疆";
                break;
            case 4:
                location = "内蒙古";
                break;
        }
        map.put("location",location);
        int i = userMapper.addUser(map);
        int code = 0;
        if (i != 1)
            code = 404;
        return ReturnRequirdResult.resultToJson(code);

    }

    @Override
    public String uploadFile(CommonsMultipartFile file, HttpServletRequest request) {
        String filePath = "";
        try {
            filePath = UploadFile.upfile(file, request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ReturnRequirdResult.resultToJson(filePath);
    }


}

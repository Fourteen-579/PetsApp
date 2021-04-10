package com.fourteen.service;

import com.fourteen.pojo.User;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


public interface UserService {
    int addUser(User user);

    String queryAll();

    String queryByLimit(int page,int limit);

    String updateUser(Map map);

    String deleteUserById(Map map);

    String addUser(HashMap<String,String> map);

    String uploadFile(CommonsMultipartFile file, HttpServletRequest request);
}

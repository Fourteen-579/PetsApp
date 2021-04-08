package com.fourteen.controller;

import com.fourteen.pojo.User;
import com.fourteen.service.UserService;
import com.fourteen.tools.CreateId;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping("/add")
    public String addUser(){
        User user = new User(CreateId.getUUID(),"name",10,"男","111","111");
        userService.addUser(user);

        return "userList";
    }

}

package com.fourteen.controller;

import com.alibaba.fastjson.JSON;
import com.fourteen.pojo.User;
import com.fourteen.service.UserService;
import com.fourteen.tools.CreateId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/add")
    public String addUser() {
        User user = new User(CreateId.getUUID(), "name", 10, "男", "111", "111");
        userService.addUser(user);
        return "userList";
    }

    @RequestMapping("/queryByLimit")
    @ResponseBody
    public String queryByLimit(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        return userService.queryByLimit(page, limit);
    }

    @RequestMapping("/queryAll")
    @ResponseBody
    public String queryAll() {
        return userService.queryAll();
    }

}

package com.fourteen.controller;

import com.alibaba.fastjson.JSON;
import com.fourteen.pojo.User;
import com.fourteen.service.UserService;
import com.fourteen.tools.CreateId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/queryByLimit")
    public String queryByLimit(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        return userService.queryByLimit(page, limit);
    }

    @RequestMapping("/queryAll")
    public String queryAll() {
        return userService.queryAll();
    }

    @PatchMapping("/updateUser")
    public String updateUser(@RequestBody String data){
        HashMap hashMap = JSON.parseObject(data, HashMap.class);
        return userService.updateUser(hashMap);
    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(@RequestBody String data){
        HashMap<String,String> hashMap = JSON.parseObject(data,HashMap.class);

        return userService.deleteUserById(hashMap);
    }

}

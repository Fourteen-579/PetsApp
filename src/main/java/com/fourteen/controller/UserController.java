package com.fourteen.controller;

import com.alibaba.fastjson.JSON;
import com.fourteen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;

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
    public String updateUser(@RequestBody String data) {
        HashMap hashMap = JSON.parseObject(data, HashMap.class);
        return userService.updateUser(hashMap);
    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(@RequestBody String data) {
        HashMap<String, String> hashMap = JSON.parseObject(data, HashMap.class);

        return userService.deleteUserById(hashMap);
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody String data) {
        HashMap<String, String> map = JSON.parseObject(data, HashMap.class);
        return userService.addUser(map);
    }

    @PostMapping("/uploadImg")
    public String fileUpload(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request){
        return userService.uploadFile(file, request);
    }

}

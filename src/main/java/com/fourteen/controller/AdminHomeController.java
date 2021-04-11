package com.fourteen.controller;


import com.alibaba.fastjson.JSON;
import com.fourteen.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping("/admin")
public class AdminHomeController {

    @Autowired
    AppService appService;

    @RequestMapping("/main")
    public String toMain(){
        return "admin/main";
    }

    @RequestMapping("/userList")
    public String toUserList(){
        return "admin/user/userList";
    }

    @RequestMapping("/addUser")
    public String toAddUser(){
        return "admin/user/addUser";
    }

    @RequestMapping("/organList")
    public String toOrganList(){
        return "admin/organization/organList";
    }

    @RequestMapping("/addOrgan")
    public String toAddOrgan(){
        return "admin/organization/addOrgan";
    }

    @RequestMapping("appInfo")
    public String toAppInfo(){
        return "admin/app/appInfo";
    }

}

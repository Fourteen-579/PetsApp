package com.fourteen.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminHomeController {

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

}

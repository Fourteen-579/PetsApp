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

    @RequestMapping("/addArticle")
    public String toAddArticle(){
        return "admin/article/addArticle";
    }

    @RequestMapping("/articleList")
    public String toArticleList(){
        return "admin/article/articleList";
    }

    @RequestMapping("/addComment")
    public String toAddComment(){
        return "admin/comment/addComment";
    }

    @RequestMapping("/commentList")
    public String toCommentList(){
        return "admin/comment/commentList";
    }

    @RequestMapping("/addHelped")
    public String toAddHelped(){
        return "admin/helped/addHelped";
    }

    @RequestMapping("/helpedList")
    public String toHelpedList(){
        return "admin/helped/helpedList";
    }

    @RequestMapping("/addRescueInfor")
    public String toAddRescueInfor(){
        return "admin/rescueInfor/addRescueInfor";
    }

    @RequestMapping("/rescueInforList")
    public String toRescueInforList(){
        return "admin/rescueInfor/rescueInforList";
    }
}

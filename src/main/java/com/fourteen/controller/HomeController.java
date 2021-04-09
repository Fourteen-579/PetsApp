package com.fourteen.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/main")
    public String toMain(){
        return "main";
    }

    @RequestMapping("/userList")
    public String toUserList(){
        return "userList";
    }

}

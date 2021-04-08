package com.fourteen;


import com.fourteen.controller.UserController;
import com.fourteen.dao.UserMapper;
import com.fourteen.pojo.User;
import com.fourteen.service.UserService;
import com.fourteen.tools.CreateId;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test {
    @org.junit.Test
    public void testUUID() {
        System.out.println(CreateId.getUUID());
    }

    @org.junit.Test
    public void testAddUser(){
        ApplicationContext a = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper bean = a.getBean(UserMapper.class);
        User user = new User(CreateId.getUUID(),"name",10,"男","111","111");
        bean.addUser(user);

        List<User> list = bean.queryAll();
        for (User user1 : list) {
            System.out.println(user1);
        }
    }

    @org.junit.Test
    public void testService(){
        ApplicationContext a = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService bean = a.getBean(UserService.class);
        Object userService = a.getBean("userServiceImpl");

        System.out.println(bean.getClass());
        System.out.println(userService.getClass());

//        User user = new User(CreateId.getUUID(),"name",10,"男","111","111");
//        bean.addUser(user);
    }

    @org.junit.Test
    public void testArticle(){
        ApplicationContext a = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ArticleService bean = a.getBean(ArticleService.class);
//        System.out.println(bean.getClass());
        System.out.println(a.getBean("test2").getClass());
    }


    @org.junit.Test
    public void testController(){
        ApplicationContext a = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserController userController = a.getBean("userController", UserController.class);
        String s = userController.addUser();
        System.out.println(s);
    }

}

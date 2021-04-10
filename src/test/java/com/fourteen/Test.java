package com.fourteen;


import com.fourteen.controller.UserController;
import com.fourteen.dao.UserMapper;
import com.fourteen.pojo.User;
import com.fourteen.service.UserService;
import com.fourteen.tools.CreateId;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    @org.junit.Test
    public void testUUID() {
        System.out.println(CreateId.getUUID());
    }

    @org.junit.Test
    public void testAddUser(){
        ApplicationContext a = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper bean = a.getBean(UserMapper.class);

//        for (int i=1;i<30;i++){
//            User user = new User(CreateId.getUUID(),"name"+i,18+i,"男","imgUrl"+i,"location"+i);
//            bean.addUser(user);
//        }



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
//        UserController userController = a.getBean("userController", UserController.class);
//        String s = userController.addUser();
//        System.out.println(s);
    }

    @org.junit.Test
    public void testQueryLimitService(){
        ApplicationContext a = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userServiceImpl = a.getBean("userServiceImpl", UserService.class);
//        List<User> list = userServiceImpl.queryByLimit(3, 5);
//        for (User user : list) {
//            System.out.println(user);
//        }
    }

    @org.junit.Test
    public void testUpdateUser(){
        ApplicationContext a = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper bean = a.getBean(UserMapper.class);
        Map map = new HashMap();
        map.put("name","testName2");
        map.put("sex","女");
        map.put("id","0652df72-9a7c-4ec9-8b95-8f37b1e8af19");
        bean.UpdateUser(map);
    }

}

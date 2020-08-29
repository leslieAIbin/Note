package com.sxt.test;

import com.sxt.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: redis-code
 * @author: 雷哥
 * @create: 2019-12-31 16:36
 **/

public class TestApp {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        UserService userService = context.getBean(UserService.class);


//        List<User> users = userService.queryAllUser();
//        for (User user : users) {
//            System.out.println(user);
//        }
//        User user=new User();
//        user.setName("xiaoqiang");
//        user.setAddress("bj");
//        user.setBirth(new Date());
//        user.setFlag(0);
//        userService.insert(user);

//        User user = userService.selectByPrimaryKey(113);
//        System.out.println(user);
//
//        user.setName("xiaoming");
//        user.setAddress("wh");
//
//        userService.updateByPrimaryKey(user);


           userService.deleteByPrimaryKey(112);

        System.out.println("操作成功");

    }
}

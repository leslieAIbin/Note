package com.sxt;

import com.sxt.domain.User;
import com.sxt.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        User user = new User(1,"小明","武汉",new Date(),1);
        userService.insert(user);
        System.out.println("操作成功");
    }

    @Test
    void update() {
        User user = new User(2,"小明","武汉北京",new Date(),0);
        userService.updateByPrimaryKey(user);
        System.out.println("操作成功");
    }

    @Test
    void query() {
        User user = userService.selectByPrimaryKey(2);
        System.out.println(user);
        System.out.println("操作成功");
    }

    @Test
    void delete(){
        this.userService.deleteByPrimaryKey(2);
        System.out.println("操作成功");
    }

}

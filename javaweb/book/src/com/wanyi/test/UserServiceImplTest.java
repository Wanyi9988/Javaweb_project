package com.wanyi.test;

import com.wanyi.pojo.User;
import com.wanyi.service.UserService;
import com.wanyi.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceImplTest {
    UserService userService = new UserServiceImpl();

    @Test
    public void registUser() {
        User user = new User(0, "wanyi", "1012", "wanyi@163.com");
        userService.registUser(user);
    }

    @Test
    public void login() {
        User user = userService.login("admin", "123456");
        if (user == null) {
            System.out.println("登录失败");
        } else {
            System.out.println("登录成功");
        }
    }

    @Test
    public void existsUsername() {
        if(userService.existsUsername("wanyi")){
            System.out.println("该用户名存在");
        }else{
            System.out.println("该用户名不存在");
        }
    }
}
package com.wanyi.test;

import com.wanyi.dao.UserDao;
import com.wanyi.dao.impl.UserDaoImpl;
import com.wanyi.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {

    @Test
    public void queryUserByUsername() {
        UserDao userDao = new UserDaoImpl();
        User user = userDao.queryUserByUsername("admin");
        if (user == null) {
            System.out.println("该用户名可用");
        } else {
            System.out.println("该用户名已存在");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        UserDao userDao = new UserDaoImpl();
        User user = userDao.queryUserByUsernameAndPassword("admin123", "123456");
        if (user == null) {
            System.out.println("用户名或密码错误");
        } else {
            System.out.println("登陆成功");
        }
    }

    @Test
    public void saveUser() {
        UserDao userDao = new UserDaoImpl();
        User user = new User(0, "admin", "1012", "123321@163.com");
        int count = userDao.saveUser(user);
        if (count == -1) {
            System.out.println("添加失败");
        } else {
            System.out.println("添加成功");
        }
    }
}
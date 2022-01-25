package com.wanyi.service.impl;

import com.wanyi.dao.UserDao;
import com.wanyi.dao.impl.UserDaoImpl;
import com.wanyi.pojo.User;
import com.wanyi.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(String username, String password) {
        return userDao.queryUserByUsernameAndPassword(username, password);
    }

    @Override
    public boolean existsUsername(String username) {
        if (userDao.queryUserByUsername(username) != null) {
            return true;
        } else {
            return false;
        }
    }
}

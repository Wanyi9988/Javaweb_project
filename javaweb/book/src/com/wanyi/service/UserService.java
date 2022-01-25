package com.wanyi.service;

import com.wanyi.pojo.User;

public interface UserService {
    public void registUser(User user);

    public User login(String username, String password);

    public boolean existsUsername(String username);


}

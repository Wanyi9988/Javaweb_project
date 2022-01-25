package com.wanyi.test;

import org.junit.Test;

import java.lang.reflect.Method;

public class UserServletTest {


    protected void login() {
        System.out.println("这是login方法调用了");
    }

    public void regist() {
        System.out.println("这是regist方法调用了");
    }

    public void updateUser() {
        System.out.println("这是updateUser方法调用了");
    }

    public void updateUserPassword() {
        System.out.println("这是updateUserPassword方法调用了");
    }

    public static void main(String[] args) {
        String action = "login";
        try {
            Method declaredMethod = UserServletTest.class.getDeclaredMethod(action);
            declaredMethod.invoke(new UserServletTest());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}





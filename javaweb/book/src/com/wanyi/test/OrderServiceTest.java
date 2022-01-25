package com.wanyi.test;

import com.wanyi.pojo.Cart;
import com.wanyi.pojo.CartItem;
import com.wanyi.pojo.Order;
import com.wanyi.service.OrderService;
import com.wanyi.service.impl.OrderServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderServiceTest {
    OrderService orderService = new OrderServiceImpl();

    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"java",40,1));
        cart.addItem(new CartItem(2,"java1",32,3));
        cart.addItem(new CartItem(3,"java2",14,5));
        int userId = 1;

        System.out.println(orderService.createOrder(cart,userId));
    }
}
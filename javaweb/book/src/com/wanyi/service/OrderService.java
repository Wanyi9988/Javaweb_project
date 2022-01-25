package com.wanyi.service;

import com.wanyi.pojo.Cart;

public interface OrderService {
    public String createOrder(Cart cart, int userId);
}

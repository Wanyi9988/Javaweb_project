package com.wanyi.test;

import com.wanyi.dao.OrderItemDao;
import com.wanyi.dao.impl.OrderItemDaoImpl;
import com.wanyi.pojo.OrderItem;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderItemDaoTest {
    OrderItemDao orderItemDao = new OrderItemDaoImpl();
    @Test
    public void saveOrderItem() {
        orderItemDao.saveOrderItem(new OrderItem("123",1,100,100,"123"));
        orderItemDao.saveOrderItem(new OrderItem("123",1,100,100,"123"));
        orderItemDao.saveOrderItem(new OrderItem("123",1,100,100,"123"));

    }
}
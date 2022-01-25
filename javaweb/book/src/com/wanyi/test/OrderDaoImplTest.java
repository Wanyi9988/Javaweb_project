package com.wanyi.test;

import com.wanyi.dao.OrderDao;
import com.wanyi.dao.impl.OrderDaoImpl;
import com.wanyi.pojo.Order;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class OrderDaoImplTest {
    OrderDao orderDao = new OrderDaoImpl();

    @Test
    public void saveOrder() {
        orderDao.saveOrder(new Order("123", new Date(), 100, 0, 1));
        System.out.println(orderDao);
    }
}
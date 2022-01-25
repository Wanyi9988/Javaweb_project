package com.wanyi.service.impl;

import com.wanyi.dao.BookDao;
import com.wanyi.dao.OrderDao;
import com.wanyi.dao.OrderItemDao;
import com.wanyi.dao.impl.BookDaoImpl;
import com.wanyi.dao.impl.OrderDaoImpl;
import com.wanyi.dao.impl.OrderItemDaoImpl;
import com.wanyi.pojo.*;
import com.wanyi.service.OrderService;

import java.util.Date;
import java.util.Map;

public class OrderServiceImpl implements OrderService {
    OrderDao orderDao = new OrderDaoImpl();
    OrderItemDao orderItemDao = new OrderItemDaoImpl();
    BookDao bookDao = new BookDaoImpl();

    @Override
    public String createOrder(Cart cart, int userId) {
        String orderId = System.currentTimeMillis() + "" + userId;
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);
        orderDao.saveOrder(order);
        OrderItem orderItem;
        for (Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()) {
            CartItem item = entry.getValue();
            orderItem = new OrderItem(item.getName(), item.getCount(), item.getPrice(), item.getTotalPrice(), orderId);
            orderItemDao.saveOrderItem(orderItem);
            Book book = bookDao.queryById(item.getId());
            book.setSales(book.getSales() + item.getCount());
            book.setStock(book.getStock() - item.getCount());
            bookDao.updateBook(book);
        }
        cart.clear();
        return orderId;
    }
}

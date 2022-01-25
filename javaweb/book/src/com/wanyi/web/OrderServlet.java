package com.wanyi.web;

import com.wanyi.pojo.Cart;
import com.wanyi.pojo.User;
import com.wanyi.service.OrderService;
import com.wanyi.service.impl.OrderServiceImpl;
import com.wanyi.utils.JdbcUtils;
import com.wanyi.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

public class OrderServlet extends BaseServlet {
    private OrderService orderService = new OrderServiceImpl();
    public ThreadLocal<Connection> conn = new ThreadLocal<>();

    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        int userId = user.getId();
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        String orderId = orderService.createOrder(cart, userId);
        req.getSession().setAttribute("orderId", orderId);
        resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");
    }
}

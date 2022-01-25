package com.wanyi.web;

import com.google.gson.Gson;
import com.wanyi.dao.impl.BaseDao;
import com.wanyi.pojo.Book;
import com.wanyi.pojo.Cart;
import com.wanyi.pojo.CartItem;
import com.wanyi.service.BookService;
import com.wanyi.service.impl.BookServiceImpl;
import com.wanyi.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CartServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        System.out.println("加入购物车");
        Book book = bookService.queryBookById(id);
        CartItem cartItem = new CartItem(book.getId(), book.getName(), book.getPrice(), 1);
        cart.addItem(cartItem);
        req.getSession().setAttribute("cart", cart);
        req.getSession().setAttribute("newItem", book);
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        System.out.println("加入购物车");
        Book book = bookService.queryBookById(id);
        CartItem cartItem = new CartItem(book.getId(), book.getName(), book.getPrice(), 1);
        cart.addItem(cartItem);
        req.getSession().setAttribute("cart", cart);
        req.getSession().setAttribute("newItem", book);
        Map<String, Object> map = new HashMap<>();
        map.put("totalCount", cart.getTotalCount());
        map.put("newItemName", book.getName());
        Gson gson = new Gson();
        String s = gson.toJson(map);
        resp.getWriter().write(s);

    }

    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.deleteItem(id);
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.clear();
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        int count = WebUtils.parseInt(req.getParameter("count"), 0);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.updateCount(id, count);
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }
}

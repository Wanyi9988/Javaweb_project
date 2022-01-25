package com.wanyi.web;

import com.google.gson.Gson;
import com.wanyi.pojo.User;
import com.wanyi.service.UserService;
import com.wanyi.service.impl.UserServiceImpl;
import com.wanyi.utils.WebUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("login方法");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = (userService.login(username, password));
        if (user != null) {
            System.out.println("登录成功");
            request.getSession().setAttribute("user", user);
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
        } else {
            request.setAttribute("msg", "用户名或密码错误");
            request.setAttribute("username", username);
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        }
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }

    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");
        User user = WebUtils.copyParam2Bean(new User(), request.getParameterMap());
        String sessionCode = (String) request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        if (sessionCode != null && sessionCode.equalsIgnoreCase(code)) {
            if (!userService.existsUsername(username)) {
                userService.registUser(new User(0, username, password, email));
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);

            } else {
                request.setAttribute("msg", "该用户名已占用");
                request.setAttribute("password", password);
                request.setAttribute("email", email);
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);

            }
        } else {
            request.setAttribute("msg", "验证码错误");
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            request.setAttribute("email", email);
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
        }
    }

    protected void ajaxExistsUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        boolean existsUsername = userService.existsUsername(username);
        Map<String, Boolean> result = new HashMap<>();
        result.put("existsUsername", existsUsername);
        Gson gson = new Gson();

        String s = gson.toJson(result);
        resp.getWriter().write(s);

    }
}

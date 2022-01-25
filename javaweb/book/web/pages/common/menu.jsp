<%--
  Created by IntelliJ IDEA.
  User: 56573
  Date: 2022/1/18
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
    <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临Wanyi书城</span>
    <a href="pages/cart/cart.jsp">购物车</a>
    <a href="pages/order/order.jsp">我的订单</a>
    <a href="pages/manager/manager.jsp">后台管理</a>
    <a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
    <a href="index.jsp">返回</a>
</div>


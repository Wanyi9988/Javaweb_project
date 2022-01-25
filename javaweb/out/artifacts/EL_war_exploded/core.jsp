<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.wanyi.bean.Student" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 56573
  Date: 2022/1/17
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    List<Student> list = new ArrayList<>();
    for (int i = 1; i <= 10; i++) {
        list.add(new Student(i, "username" + i, "password" + i, i + 18, "phone" + i));
    }
    request.setAttribute("students", list);
%>
<table border="1" cellspacing="0">
    <tr>
        <th>编号</th>
        <th>用户名</th>
        <th>密码</th>
        <th>年龄</th>
        <th>电话</th>
        <th>操作</th>
    </tr>
    <c:forEach begin="1" end="7" step="2" varStatus="status" items="${students}" var="i">
        <tr>
            <td>${i.ID}</td>
            <td>${i.username}</td>
            <td>${i.password}</td>
            <td>${i.age}</td>
            <td>${i.phone}</td>
            <td>修改、删除</td>
            <td>${status.step}</td>
        </tr>

    </c:forEach>
</table>
</body>
</html>

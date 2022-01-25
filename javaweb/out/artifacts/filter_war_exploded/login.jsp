<%--
  Created by IntelliJ IDEA.
  User: 56573
  Date: 2022/1/24
  Time: 8:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

这是登录页面
<form action="http://localhost:8080/filter/loginServlet" method="get">
    用户名：<input type="text" name="username"><br>
    密码：<input type="password" name="password"><br>
    <input type="submit" value="提交">
</form>

</body>
</html>

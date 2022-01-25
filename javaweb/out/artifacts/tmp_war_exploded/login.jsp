<%--
  Created by IntelliJ IDEA.
  User: 56573
  Date: 2022/1/23
  Time: 9:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="http://localhost:8080/tmp/loginServlet">
    用户名：<input type="text" name="username"/><br>
    验证码：<input type="text" name="code">
    <img src="http://localhost:8080/tmp/kaptcha.jpg"><br>
    <input type="submit" value="登录">
</form>
</body>
</html>

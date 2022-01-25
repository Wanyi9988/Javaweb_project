<%--
  Created by IntelliJ IDEA.
  User: 56573
  Date: 2022/1/22
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="Http://localhost:8080/cookie_session/loginServlet" method="post">
    用户名：<input type="text" name="username" value="${cookie.username.value}"><br>
    密码：<input type="password" name="password"><br>
    <input type="submit" value="login">
</form>

</body>
</html>

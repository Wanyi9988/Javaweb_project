<%@ page import="com.wanyi.bean.Person" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 56573
  Date: 2022/1/17
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Map<String, String> map = new HashMap<>();
    map.put("a.a.a", "aaa");
    map.put("b+b+b", "bbb");
    map.put("c+c+c", "ccc");
    request.setAttribute("map", map);
%>
${map['a.a.a']}<br>
${map['b+b+b']}<br>
${map['c+c+c']}<br>
</body>
</html>

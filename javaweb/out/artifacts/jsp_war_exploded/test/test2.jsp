<%@ page import="com.wanyi.bean.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 56573
  Date: 2022/1/17
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table {
            border: chartreuse;
        }
    </style>
</head>
<body>

<%
    List<Student> list = (List<Student>) request.getAttribute("stuList");
%>
<table border="1" cellspacing="0">
    <tr>
        <td>
            <%="姓名"%>
        </td>
        <td>
            <%="ID"%>
        </td>
        <td>
            <%="年龄"%>
        </td>
        <td>
            <%="操作"%>
        </td>
    </tr>
    <%
        for (Student s : list) {%>
    <tr>
        <td>
            <%= s.getName()%>
        </td>
        <td>
            <%= s.getId()%>
        </td>
        <td>
            <%=s.getAge()%>
        </td>
        <td>
            <%="修改、删除"%>
        </td>
    </tr>
    <% }
    %>
</table>
</body>
</html>

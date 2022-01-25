<%--
  Created by IntelliJ IDEA.
  User: 56573
  Date: 2022/1/17
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<h1 align="center">九九乘法表</h1>
<table border="1" cellspacing="0" width="700" align="center">
    <%
        for (int i = 1; i <= 9; i++) {%>
    <tr>
        <% for (int j = 1; j <= i; j++) {
        %>

        <td><%=j + "*" + i + "=" + i * j%>
        </td>
        <%
            }%>
    </tr>
    <br><%
    }
%>
</table>
</body>
</html>

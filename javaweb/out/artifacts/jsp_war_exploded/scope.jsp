<%--
  Created by IntelliJ IDEA.
  User: 56573
  Date: 2022/1/17
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>这是scope.jsp页面</h1>
<%
    pageContext.setAttribute("key", "pageContext");
    request.setAttribute("key", "request");
    session.setAttribute("key", "session");
    application.setAttribute("key", "application");
%>
pageContext域的值：<%=pageContext.getAttribute("key")%><br>
request域的值：<%=request.getAttribute("key")%><br>
session域的值：<%=session.getAttribute("key")%><br>
application域的值：<%=application.getAttribute("key")%><br>

<%--<%--%>
<%--    request.getRequestDispatcher("/scope2.jsp").forward(request, response);--%>
<%--%>--%>

<jsp:forward page="/scope2.jsp"></jsp:forward>
</body>
</html>

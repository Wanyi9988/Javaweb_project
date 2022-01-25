<%--
  Created by IntelliJ IDEA.
  User: 56573
  Date: 2022/1/17
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${pageContext.request.scheme}<br>
${pageContext.request.serverName}<br>
${pageContext.request.serverPort}<br>
${pageContext.request.contextPath}<br>
${pageContext.request.method}<br>
${pageContext.request.remoteHost}<br>
${pageContext.session.id}<br>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: 56573
  Date: 2022/1/17
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
头部信息<br>
主体内容<br>
<jsp:include page="/include/foot.jsp">
    <jsp:param name="key1" value="value1"/>
    <jsp:param name="key2" value="value2"/>
</jsp:include>
</body>
</html>

<%@ page import="java.util.Locale" %>
<%@ page import="java.util.ResourceBundle" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="pragma" content="no-cache"/>
    <meta http-equiv="cache-control" content="no-cache"/>
    <meta http-equiv="Expires" content="0"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<%
    Locale locale = null;
    String country = request.getParameter("country");
    if ("cn".equals(country)) {
        locale = Locale.CHINA;
    } else {
        locale = Locale.US;
    }
    ResourceBundle bundle = ResourceBundle.getBundle("i18n", locale);
%>
<a href="i18n.jsp?country=cn">中文</a>|
<a href="i18n.jsp?country=us">english</a>
<center>
    <h1><%=bundle.getString("regist")%>
    </h1>
    <table>
        <form>
            <tr>
                <td><%=bundle.getString("username")%>
                </td>
                <td><input name="username" type="text"/></td>
            </tr>
            <tr>
                <td><%=bundle.getString("password")%>
                </td>
                <td><input type="password"/></td>
            </tr>
            <tr>
                <td><%=bundle.getString("gender")%>
                </td>
                <td><input type="radio"/><%=bundle.getString("boy")%><input type="radio"/><%=bundle.getString("girl")%>
                </td>
            </tr>
            <tr>
                <td><%=bundle.getString("email")%>
                </td>
                <td><input type="text"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="reset" value="<%=bundle.getString("reset")%>"/>&nbsp;&nbsp;
                    <input type="submit" value="<%=bundle.getString("submit")%>"/></td>
            </tr>
        </form>
    </table>
    <br/> <br/> <br/> <br/>
</center>
国际化测试：
<br/> 1、访问页面，通过浏览器设置，请求头信息确定国际化语言。
<br/> 2、通过左上角，手动切换语言
</body>
</html>
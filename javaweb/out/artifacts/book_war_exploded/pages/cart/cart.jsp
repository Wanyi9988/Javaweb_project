<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <%@ include file="/pages/common/head.jsp" %>
    <script type="text/javascript">
        $(function () {
            $("a.delete").click(function () {
                return confirm("确定要删除《" + $(this).parent().parent().find("td:first").text() + "》吗？");
            })
            $("#clear").click(function () {
                return confirm("确定要清空购物车吗？");
            })
            $("input.updateCount").change(function () {
                var name = $(this).parent().parent().find("td:first").text();
                var count = this.value;
                if (confirm("确定要将《" + name + "》的数量修改为" + count + "吗")) {
                    location.href="cartServlet?action=updateCount&id="+$(this).attr("bookId")+"&count="+count;
                } else {
                    this.value = this.defaultValue;
                }
            })
        })
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">购物车</span>
    <%@ include file="/pages/common/menu.jsp" %>
</div>

<div id="main">

    <table>
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>金额</td>
            <td>操作</td>
        </tr>
        <c:if test="${empty sessionScope.cart.items}">
            <tr>
                <td colspan="5"><a href="index.jsp">当前购物车为空 点击前往商品页</a></td>
            </tr>
        </c:if>
        <c:forEach items="${sessionScope.cart.items.values()}" var="item">
            <tr>
                <td>${item.name}</td>
                <td><input bookId="${item.id}" type="text" value="${item.count}" class="updateCount" style="width:50px"/></td>
                <td>${item.price}</td>
                <td>${item.totalPrice}</td>
                <td><a class="delete" href="cartServlet?action=deleteItem&id=${item.id}">删除</a></td>
            </tr>
        </c:forEach>
    </table>

    <c:if test="${!empty sessionScope.cart.items}">
        <div class="cart_info">
            <span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
            <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
            <span class="cart_span"><a id="clear" href="cartServlet?action=clear">清空购物车</a></span>
            <span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
        </div>
    </c:if>
</div>

<%@ include file="/pages/common/foot.jsp" %>
</body>
</html>
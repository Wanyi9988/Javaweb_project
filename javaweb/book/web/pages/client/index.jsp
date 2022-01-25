<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>书城首页</title>
    <%@ include file="/pages/common/head.jsp" %>
    <script type="text/javascript">
        $(function () {
            // $("button.addItem").click(function () {
            //     var id = $(this).attr("itemId");
            //     location.href = "http://localhost:8080/book/cartServlet?action=addItem&id=" + id;
            // })
            $("button.addItem").click(function () {
                $.getJSON("http://localhost:8080/book/cartServlet", "action=ajaxAddItem&id=" + $(this).attr("itemId"), function (data) {
                    $("#totalCount").text("您的购物车中有"+data.totalCount+"件商品");
                    $("#newItemName").text("您刚刚将《"+data.newItemName+"》加入到了购物车中");
                })
            })
        })
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">网上书城</span>

    <div>
        <c:if test="${empty sessionScope.user}">
            <a href="pages/user/login.jsp">登录</a> |
            <a href="pages/user/regist.jsp">注册</a>
            <a href="pages/manager/manager.jsp">后台管理</a>&nbsp;&nbsp;
        </c:if>
        <c:if test="${!empty sessionScope.user}">
            <%@include file="/pages/common/menu.jsp" %>
        </c:if>
    </div>

</div>
<div id="main">
    <div id="book">
        <div class="book_cond">
            <form action="client/bookServlet" method="get">
                <input type="hidden" name="action" value="searchByPrice">
                价格：<input id="min" type="text" name="min" value="${param.min}"> 元 -
                <input id="max" type="text" name="max" value="${param.max}"> 元
                <input type="submit" id="search" value="查询"/>
            </form>
        </div>


        <div style="text-align: center">
            <c:if test="${!empty sessionScope.cart.items}">
                <span id="totalCount">您的购物车中有${sessionScope.cart.totalCount}件商品</span>
                <div id="newItemName">

                </div>
            </c:if>
            <c:if test="${empty sessionScope.cart.items}">
                <span id="totalCount">当前购物车为空</span>
                <div id="newItemName">

                </div>
            </c:if>
        </div>


        <c:forEach items="${requestScope.page.items}" var="book">
            <div class="b_list">
                <div class="img_div">
                    <img class="book_img" alt="" src="${book.imgPath}"/>
                </div>
                <div class="book_info">
                    <div class="book_name">
                        <span class="sp1">书名:</span>
                        <span class="sp2">${book.name}</span>
                    </div>
                    <div class="book_author">
                        <span class="sp1">作者:</span>
                        <span class="sp2">${book.author}</span>
                    </div>
                    <div class="book_price">
                        <span class="sp1">价格:</span>
                        <span class="sp2">￥${book.price}</span>
                    </div>
                    <div class="book_sales">
                        <span class="sp1">销量:</span>
                        <span class="sp2">${book.sales}</span>
                    </div>
                    <div class="book_amount">
                        <span class="sp1">库存:</span>
                        <span class="sp2">${book.stock}</span>
                    </div>
                    <div class="book_add">
                        <button itemId="${book.id}" class="addItem">加入购物车</button>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

    <%@include file="/pages/common/page.jsp" %>

</div>

<%@ include file="/pages/common/foot.jsp" %>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: 56573
  Date: 2022/1/22
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div id="page_nav">
    <c:if test="${requestScope.page.pageIndex>1}">
        <a href="${requestScope.page.url}&pageIndex=1&itemsPerPage=${requestScope.page.itemsPerPage}">首页</a>
        <a href="${requestScope.page.url}&pageIndex=${requestScope.page.pageIndex-1}&itemsPerPage=${requestScope.page.itemsPerPage}">上一页</a>

    </c:if>
    <c:choose>
        <c:when test="${requestScope.page.pageCount<=5}">
            <c:set var="begin" value="1"/>
            <c:set var="end" value="${requestScope.page.pageCount}"/>
        </c:when>
        <c:when test="${requestScope.page.pageCount>5}">
            <c:choose>
                <c:when test="${requestScope.page.pageIndex<=3}">
                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="5"/>
                </c:when>
                <c:when test="${requestScope.page.pageIndex>=requestScope.page.pageCount-2}">
                    <c:set var="begin" value="${requestScope.page.pageCount-4}"/>
                    <c:set var="end" value="${requestScope.page.pageCount}"/>
                </c:when>
                <c:otherwise>
                    <c:set var="begin" value="${requestScope.page.pageIndex-2}"/>
                    <c:set var="end" value="${requestScope.page.pageIndex+2}"/>
                </c:otherwise>
            </c:choose>
        </c:when>
    </c:choose>
    <c:forEach begin="${begin}" end="${end}" var="i">
        <c:if test="${i!=requestScope.page.pageIndex}">
            <a href="${requestScope.page.url}&pageIndex=${i}">${i}</a>
        </c:if>
        <c:if test="${i==requestScope.page.pageIndex}">
            <a>【${i}】</a>
        </c:if>
    </c:forEach>
    <c:if test="${requestScope.page.pageIndex<requestScope.page.pageCount}">
        <a href="${requestScope.page.url}&pageIndex=${requestScope.page.pageIndex+1}&itemsPerPage=${requestScope.page.itemsPerPage}">下一页</a>
        <a href="${requestScope.page.url}&pageIndex=${requestScope.page.pageCount}&itemsPerPage=${requestScope.page.itemsPerPage}">末页</a>
    </c:if>
    共<a class="pageCount">${requestScope.page.pageCount}</a>页，${requestScope.page.itemCount}条记录
    到第<input value="${param.pageIndex}" name="pn" id="pn_input"/>页
    <input type="button" id="jumpTo" value="确定">
</div>
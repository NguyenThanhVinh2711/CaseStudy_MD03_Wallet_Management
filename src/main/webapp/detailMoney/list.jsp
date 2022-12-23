<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>DetailMoney Management Application</title>
    <%@include file="/css.jsp"%>

</head>
<body style="background-color: #f0fcff;">
<c:if test="${empty userobj }">
    <c:redirect url="/login.jsp"></c:redirect>
</c:if>
<%@include file="/navbar.jsp"%>
<center>
    <h1>DetailMoney Management</h1>
    <h2>
        <a href="/detailMoneys?action=createIn">Add New  Money Income </a>
    </h2>
    <h2>
        <a href="/detailMoneys?action=createOut">Add New  Money Outcome </a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
<%--        <caption><h2>List of DetailMoneys</h2></caption>--%>
        <tr>
            <th>idDetail</th>
            <th>wallet</th>
            <th>money</th>
            <th>category</th>
            <th>note</th>
            <th>date</th>
            <th>Actions</th>
        </tr>
        <c:forEach  var="detailMoney" items="${listDetailMoney}">
            <tr>
                <td><c:out value="${detailMoney.idDetail}"/></td>
                <td><c:out value="${detailMoney.name_wallet}"/></td>
                <td><c:out value="${detailMoney.money}"/></td>

                <td><c:if test="${detailMoney.money<0}">
                    <c:out value="${detailMoney.name_category}"/>
                </c:if>

                </td>
                <td><c:out value="${detailMoney.note}"/></td>
                <td><c:out value="${detailMoney.date}"/></td>
                <td><c:if test="${detailMoney.money>0}">
                    <a href="/detailMoneys?action=editAdd&id=${detailMoney.idDetail}">Change Add
                    </a>
                </c:if>
                    <c:if test="${detailMoney.money<0}">
                        <a href="/detailMoneys?action=editSub&id=${detailMoney.idDetail}">Change Sub</a>
                    </c:if>


                    <a href="/detailMoneys?action=delete&id=${detailMoney.idDetail}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<div class="center ">
    <a  href="/detailMoneys?action=sortByDate" ><input class="btn btn-primary mt-2" type="button" value="sort By Date Increase "></a>
    <br>
    <a href="/detailMoneys?action=reverseDate"><input class="btn btn-primary mt-2" type="button" value="sort By Date Decrease"></a>
    <br>
    <a  href="detailMoneys?action=statisticRangeDate"><input class="btn btn-primary mt-2" type="button" value="Statistic Range Date"></a>
    <br>
    <a  href="detailMoneys?action=statisticToday"><input class="btn btn-primary mt-2" type="button" value="Statistic Today"></a>
</div>
</body>
</html>
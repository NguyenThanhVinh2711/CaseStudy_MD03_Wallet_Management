<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Detail Money Wallet User</title>
</head>
<body>
<h1 align="center" > Detail Money Wallet User</h1>
<div align="center" >
<%--    <h2><a href="/categorys?action=create"> Create new category </a></h2>--%>
    <table border="1">
        <caption><h2>List Detail Money Wallet User </h2></caption>
        <tr>
            <th>Icon</th>
            <th>Name</th>
            <th>Final Money</th>
            <th>Sum Money</th>
        </tr>
        <c:forEach var="detail" items="${detailMWUList}">
            <tr>
                <td><c:out value="${detail.icon}"/></td>
                <td><c:out value="${detail.name}"/></td>
                <td><c:out value="${detail.finalMoney}"/></td>
                <td><c:out value="${detail.sumMoney}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

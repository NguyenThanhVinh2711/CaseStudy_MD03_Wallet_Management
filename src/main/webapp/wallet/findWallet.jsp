<%--
  Created by IntelliJ IDEA.
  wallet: Dell
  Date: 9/30/2022
  Time: 2:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>User Management</h1>
<h2>
    <a href="/wallets?action=wallets">List All Users</a>
</h2>
<table border="1" cellpadding="5">
    <caption><h2> Result </h2></caption>
    <tr>
        <th>ID</th>
        <th>ID wallet</th>
        <th>Icon</th>
        <th>Name Wallet</th>
        <th>Description</th>
    </tr>
    <c:forEach var="wallet" items="${WalletByName}">
        <tr>
            <td><c:out value="${wallet.getIdWallet()}"/></td>
            <td><c:out value="${wallet.getIdUser()}"/></td>
            <td><img src="<c:out value="${wallet.getIcon()}"/>" alt="image" width="=100px" height="100px"></td>
            <td><c:out value="${wallet.getNameWallet()}"/></td>
            <td><c:out value="${wallet.getDescription()}"/></td>
        </tr>
    </c:forEach>
</table><br>

</body>
</html>

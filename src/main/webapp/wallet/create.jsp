<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>Wallet Management</h1>
    <h2>
        <a href="/wallets?action=wallets">List All Wallets</a>
    </h2>
</center>
<div align="center">
    <form method="post" action="/wallets?action=create">
        <table border="1" cellpadding="5">
<%--            <tr>--%>
<%--                <th> Id User:</th>--%>
<%--                <td>--%>
<%--                    <input type="text" name="idUser" id="idUser" size="40"/>--%>
<%--                </td>--%>
<%--            </tr>--%>
            <tr>
                <th> Icon: </th>
                <td>
                    <input type="text" name="icon" id="icon" size="40"/>
                </td>
            </tr>
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="40"/>
                </td>
            </tr>
            <tr>
                <th>Description:</th>
                <td>
                    <input type="text" name="description" id="description" size="40"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
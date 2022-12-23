<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>wallet Management Application</title>
</head>
<body>
<center>
    <h1>wallet Management</h1>
    <h2>
        <a href="/wallets?action=wallets">List All wallets</a>
    </h2>
</center>
<div align="center">
    <form method="post" action="/wallets?action=edit" >
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit wallet
                </h2>
            </caption>
            <c:if test="${wallet != null}">
                <input type="hidden" name="idWallet" value="<c:out value='${wallet.idWallet}' />"/>
            </c:if>
<%--            <tr>--%>
<%--                <th>Id user :</th>--%>
<%--                <td>--%>
<%--                    <input type="text" name="idUser" size="45"--%>
<%--                           value="<c:out value='${wallet.idUser}' />"--%>
<%--                    />--%>
<%--                </td>--%>
<%--            </tr>--%>
            <tr>
                <th>Icon wallet :</th>
                <td>
                    <input type="text" name="icon" size="45"
                           value="<c:out value='${wallet.icon}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Name wallet :</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${wallet.nameWallet}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Description: </th>
                <td>
                    <input type="text" name="description" size="45"
                           value="<c:out value='${wallet.description}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
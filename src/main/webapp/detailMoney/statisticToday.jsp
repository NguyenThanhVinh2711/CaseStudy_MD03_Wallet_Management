<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Statistic Form Picker</title>
</head>
<body>
<h1 align="center">Statistic Detail Money Form</h1>
<div align="center">
  <form method="post">
    <table border="1" cellpadding="5">
      <caption>
        <h2>Statistic Today</h2>
      </caption>
      <tr>
        <th>Wallet:</th>
        <td>
          <select name="id_wallet" >
            <option value="0">All Wallet</option>
            <c:forEach var="wallet" items="${walletList}">
              <option value="${wallet.idWallet}"><c:out value="${wallet.nameWallet}"/></option>
            </c:forEach>
          </select>
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
<head>
  <title>Title</title>
</head>
<body>

</body>
</html>

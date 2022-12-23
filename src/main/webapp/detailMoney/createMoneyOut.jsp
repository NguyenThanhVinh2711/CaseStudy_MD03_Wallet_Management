<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Detail Money Management Application</title>
</head>
<body>
<center>
  <h1>Detail Money Outcome Management</h1>
  <h2>
    <a href="detailMoneys?action=detailMoneys">List All DetailMoneys</a>
  </h2>
</center>
<div align="center">
  <form method="post">
    <table border="1" cellpadding="5">
      <caption>
        <h2>Add New DetailMoney</h2>
      </caption>
      <tr>
        <th> Wallet:</th>
        <td>
          <select name="id_wallet" >
            <c:forEach var="wallet" items="${walletList}">
              <option value="${wallet.idWallet}"><c:out value="${wallet.nameWallet}"/></option>
            </c:forEach>
          </select>
        </td>
      </tr>
      <tr>
        <th>Amount Of Money:</th>
        <td>
          <input type="text" name="money"  size="45" required onkeypress="return (event.charCode == 8 || event.charCode == 0 || event.charCode == 13) ? null : event.charCode >= 48 && event.charCode <= 57"/>
        </td>
      </tr>
      <tr>
        <th>Category</th>
        <td>
          <select name="id_category" >
            <c:forEach var="category" items="${categoryList}">
              <option value="${category.idCategory}"><c:out value="${category.name}"/></option>
            </c:forEach>
          </select>
        </td>

      </tr>
      <tr>
        <th>Note</th>
        <td>
          <input type="text" name="note"  size="15" />
        </td>
      </tr>
      <tr>
        <th>Date</th>
        <td>
          <input type="date" name="date" required size="15"/>
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
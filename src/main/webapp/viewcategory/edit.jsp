<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Category</title>
</head>
<body style="background-color: lemonchiffon;">
<center>
    <h1>Edit</h1>
    <h2 align="center">
        <a href="/categorys?action=categorys"><input type="button" value="Return Category"> </a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1px"  width="700px"  style="font-size: 30px " bgcolor="#ffb6c1">
            <c:if test="${showCategory != null}">
                <input type="hidden" name="idCategory" value="<c:out value='${showCategory.idCategory}' />"/>
            </c:if>
            <tr>
                <th>Category Name:</th>
                <td>
                    <input type="text" name="name" size="60"
                           value="<c:out value='${showCategory.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Category Note:</th>
                <td>
                    <input type="text" name="note" size="60"
                           value="<c:out value='${showCategory.note}' />"
                    />
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

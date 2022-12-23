<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New Category</title>
</head>
<body style="background-color: lemonchiffon;">
<div>
    <h1 align="center" >Create New Category </h1>
    <h2 align="center">   <a href="/categorys?action=categorys"> <input type="button" value="Return Category"> </a> </h2>
    <div align="center">
        <form method="post">
            <table border="1px"  width="700px"  style="font-size: 30px " bgcolor="#ffb6c1">
                <tr>
                    <th>Name:</th>
                    <td>
                        <input type="text" name="name" id="name" size="70"/>
                    </td>
                </tr>
                <tr>
                    <th>Note:</th>
                    <td>
                        <input type="text" name="note" id="note" size="70"/>
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
</div>
</body>
</html>

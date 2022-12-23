<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 02/10/2022
  Time: 9:38 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Sign Up</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
</head>
<body>
<div class="main">

    <!-- Sign up form -->
    <section class="signup">
        <div class="container">
            <div class="signup-content">
                <div class="signup-form">
        <legend><h1 style="text-align: center">Sign Up</h1></legend>
        <c:if test="${not empty succMsg }">
            <p class="text-center text-success">${succMsg }</p>
            <c:remove var="succMsg" scope="session"/>
        </c:if>

        <c:if test="${not empty failedMsg}">
            <p class="text-center text-danger">${failedMsg }</p>
            <c:remove var="failedMsg" scope="session"/>
        </c:if>
        <form action="/register" method="post" class="register-form">
            <table>
                <tr class="form-group">
                    <td>UserName:</td>
                    <td><input placeholder="" type="text"  name="userName" required></td>

                </tr>
                <tr class="form-group">
                    <td>Password:</td>
                    <td><input type="password" name="password" required></td>

                </tr >
                <tr class="form-group">
                    <td>Confirm Password:</td>
                    <td><input placeholder="" name="rePass" type="password" idCategory="myInput"></td>
                </tr>
                <tr class="form-group">
                    <td style="text-align: right"><input style="display: inline" type="checkbox" onclick="myFunction()"></td>
                    <td>Show Password</td>

                </tr>

            </table>
            <input class="submit" type="submit" value="Register">
        </form>
                </div>
                <div class="signup-image">
                    <figure class="imgs">
                        <img src="/img/signup-image.jpg" alt="sing up image">
                    </figure>
                    <h5 style="text-align: center"> Already User?</h5>
                   <a href="login.jsp"><input  style="font-size: 150%" type="submit" value="LogIn"></a>
                </div>
            </div>
        </div>
    </section>
</div>
<script src="js/main.js"></script>

<script>
    function myFunction() {
        var x = document.getElementById("myInput");
        if (x.type === "password") {
            x.type = "text";
        } else {
            x.type = "password";
        }
    }
</script>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 04/10/2022
  Time: 8:30 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
        <html>
<head>
    <title>LogIn Manage E-wallet</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="main">

    <!-- Sing in  Form -->
    <section class="sign-in">
        <div class="container">
            <div  style="padding-top: -200px" class="signin-content">
                <div class="signin-image">
                    <figure>
                        <img  src="/img/signin-image.jpg" alt="sing up image">
                    </figure>
                    <a style="text-decoration: none; font-size: 120%; margin-left: 80px" href="register.jsp" class="signup-image-link">Create an
                        account</a>
                </div>

                <div class="signin-form">
                    <h1 class="form-title">Sign In</h1>
                    <c:if test="${not empty failedMsg }">
                        <p class="text-center text-danger">${failedMsg }</p>
                        <c:remove var="failedMsg" scope="session"/>
                    </c:if>
                    <c:if test="${not empty succMsg }">
                        <p class="text-center text-success">${succMsg }</p>
                        <c:remove var="succMsg" scope="session"/>
                    </c:if>
                    <form method="post" action="/login" class="register-form"
                          idCategory="login-form">
                        <div class="form-group">
                            <label for="username"></label> <input
                                type="text" name="userName" idCategory="username"
                                placeholder="Your Name" />
                        </div>
                        <div class="form-group">
                            <label for="password"></label> <input
                                type="password" name="password" idCategory="password"
                                placeholder="Password" />
                        </div>
                        <div class="form-group">
                            <label  for="remember-me"
                                   class="label-agree-term"><span><span></span></span>Remember
                                me</label><input style="margin-top: -20px;margin-left: -50px" type="checkbox" name="remember-me" idCategory="remember-me"
                                   class="agree-term" />
                        </div>
                        <div class="form-group form-button">
                            <input class="submit" type="submit" name="signin" idCategory="signin"
                                   class="form-submit" value="Log in" />
                        </div>
                    </form>
                    <div style="margin-top: -10px; text-align: center" class="social-login">
                        <span class="social-label">Or login with</span>
                        <ul class="socials">
                            <li><a href="#"><i style="color:cyan; font-size: 150%;" class="fa fa-twitter"></i></a></li>
                            <li><a href="#"><i style="color: mediumblue; font-size: 150%;" class="fa fa-facebook-square"></i></a></li>
                            <li><a href="#"><i style="color: red; font-size: 150%;" class="fa fa-google"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </section>

</div>

</body>
</html>

<%@ page import="model.Users" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 05/10/2022
  Time: 3:27 CH
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<div class="container-fluid" style="height:10px; background-color: #eee3e7"></div>
<%
    Users u=(Users)session.getAttribute("userobj");
%>

<div class="container-fluid p-3 bg-light">
    <div class="row">
        <div class="col-md-3 text-success">
            <h3>
                <i class="fa fa-credit-card-alt" aria-hidden="true"></i>  E-WALLET
            </h3>
        </div>
        <div class="col-md-6">
            <form class="form-inline my-2 my-lg-0" action="search.jsp" method="post">
                <input class="form-control mr-sm-2" type="search" name="ch" placeholder="Search" aria-label="Search">
                <button class="btn btn-primary my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>

        <c:if test="${not empty userobj }">
            <div class="col-md-3">
              <p>All Money: <c:out value="${sum}"></c:out></p>

                <a  class="btn btn-success ml-4"><i class="fas fa-user-plus"></i> ${userobj.userName}</a>
                <a href="logout"
                   class="btn btn-primary"><i class="fas fa-sign-in-alt"></i> Logout</a>
            </div>
        </c:if>

        <c:if test="${empty userobj }">
            <div class="col-md-3">
                <a href="login.jsp" class="btn btn-success"><i class="fa-solid fa-lock"></i> Login</a>


                <a href="register.jsp"
                   class="btn btn-primary"><i class="fa-solid fa-user-plus"></i>Register</a>
            </div>
        </c:if>


    </div>
</div>
<nav class="navbar navbar-expand-lg navbar-dark bg-custom">
    <a style="color: #222222" class="navbar-brand " href="#"> <i class="fa-solid fa-house"></i></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" idCategory="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a style="color: #222222" class="nav-link dark" href="login">Home <span class="sr-only">(current)</span></a>
            </li>
            <%
            if(u==null){%>
            <a href="login.jsp"></a>

            <%
                }else{%>

            <li class="nav-item active">
                <a style="color: #222222" class="nav-link " href="/categorys?action=jjj"><i class="fa fa-id-card" aria-hidden="true"></i> Category Wallet</a>
            </li>

            <li class="nav-item active">
                <a style="color: #222222" class="nav-link " href="detailMoneys?action=detailMoneys"><i class="fa fa-credit-card" aria-hidden="true"></i> Statistic Roll</a>
            </li>

            <li class="nav-item active">
                <a style="color: #222222" class="nav-link disabled " href="/wallets?action=dd"><i class="fa fa-cc-discover" aria-hidden="true"></i>Wallet</a>
            </li>
            <%
                }
            %>

        </ul>
        <form class="form-inline my-2 my-lg-0">
            <a href="#" class="btn btn-light my-2 my-sm-0" type="submit"><i class="fa-solid fa-gear"></i> Setting</a>

            <button class="btn btn-light my-2 my-sm-0 ml-3" type="submit"><i class="fa-brands fa-telegram"></i> Contact</button>
        </form>
    </div>
</nav>

<%@ page import="model.Users" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 05/10/2022
  Time: 11:31 SA
  To change this template use File | Settings | File Templates.
--%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Index</title>
    <%@include file="css.jsp"%>
<%--<link rel="stylesheet" type="text/css" href="css/styles.css">--%>
    <style type="text/css">
        .back-img{
            background: url("img/e-wallet-service-isometric.jpg");
            height: 70vh;
            width: 100%;
            background-size: cover;
        }
        .crd-ho:hover{
            background-color: #f5f5f5;
        }
        H2{

            color: #F34093;
        }
    </style>

</head>
<body>
<%--<body style="background-color: #dec3c3">--%>


<%@include file="navbar.jsp"%>
<div class="container-fluid back-img">
    <h2 class="text-center">E-Wallet Management System</h2>
</div>

<section class="services" idCategory="services">
    <div class="center">
        <h3>WHAT WE HAVE ?</h3>
    </div>
    <div class="service-content">
<%--        <form method="get" action="/detailMWU">--%>
        <c:forEach var="detail" items="${detailMWUList}">
        <div class="col">
            <c:if test="${not empty userobj }">
                <i class="bx bx-cast"></i>
                <img width="250px" height="100px" src="<c:out value="${detail.icon}"/>">
                <h3> <c:out value="${detail.name}"/></h3>

                <p>Total number money in wallet: <c:out value="${detail.sumMoney}"/></p>
                <p>Total money in current: <c:out value="${detail.finalMoney}"/></p>
                <%--            href="view_books.jsp?bid=<%=b.getBookId() %>"--%>
                <a href="/detailMoneys?action=listDetailMoneyById_wallet&idWallet=${detail.idWallet}" style="color: white;" class="btn btn-primary btn-sm ml-1">Details </a>
            </c:if>
        </div>
    </c:forEach>
<%--    </form>--%>

<%--        <div class="col">--%>
<%--            <i class="bx bx-layer"></i>--%>

<%--            <img width="250px" height="100px" src="img/A047eK0I0wYdKBXg2H2BQLSjQRQTVaLhq92J4Yk1.png">--%>
<%--            <h3> VinID PAY</h3>--%>
<%--            <c:if test="${not empty userobj }">--%>
<%--                <p>Total number money in wallet: </p>--%>
<%--                <p>Total money in current: </p>--%>
<%--                &lt;%&ndash;            href="view_books.jsp?bid=<%=b.getBookId() %>"&ndash;%&gt;--%>
<%--                <a href="/detailMWU?action=df" style="color: white;" class="btn btn-primary btn-sm ml-1">Details </a>--%>
<%--            </c:if>--%>
<%--        </div>--%>
<%--        <div class="col">--%>
<%--            <i class="bx bx-user-voice"></i>--%>

<%--            <img width="250px" height="100px" src="img/unnamed.png">--%>
<%--            <h3> Momo PAY</h3>--%>
<%--            <c:if test="${not empty userobj }">--%>
<%--                <p>Total number money in wallet: </p>--%>
<%--                <p>Total money in current: </p>--%>
<%--                &lt;%&ndash;            href="view_books.jsp?bid=<%=b.getBookId() %>"&ndash;%&gt;--%>
<%--                <a href="/detailMWU?action=df" style="color: white;" class="btn btn-primary btn-sm ml-1">Details </a>--%>
<%--            </c:if>--%>
<%--        </div>--%>
<%--        <div class="col">--%>
<%--            <i class="bx bx-desktop"></i>--%>

<%--            <img width="250px" height="100px" src="img/Logo%20VTC%20Pay%20_ko%20slogan.png">--%>
<%--            <h3> VTC pay</h3>--%>
<%--            <c:if test="${not empty userobj }">--%>
<%--                <p>Total number money in wallet: </p>--%>
<%--                <p>Total money in current: </p>--%>
<%--                &lt;%&ndash;            href="view_books.jsp?bid=<%=b.getBookId() %>"&ndash;%&gt;--%>
<%--                <a href="/detailMWU?action=df" style="color: white;" class="btn btn-primary btn-sm ml-1">Details </a>--%>
<%--            </c:if>--%>
<%--        </div>--%>
<%--        <div class="col">--%>
<%--            <i class="bx bx-camera"></i>--%>

<%--            <img width="250px" height="100px" src="img/tải%20xuống.png">--%>
<%--            <h3> VnMart</h3>--%>
<%--            <c:if test="${not empty userobj }">--%>
<%--                <p>Total number money in wallet: </p>--%>
<%--                <p>Total money in current: </p>--%>
<%--                &lt;%&ndash;            href="view_books.jsp?bid=<%=b.getBookId() %>"&ndash;%&gt;--%>
<%--                <a href="/detailMWU?action=df" style="color: white;" class="btn btn-primary btn-sm ml-1">Details </a>--%>
<%--            </c:if>--%>
<%--        </div>--%>
<%--        <div class="col">--%>
<%--            <i class="bx bx-line-chart"></i>--%>
<%--            <img width="250px" height="100px" src="img/air.png">--%>
<%--            <h3>AirPay</h3>--%>
<%--            <c:if test="${not empty userobj }">--%>
<%--                <p>Total number money in wallet: </p>--%>
<%--                <p>Total money in current: </p>--%>
<%--                &lt;%&ndash;            href="view_books.jsp?bid=<%=b.getBookId() %>"&ndash;%&gt;--%>
<%--                <a href="/detailMWU?action=df" style="color: white;" class="btn btn-primary btn-sm ml-1">Details </a>--%>
<%--            </c:if>--%>
<%--        </div>--%>

    </div>
</section>
<div class="container-fluid text-center text-white p-3 mt-10" style="background-color: green">
    <h5><i class="fa-solid fa-copyright"></i> Designed and Developed By Team</h5>
</div>
</body>
</html>

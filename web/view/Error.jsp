<%-- 
    Document   : Error
    Created on : May 27, 2021, 12:39:28 AM
    Author     : songm
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/quiz.css">
    </head>
    <body>
        <div class="container">
            <div class="content-wrapper">
                <jsp:include page="Navbar.jsp"></jsp:include>
                <div class="content">
                    <div class="title">
                        <h2 class="text-capitalize text-red">error</h2>
                    </div>
                    <div>
                        Access Denied!
                        <br>
                        ${noti}
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

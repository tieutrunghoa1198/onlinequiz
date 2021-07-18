<%-- 
    Document   : Navbar
    Created on : May 21, 2021, 4:26:51 PM
    Author     : songm
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="menu">
            <div class="ml-20">
                <a href="../Quiz/home">Home</a>
                <a href="../Quiz/takequiz">Take Quiz</a>
                <a href="../Quiz/makequiz">Make Quiz</a>
                <a href="../Quiz/manage">Manage Quiz</a>
                <c:if test="${sessionScope.user != null}">
                    <a href="../Quiz/logout">Logout</a>
                </c:if>
            </div>
        </div>
    </body>
</html>

<%-- 
    Document   : Welcome
    Created on : May 21, 2021, 9:19:44 PM
    Author     : songm
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/quiz.css">
        <link rel="stylesheet" href="css/welcome.css">
    </head>
    <body>
        <div class="container">
            <div class="content-wrapper">
                <jsp:include page="Navbar.jsp"></jsp:include>
                <div class="content">
                    <div class="welcome">
                        Welcome <span class="ml-5 text-blue">${user.username}</span>
                    </div>
                    <form action="../Quiz/takequiz" method="post">
                        <div class="main-content">
                            <div>
                                Enter number of questions:
                                <br> 
                                <input type="text" name="numberOfQuiz">
                            </div>
                        </div>
                        <div class="btn-center">
                            <input type="submit" value="Start">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>

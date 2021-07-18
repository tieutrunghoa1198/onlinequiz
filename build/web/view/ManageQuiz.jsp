<%-- 
    Document   : ManageQuiz
    Created on : May 21, 2021, 4:29:44 PM
    Author     : songm
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/managequiz.css">
        <link rel="stylesheet" href="css/quiz.css">
    </head>
    <body>
        <div class="container">
            <div class="content-wrapper">
                <jsp:include page="Navbar.jsp"></jsp:include>
                <div class="content">
                    <div class="welcome">
                        Number of questions: <span class="ml-5 text-blue">${questionList.size()}</span>
                    </div>
                    <div class="row">
                        <div class="content-left">
                            <span class="text-blue">Question</span>
                            <br>
                            <c:forEach var = "quest" items="${questionList}">
                                <p>${quest.question}</p>
                            </c:forEach>
                        </div>
                        <div class="content-right">
                            <span class="text-blue">Date Created</span>
                            <br>
                            <c:forEach var = "quest" items="${questionList}">
                                <p>${quest.getCreatedDateString()}</p>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

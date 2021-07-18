<%-- 
    Document   : Result
    Created on : Jun 7, 2021, 4:16:28 PM
    Author     : songm
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/quiz.css">
        <link rel="stylesheet" href="css/takequiz.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="content-wrapper">
                <jsp:include page="Navbar.jsp"></jsp:include>
                    <div class="content">
                    <div class="mt-50 main-content">
                        <div>
                            Your score
                            <c:choose>
                                <c:when test="${score > 40}">
                                    <span class="ml-5 text-blue">
                                        <fmt:formatNumber type="number" value="${(score/10)}" pattern="#.0"/> 
                                    </span>
                                    <span class="ml-5 text-blue">
                                        (<fmt:formatNumber type="number" value="${score}" pattern="#"/>%)
                                    </span>
                                    -
                                    <span class="ml-5 text-blue">${status}</span>
                                </c:when>
                                <c:otherwise>
                                    <span class="ml-5 text-red">
                                        <fmt:formatNumber type="number" value="${(score/10)}" pattern="#.0"/> 
                                    </span>
                                    <span class="ml-5 text-red">
                                        (<fmt:formatNumber type="number" value="${score}" pattern="#"/>%)
                                    </span>
                                    -
                                    <span class="ml-5 text-red">${status}</span>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                    <div class="mt-10 btn-center">
                        Take another test 
                        <a href="../Quiz/takequiz">
                            <button>Start</button>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

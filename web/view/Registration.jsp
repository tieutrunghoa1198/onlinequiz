<%-- 
    Document   : Registration
    Created on : May 21, 2021, 4:13:52 PM
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
    </head>
    <body>
        <div class="container">
            <div class="content-wrapper">
                <jsp:include page="Navbar.jsp"></jsp:include>
                <div class="content">
                    <div class="title">
                        <h2>Registration Form</h2>
                    </div>
                    <form action="../Quiz/registration" method="post" class="main-content">
                        <div class="lif">
                            <div class="label">
                                User Name: 
                            </div>
                            <div class="data-input">
                                <input type="text" name="username">
                            </div>
                        </div>
                        <div class="lif">
                            <div class="label">
                                Password: 
                            </div>
                            <div class="data-input">
                                <input type="password" name="password">
                            </div>
                        </div>
                        <div class="lif">
                            <div class="label">
                                User Type:
                            </div>
                            <div class="data-input">
                                <select name="role" id="role-selector">
                                    <option value="1">Teacher</option>
                                    <option value="2">Student</option>
                                </select>
                            </div>
                        </div>
                        <div class="lif">
                            <div class="label">
                                Email:
                            </div>
                            <div class="data-input">
                                <input type="text" name="email">
                            </div>
                        </div>
                        <div class="lif">
                            <div class="label">

                            </div>
                            <div class="data-input">
                                <input type="submit" name="register" value="Register">
                            </div>
                        </div>
                        <div class="lif">
                                <div class="label">

                                </div>
                                <div class="data-input ${cssText}">
                                    ${content}
                                </div>
                            </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>

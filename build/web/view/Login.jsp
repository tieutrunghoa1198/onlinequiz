<%-- 
    Document   : Login
    Created on : May 21, 2021, 11:23:36 AM
    Author     : songm
--%>

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
                        <h2 class="text-capitalize">login form</h2>
                    </div>
                    <form action="../Quiz/home" method="post" class="main-content">
                        <div class="lif">
                            <div class="label text-capitalize">
                                user name: 
                            </div>
                            <div class="data-input">
                                <input type="text" name="username">
                            </div>
                        </div>
                        <div class="lif">
                            <div class="label text-capitalize">
                                password: 
                            </div>
                            <div class="data-input">
                                <input type="password" name="password">
                            </div>
                        </div>
                        <div class="lif">
                            <div class="label">

                            </div>
                            <div class="data-input">
                                <input type="submit" name="signin" value="Signin">
                                <a href="../Quiz/registration">Register</a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>

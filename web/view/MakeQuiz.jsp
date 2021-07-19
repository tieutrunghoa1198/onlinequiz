<%-- 
    Document   : MakeQuiz
    Created on : May 21, 2021, 4:30:20 PM
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
        <link rel="stylesheet" href="css/makequiz.css">
    </head>
    <body>
        <div class="container">
            <div class="content-wrapper">
                <jsp:include page="Navbar.jsp"></jsp:include>
                <div class="content">
                    <form name="form" action="../Quiz/makequiz" onsubmit="return validateForm()" method="post">
                        <div class="lif">
                            <div class="label">
                                Question: 
                            </div>
                            <div class="data-input">
                                <textarea class="medium-textarea" id="w3review" name="question" required="true"></textarea>
                            </div>
                        </div>
                        <div class="lif">
                            <div class="label">
                                Option 1:
                            </div>
                            <div class="data-input">
                                <textarea id="ans_1" name="option"></textarea>
                                <input type="hidden" name="textareaid" value="1">
                            </div>
                        </div>

                        <div class="lif">
                            <div class="label">
                                Option 2:
                            </div>
                            <div class="data-input">
                                <textarea id="ans_2" name="option"></textarea>
                                <input type="hidden" name="textareaid" value="2">
                            </div>
                        </div>

                        <div class="lif">
                            <div class="label">
                                Option 3:
                            </div>
                            <div class="data-input">
                                <textarea id="ans_3" name="option"></textarea>
                                <input type="hidden" name="textareaid" value="3">
                            </div>
                        </div>

                        <div class="lif">
                            <div class="label">
                                Option 4:
                            </div>
                            <div class="data-input">
                                <textarea id="ans_4" name="option"></textarea>
                                <input type="hidden" name="textareaid" value="4">
                            </div>
                        </div>

                        <div class="lif">
                            <div class="label">
                                Answer(s): 
                            </div>
                            <div class="data-input">
                                <input type="checkbox" id="option_1" name="answer" value="1" disabled="true">
                                <label for="option_1"> Option 1 </label>
                                <input type="checkbox" id="option_2" name="answer" value="2" disabled="true">
                                <label for="option_2"> Option 2 </label>
                                <input type="checkbox" id="option_3" name="answer" value="3" disabled="true">
                                <label for="option_3"> Option 3 </label>
                                <input type="checkbox" id="option_4" name="answer" value="4" disabled="true">
                                <label for="option_4"> Option 4 </label>
                            </div>
                        </div>

                        <div class="lif">
                            <div class="label">

                            </div>
                            <div class="data-input">
                                <input type="submit" value="Save">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <script src="../Quiz/js/main.js"></script>
        <script>
        </script>
    </body>
</html>

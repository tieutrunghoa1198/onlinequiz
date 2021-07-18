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
                                <textarea class="medium-textarea" id="w3review" name="question"></textarea>
                            </div>
                        </div>
                        <div class="lif">
                            <div class="label">
                                Option 1:
                            </div>
                            <div class="data-input">
                                <textarea id="ans_1" name="option_1"></textarea>
                            </div>
                        </div>

                        <div class="lif">
                            <div class="label">
                                Option 2:
                            </div>
                            <div class="data-input">
                                <textarea id="ans_2" name="option_2"></textarea>
                            </div>
                        </div>

                        <div class="lif">
                            <div class="label">
                                Option 3:
                            </div>
                            <div class="data-input">
                                <textarea id="ans_3" name="option_3"></textarea>
                            </div>
                        </div>

                        <div class="lif">
                            <div class="label">
                                Option 4:
                            </div>
                            <div class="data-input">
                                <textarea id="ans_4" name="option_4"></textarea>
                            </div>
                        </div>

                        <div class="lif">
                            <div class="label">
                                Answer(s): 
                            </div>
                            <div class="data-input">
                                <input type="checkbox" id="option_1" onclick="isChecked(this)" name="answer" value="1">
                                <label for="option_1"> Option 1 </label>
                                <input type="checkbox" id="option_2" onclick="isChecked(this)" name="answer" value="2">
                                <label for="option_2"> Option 2 </label>
                                <input type="checkbox" id="option_3" onclick="isChecked(this)" name="answer" value="3">
                                <label for="option_3"> Option 3 </label>
                                <input type="checkbox" id="option_4" onclick="isChecked(this)" name="answer" value="4">
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
            function validateForm()
            {
                var a = document.forms["form"]["ans_1"].value;
                var b = document.forms["form"]["ans_2"].value;
                var c = document.forms["form"]["ans_3"].value;
                var d = document.forms["form"]["ans_4"].value;

                if (a === null || a === "", b === null || b === "", c === null || c === "", d === null || d === "")
                {
                    alert("Please Fill In All Required Fields");
                    console.log("check validate " + a);
                    return false;
                }
            }
        </script>
    </body>
</html>

<%-- 
    Document   : TakeQuiz
    Created on : May 21, 2021, 4:29:33 PM
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
        <link rel="stylesheet" href="css/takequiz.css">
    </head>
    <body>
        <div class="container">
            <div class="content-wrapper">
                <jsp:include page="Navbar.jsp"></jsp:include>
                    <div class="content">
                        <div class="welcome">
                            <div class="content-left">
                            <c:if test="${user != null}">
                                Welcome 
                                <span class="ml-5 text-blue">${user.username}</span>
                            </c:if>
                        </div>
                        <div class="content-right">
                            <c:if test="${exam != null}">
                                Time Remaining: <p id="time" class="text-red"></p>
                            </c:if>
                        </div>
                    </div>
                    <form action="../Quiz/doquiz" method="post">
                        <div class="main-content">
                            <c:set var="quest" value="${exam.questionList.get(exam.currentIndex)}"/>
                            <p>${quest.question}</p>
                            <br>
                            <div class="row">
                                <input type="checkbox" id="option_1" onclick="isChecked(this)" name="answer_1" value="1">    
                                <label for="option_1"> ${quest.ans_1} </label>
                            </div>

                            <div class="row">
                                <input type="checkbox" id="option_2" onclick="isChecked(this)" name="answer_2" value="2">
                                <label for="option_2"> ${quest.ans_2} </label>
                            </div>

                            <div class="row">
                                <input type="checkbox" id="option_3" onclick="isChecked(this)" name="answer_3" value="3">
                                <label for="option_3"> ${quest.ans_3} </label>
                            </div>

                            <div class="row">
                                <input type="checkbox" id="option_4" onclick="isChecked(this)" name="answer_4" value="4">    
                                <label for="option_4"> ${quest.ans_4} </label>
                            </div>
                        </div>
                            <input class="" type="submit" name="cmd" value="Submit">
                            <input class="" type="submit" name="cmd" value="Next">
                            <input class="" type="submit" name="cmd" value="Prev">
                    </form>
                </div>
            </div>
        </div>
        <script>
            //get time for exam base on number of questions
            var quizTime = '${exam.getTimeForExam()}';
            function timeCount()
            {
                //reduce 1 second each time when function is called
                quizTime = quizTime - 1000;
                var minutes = Math.floor((quizTime % (1000 * 60 * 60)) / (1000 * 60));
                var seconds = Math.floor((quizTime % (1000 * 60)) / 1000);
                document.getElementById("time").innerHTML = minutes.toString().padStart(2, "0") + ":" + seconds.toString().padStart(2, "0");

                //redirect to result page if time for exam is expired
                if (quizTime < 0) {
                    clearInterval(x);
                    document.getElementById("time").innerHTML = "EXPIRED";
                    window.location.href = window.location.origin + "/Quiz/result"
                }
            }

            var x = setInterval(timeCount, 1000);


        </script>
        <script src="../Quiz/js/main.js"></script>
    </body>
</html>

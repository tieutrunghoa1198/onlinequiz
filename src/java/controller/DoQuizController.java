/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.QuestionDAO;
import entity.Answer;
import entity.Exam;
import entity.Question;
import entity.Quiz;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author songm
 */
public class DoQuizController extends BaseAuthen
{

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //get exam in for from session
        Exam e = getExamFromSession(request);
        long currentTime = System.currentTimeMillis();
        if (e.getEndTime() == 0)
        {
            e.setEndTime(currentTime + e.getTimeForExam());
        } else
        {
            e.setTimeForExam(e.getEndTime() - System.currentTimeMillis());
        }
        //return to jsp file
        request.setAttribute("exam", e);
        request.getRequestDispatcher("view/TakeQuiz.jsp").forward(request, response);
    }

    private void mappingAnswers(List<Answer> listAns, String[] answers)
    {
        HashMap<Integer, Boolean> answerMap = new HashMap<>();
        listAns.forEach(element ->
        {
            boolean selected = false;
            for (String answer : answers)
            {

                Integer aid = element.getAid();
                if (answer.equals(aid.toString()))
                {
                    answerMap.put(element.getAid(), Boolean.TRUE);
                    selected = true;
                    break;
                }

            }

            if (!selected)
            {
                answerMap.put(element.getAid(), Boolean.FALSE);
            }
        });

        answerMap.entrySet().forEach(element ->
        {
            listAns.stream().filter((a) -> (a.getAid() == element.getKey())).forEachOrdered((a) ->
            {
                a.setSelected(element.getValue());
            });
        });
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        String[] answers = request.getParameterValues("answer");
        String cmd = request.getParameter("cmd");

        //get exam info
        Exam e = getExamFromSession(request);
        HttpSession session = request.getSession(true);
        //take out the current question
        List<Quiz> examQuests = e.getQuestionList();
        Quiz currentQuestion = examQuests.get(e.getCurrentIndex());

        //get list answers
        List<Answer> listAns = currentQuestion.getListAnswers();
        try
        {
            mappingAnswers(listAns, answers);
        } catch (Exception ex)
        {
            System.out.println(ex);
            listAns.forEach(element ->
            {
                element.setSelected(false);
            });
        }

        switch (cmd)
        {
            case "Next":
                e.setCurrentIndex(e.getCurrentIndex() + 1);

                //set attribute for exam in session 
                e.setTimeForExam(e.getEndTime() - System.currentTimeMillis());
                session.setAttribute("exam", e);
                //then keep doing quiz
                response.sendRedirect("doquiz");
                break;

            case "Prev":
                e.setCurrentIndex(e.getCurrentIndex() - 1);
                //set attribute for exam in session 
                e.setTimeForExam(e.getEndTime() - System.currentTimeMillis());
                session.setAttribute("exam", e);
                //then keep doing quiz
                response.sendRedirect("doquiz");
                break;

            case "Submit":
                e.setFinish(true);
                session.setAttribute("exam", e);
                //then calculate result
                response.sendRedirect("result");
                break;
        }

    }

    public Exam getExamFromSession(HttpServletRequest request)
    {
        HttpSession session = request.getSession(true);
        Exam e = (Exam) session.getAttribute("exam");
        return e;
    }

}

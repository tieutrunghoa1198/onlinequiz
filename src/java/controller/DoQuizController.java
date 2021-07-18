/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.QuestionDAO;
import entity.Exam;
import entity.Question;
import java.io.IOException;
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

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //get info from examiner include: answer 
        //get the full 4 answers 
        
        /*
            get full 4 answers 
            write a function to check all the answers in a question
        */
        
        String answer = request.getParameter("answer") == null ? "" : request.getParameter("answer");
        String cmd = request.getParameter("cmd");

        //get exam info
        Exam e = getExamFromSession(request);
        HttpSession session = request.getSession(true);
        //take out the current question
        List<Question> examQuests = e.getQuestionList();
        Question currentQuestion = examQuests.get(e.getCurrentIndex());
        
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

        //check the current question is correct or not
//        if (currentQuestion.getCorrectAns().equals(answer))
//        {
//            //set score for the current question
//            e.setScore(e.getScore() + 1);
//        }
//
//        //return the next question for examiner
//        e.setCurrentIndex(e.getCurrentIndex() + 1);
//
//        //checking quest bank is empty or not
//        if (e.getCurrentIndex() == examQuests.size())
//        {
//            HttpSession session = request.getSession(true);
//            session.setAttribute("exam", e);
//            //then calculate result
//            response.sendRedirect("result");
//        } else
//        {
//            //set attribute for exam in session 
//            HttpSession session = request.getSession(true);
//            e.setTimeForExam(e.getEndTime() - System.currentTimeMillis());
//            session.setAttribute("exam", e);
//            //then keep doing quiz
//            response.sendRedirect("doquiz");
//        }
    }

    public Exam getExamFromSession(HttpServletRequest request)
    {
        HttpSession session = request.getSession(true);
        Exam e = (Exam) session.getAttribute("exam");
        return e;
    }

}

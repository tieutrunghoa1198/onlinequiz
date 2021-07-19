/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.QuestionDAO;
import entity.Exam;
import entity.Question;
import entity.Quiz;
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
public class TakeQuizController extends BaseAuthen
{

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //keeping it up from here 
        request.getRequestDispatcher("view/Welcome.jsp").forward(request, response);
    }

    private boolean validateInput(String numberOfQuest, int quizBank)
    {
        if (numberOfQuest == null)
        {
            return false;
        }

        try
        {
            int num = Integer.parseInt(numberOfQuest);
            if (num < 0 || num > quizBank)
            {
                return false;
            }
        } catch (NumberFormatException e)
        {
            return false;
        }
        return true;
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //get the raw data
        String numberOfquizRaw = request.getParameter("numberOfQuiz");
        
        QuestionDAO db = new QuestionDAO();
        int quizBank = db.getAllQuests();
        if (validateInput(numberOfquizRaw, quizBank))
        {
            int numberOfQuiz = Integer.parseInt(numberOfquizRaw);
            System.out.println("Number of quiz: " + numberOfQuiz);

            //create connection to database
            
            List<Quiz> qList = db.getListQuiz(numberOfQuiz);
            long timeForExam = numberOfQuiz * 60 * 1000;
            long currentTime = System.currentTimeMillis();
            //create exam for taker
            Exam e = new Exam();
            e.setQuestionList(qList);
            e.setTimeForExam(timeForExam);
            e.setEndTime(currentTime + timeForExam);
            e.setCurrentIndex(0);

            HttpSession session = request.getSession(true);
            session.setAttribute("exam", e);
            response.sendRedirect("doquiz");
        } else
        {
            request.setAttribute("noti", "Enter a valid range of question");
            request.getRequestDispatcher("view/Error.jsp").forward(request, response);
        }

    }

}

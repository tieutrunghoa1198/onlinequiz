/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.QuestionDAO;
import entity.Answer;
import entity.Exam;
import entity.Quiz;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author songm
 */
public class ResultController extends HttpServlet
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession(true);
        Exam e = (Exam) session.getAttribute("exam");
        QuestionDAO db = new QuestionDAO();
        double score = 0.0;

        List<Quiz> listQuiz = e.getQuestionList();
        List<Answer> correctAnswers = new ArrayList<>();

        listQuiz.forEach((Quiz element) ->
        {
            int qid = element.getQid();
            correctAnswers.addAll(db.getCorrectAnswerByQuizID(qid));
        });

        HashMap<Integer, Boolean> map = new HashMap<>();
        correctAnswers.forEach(answer ->
        {
            map.put(answer.getAid(), answer.isSelected());
        });

        for (int index = 0; index < listQuiz.size(); index++)
        {

            Quiz element = listQuiz.get(index);
            List<Answer> answersOfCurrentQuest = element.getListAnswers();
            double correctAnswered = 0.0;
            double totalCorrectAns = db.getTotalCorrectAnsByQuizID(element.getQid());

            for (int i = 0; i < answersOfCurrentQuest.size(); i++)
            {
                Answer answer = answersOfCurrentQuest.get(i);
                if (map.containsKey(answer.getAid()) && map.get(answer.getAid()) == answer.isSelected() && map.get(answer.getAid()) == true)
                {
                    correctAnswered += 1;
                }

            }

            if (totalCorrectAns == 0)
            {
                element.setScore(0);
            } else
            {
                element.setScore(correctAnswered / totalCorrectAns);
            }

            score += element.getScore();
        }
        double finalScore = (score / listQuiz.size()) * 100;
        if (finalScore < 40.0)
        {
            request.setAttribute("status", "Not Pass");
        } else
        {
            request.setAttribute("status", "Pass");
        }
        System.out.println(finalScore + " final score");
        session.removeAttribute("exam");
        request.getRequestDispatcher("view/Result.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo()
    {
        return "Short description";
    }

}

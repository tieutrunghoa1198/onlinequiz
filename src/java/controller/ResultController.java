/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Exam;
import java.io.IOException;
import java.io.PrintWriter;
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
        
//        double correctQuest = e.getScore();
//        double totalQuest = e.getQuestionList().size();
//        double score = correctQuest / totalQuest * 100;
//
//        request.setAttribute("score", score);
//        if (score < 40)
//        {
//            request.setAttribute("status", "Not Pass");
//        } else
//        {
//            request.setAttribute("status", "Pass");
//        }
        
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

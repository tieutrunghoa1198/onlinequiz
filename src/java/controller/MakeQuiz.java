/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.QuestionDAO;
import entity.Question;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author songm
 */
public class MakeQuiz extends BaseAuthen
{

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher("view/MakeQuiz.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
//        String question = request.getParameter("question");
//        String option_1 = request.getParameter("option_1");
//        String option_2 = request.getParameter("option_2");
//        String option_3 = request.getParameter("option_3");
//        String option_4 = request.getParameter("option_4");
//        String correctOption = request.getParameter("answer");
//
//        HttpSession session = request.getSession(true);
//        User u = (User) session.getAttribute("user");
//
//        Date createdTime = new Date(System.currentTimeMillis());
//
//        QuestionDAO db = new QuestionDAO();
//        int affectedRow = db.createQuest(
//                new Question(
//                        question,
//                        option_1,
//                        option_2,
//                        option_3,
//                        option_4,
//                        correctOption,
//                        createdTime,
//                        u
//                )
//        );
        
        //get all the needed datas from client side 
        String question = request.getParameter("question");
        String option_1 = request.getParameter("option_1");
        String option_2 = request.getParameter("option_2");
        String option_3 = request.getParameter("option_3");
        String option_4 = request.getParameter("option_4");        
        
        
        if (false)
        {
            response.sendRedirect("manage");
        } else
        {
            request.setAttribute("noti", "Can't create question.");
            request.getRequestDispatcher("view/Error.jsp").forward(request, response);
        }

    }

}

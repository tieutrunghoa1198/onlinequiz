/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.QuestionDAO;
import entity.Answer;
import entity.Question;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        boolean insertFinish = false;
        //get all the needed datas from client side 
        String question = request.getParameter("question");
        String[] options = request.getParameterValues("option");
        String[] answers = request.getParameterValues("answer");
        String[] textareaid = request.getParameterValues("textareaid");

        //get user from session
        HttpSession session = request.getSession(true);
        User u = (User) session.getAttribute("user");
        QuestionDAO db = new QuestionDAO();

        db.createQuiz(question, u.getId());
        int insertedRow = db.getInsertedRow();
        try
        {
            //algorithm for make quiz
            HashMap<String, Boolean> answerMap = new HashMap<>();
            for (int i = 0; i < 4; i++)
            {
                //filter for check empty
                if (options[i].isEmpty() || options[i] == null)
                {
                    //if option is empty then ignore it
                } else
                {
                    //flag to check if the current answer is inserted or not
                    boolean inserted = false;
                    for (String answer : answers)
                    {
                        //if it apprears at least 1 correct answer 
                        if (answer.equals(textareaid[i]))
                        {
                            //then put it into the map 
                            answerMap.put(textareaid[i], true);
                            inserted = true;
                            //then break the loop
                            break;
                        }
                    }

                    //if the answer is not correct 
                    if (inserted == false)
                    {
                        //then put it into map with false property
                        answerMap.put(textareaid[i], false);
                    }
                }
            }

            answerMap.entrySet().forEach((me) ->
            {
                // the original id is: 1,2,3,4 
                // what we need is:    0,1,2,3
                int optionid = Integer.parseInt(me.getKey());
                Answer a = new Answer(optionid, options[optionid - 1], me.getValue());
                db.insertAnswer(insertedRow, a);
            });
            insertFinish = true;

        } catch (Exception e)
        {
            System.out.println(e);
        }

        if (insertFinish)
        {
            response.sendRedirect("manage");
        } else
        {
            request.setAttribute("noti", "Can't create question.");
            request.getRequestDispatcher("view/Error.jsp").forward(request, response);
        }

    }

}

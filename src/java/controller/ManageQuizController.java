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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author songm
 */
public class ManageQuizController extends BaseAuthen
{

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession(true);
        User u = (User) session.getAttribute("user");
        QuestionDAO db = new QuestionDAO();
        List<Question> qList = db.getQuestionByUser(u);
        
        request.setAttribute("questionList", qList);
        request.getRequestDispatcher("view/ManageQuiz.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.getWriter().print("post");
    }

}

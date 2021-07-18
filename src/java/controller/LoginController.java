/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDAO;
import entity.User;
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
public class LoginController extends HttpServlet
{

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession(true);
        User u = (User) session.getAttribute("user");

        if (u != null)
        {
            request.getRequestDispatcher("/view/Welcome.jsp").forward(request, response);
        } else
        {
            request.getRequestDispatcher("/view/Login.jsp").forward(request, response);
        }
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
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDAO db = new UserDAO();
        User u = db.getUser(username, password);
        if (u == null)
        {
            response.getWriter().print("catn login");
        } else
        {
            HttpSession session = request.getSession(true);
            session.setAttribute("user", u);
            response.sendRedirect("takequiz");
        }
    }

    @Override
    public String getServletInfo()
    {
        return "Short description";
    }

}

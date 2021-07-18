/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.*;
import dao.*;

/**
 *
 * @author songm
 */
public class RegistrationController extends HttpServlet
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            request.getRequestDispatcher("view/Registration.jsp").forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try
        {
            //getting data from browser
            String username = request.getParameter("username");
            String pass = request.getParameter("password");
            int role = Integer.parseInt(request.getParameter("role"));
            String email = request.getParameter("email");

            //create entity
            User user = new User(username, pass, email);
            UserDAO db = new UserDAO();
            int result = db.register(user);
            if (result != -1)
            {
                db.addRole(role, user.getUsername());
                request.setAttribute("content", "Create Successful!");
                request.setAttribute("cssText", "text-blue");
                request.getRequestDispatcher("view/Registration.jsp").forward(request, response);
            } else
            {
                request.setAttribute("content", "Can't Create Account");
                request.setAttribute("cssText", "text-red");
                //continue here
                //continue with login and get all feature for user
                //then do make quiz function
                //remember to write comment
                request.getRequestDispatcher("view/Registration.jsp").forward(request, response);
            };
        } catch (NumberFormatException e)
        {
            response.getWriter().print("wrong data fomat");
            System.out.println(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processPost(request, response);
    }

    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}

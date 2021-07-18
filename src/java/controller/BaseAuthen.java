/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Exam;
import entity.Feature;
import entity.Role;
import entity.User;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public abstract class BaseAuthen extends HttpServlet
{

    private boolean isAccessGranted(HttpServletRequest request)
    {
        HttpSession session = request.getSession(true);
        User u = (User) session.getAttribute("user");
        if (u == null)
        {
            return false;
        } else
        {
            String url = request.getServletPath();
            for (Feature f : u.getFeature())
            {
                if (f.getPath().equals(url))
                {
                    return true;
                }
            }
            return false;
        }
    }

    protected abstract void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    protected abstract void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        if (isAccessGranted(request))
        {
            processGet(request, response);
        } else
        {
            System.out.println("oke 3");
            request.getRequestDispatcher("view/Error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        if (isAccessGranted(request))
        {
            processPost(request, response);
        } else
        {
            System.out.println("oke post");
            request.getRequestDispatcher("view/Error.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo()
    {
        return "Short description";
    }

}

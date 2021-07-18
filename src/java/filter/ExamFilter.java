/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author songm
 */
public class ExamFilter implements Filter
{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession(true);
        entity.Exam e = (entity.Exam) session.getAttribute("exam");
        long currentTime = System.currentTimeMillis();
        
        //if the exam is created
        if (e != null)
        {
            //and the exam is not finish
            if (!e.isFinish())
            {
                //and the current time is overdue
                if (currentTime > e.getEndTime())
                {
                    chain.doFilter(request, response);
                } else
                {
                    //keep doing the test 
                    res.sendRedirect("doquiz");
                    System.out.println("filter for exam");
                }
            } else
            {
                System.out.println("filter for exam get through");
                chain.doFilter(request, response);
            }
        } else
        {
            System.out.println("filter for exam get through");
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy()
    {

    }

}

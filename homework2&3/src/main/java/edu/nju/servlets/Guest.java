package edu.nju.servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by kylin on 17/12/2016.
 * All rights reserved.
 */
@WebServlet("/guest")
public class Guest extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext Context = getServletContext();
        int guest = (int) Context.getAttribute("guest");

        PrintWriter writer = response.getWriter();
        writer.println("<html><body>");
        writer.println("<p> 欢迎游客! 您是第" + guest + " 位在线的游客</p>");
        writer.println("</body></html>");

    }

}

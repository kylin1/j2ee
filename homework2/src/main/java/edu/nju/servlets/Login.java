package edu.nju.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = "";
        //如果当前Session没有就为null
        HttpSession session = request.getSession(false);

        //长期记住用户信息,存储在用户的硬盘上,new一个cookie放到response中,浏览器退出时候,cookie被删除,不会进入硬盘
        //如果存储cookie到硬盘需要setMaxAge
        Cookie cookie = null;
        //客户端浏览器发送的cookie被包含在request中
        Cookie[] cookies = request.getCookies();

        Integer ival = 1;

        //遍历cookie获取已有的登录信息
        if (null != cookies) {
            // Look through all the cookies and see if the
            // cookie with the login info is there.
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                // found user name
                if (cookie.getName().equals("LoginCookie")) {
                    login = cookie.getValue();
                    break;
                }
            }
        }

        // Logout action removes session, but the cookie remains
        // 退出的时候消除session
        if (null != request.getParameter("Logout")) {
            if (null != session) {
                session.invalidate();
                session = null;
            }
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        //登录之后界面跳转到show
        out.println(
                "<form method='POST' action='"
                        + response.encodeURL(request.getContextPath() + "/show")
                        + "'>");
        out.println(
                //login也就是用户名的预填充
                "login: <input type='text' name='login' value='" + login + "'>");
        out.println(
                "password: <input type='password' name='password' value=''>");
        out.println("<input type='submit' name='Submit' value='Submit'>");
        out.println("</form></body></html>");

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

}

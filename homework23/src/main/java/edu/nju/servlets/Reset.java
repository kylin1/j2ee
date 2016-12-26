package edu.nju.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 清除浏览器存储的session以便测试
 * <p>
 * Created by kylin on 10/12/2016.
 * All rights reserved.
 */
@WebServlet("/reset")
public class Reset extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (null != session) {
            System.out.println("session is not null, resetting");
            session.invalidate();
            session = null;
        }else {
            System.out.println("has already destroyed session");
        }
    }
}

package edu.nju.servlets;

import edu.nju.dao.SelectionDao;
import edu.nju.dao.StudentDao;
import edu.nju.dao.impl.SelectionDaoImpl;
import edu.nju.dao.impl.StudentDaoImpl;
import edu.nju.model.Selection;
import edu.nju.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by zhouxiaofan on 2016/12/8.
 */

@WebServlet("/show")
public class ShowServlet extends HttpServlet {

    private StudentDao studentDao = new StudentDaoImpl();
    private SelectionDao selectionDao = new SelectionDaoImpl();

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        processRequest(req, res);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //没有session不会创建
        HttpSession session = request.getSession(false);
        System.out.println("in request login = " + request.getParameter("login") +
                " ,pass = " + request.getParameter("password"));

        //使用cookie记录用户ID进行预填充
        Cookie cookie = null;
        boolean cookieFound = false;
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            // Look through all the cookies and see if the
            // cookie with the login info is there.
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                if (cookie.getName().equals("LoginCookie")) {
                    cookieFound = true;
                    break;
                }
            }
        }

        // 根据session跟踪登录的状态,强迫用户登录
        if (session == null) {

            //如果从/Login输入,请求里面有login这个参数,isLoginAction是true
            String loginValue = request.getParameter("login");
            boolean isLoginAction = null != loginValue;

            System.out.println("loginValue = " + loginValue + " session null");
            if (isLoginAction) {
                System.out.println("isLoginAction");
                // 已经存在cookie,update the value only,
                if (cookieFound) {
                    System.out.println("cookieFound");
                    // if changed
                    if (!loginValue.equals(cookie.getValue())) {
                        System.out.println("cookie changed");
                        cookie.setValue(loginValue);
                        response.addCookie(cookie);
                    }

                    // If the cookie does not exist, create it and set value
                } else {
                    cookie = new Cookie("LoginCookie", loginValue);
                    cookie.setMaxAge(Integer.MAX_VALUE);
                    System.out.println("Add cookie");
                    response.addCookie(cookie);
                }

                // create a session to show that we are logged in
                session = request.getSession(true);
                session.setAttribute("login", loginValue);
                System.out.println("session login changed");

                //request添加login参数
                request.setAttribute("login", loginValue);

                //展示信息
                this.displayPage(request,response);

                //请求里面没有login这个参数,说明访问的直接是show,转到登录状态
            } else {
                System.out.println("loginValue = " + loginValue + " session null, redirect to login page");
                // Display the login page. If the cookie exists, set login
                response.sendRedirect(request.getContextPath() + "/Login");
            }

            // session is not null, 用户已经登录
        } else {
            String loginValue = (String) session.getAttribute("login");
            System.out.println("loginValue = " + loginValue + " session is not null");

            //将session里面存储的用户名称放入request
            request.setAttribute("login", loginValue);

            //展示信息
            this.displayPage(request,response);
        }
    }

    /**
     * 展示信息界面
     *
     * @param request
     * @param response
     * @throws IOException
     */
    private void displayPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.displayStudentInfo(request, response);
        this.displayLogoutPage(request, response);
    }

    /**
     * 打印退出按钮
     *
     * @param req
     * @param res
     * @throws IOException
     */
    private void displayLogoutPage(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter writer = res.getWriter();
        // Logout
        writer.println("<form method='GET' action='" + res.encodeURL(req.getContextPath() + "/Login") + "'>");
        writer.println("</p>");
        //退出的表单
        writer.println("<input type='submit' name='Logout' value='Logout'>");
        writer.println("</form>");
        writer.println("</body></html>");
    }

    /**
     * 业务逻辑:根据学生选课与参加考试的情况显示不同的界面
     *
     * @param request
     * @param response
     * @throws IOException
     */
    private void displayStudentInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取参数
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        System.out.println("in display login=" + login + ", pass=" + password);

        //登录并获取学生信息
        Student student = studentDao.getStudent(login);

        PrintWriter writer = response.getWriter();
        writer.println("<html><body>");

        //未知的学生(账号不存在),错误界面
        if (student == null) {
            writer.println("<p>no such student whose name is " + login + "</p>");
            return;
        }

        //验证密码,密码错误
        String dbPassword = student.getPassword();
        if (!password.equals(dbPassword)) {
            writer.println("<p>wrong password of student " + login + " </p>");
            return;
        }

        //学生存在且密码正确
        int id = student.getId();

        //根据学生是否参加所有测验返回不同界面
        boolean isNormal = this.isAllExamTaken(id);
        //标准界面
        if (isNormal) {
            writer.println("<h1>welcome : "+ login+"</h1>");
            writer.println("<p>standard information</p>");
            //警告界面
        } else {
            writer.println("<p>warning : student does not take all exams!</p>");
        }
    }

    /**
     * 判断一个学生是否参加了所有的测验
     *
     * @param studentId 学生ID
     * @return true(正常结果) false(有未参加的测验)
     */
    private boolean isAllExamTaken(int studentId) {
        //得到学生的选课与测验情况
        List<Selection> selections = selectionDao.getSelectionOfStudent(studentId);

        for (Selection selection : selections) {
            //如果有没有参加的,则返回false
            if (selection.getExamTaken() == 0) {
                return false;
            }
        }
        //此学生参加了所有的测验
        return true;
    }
}

package edu.nju.onlinestock.servlets;

import edu.nju.onlinestock.action.ClassInfoBean;
import edu.nju.onlinestock.action.ClassListBean;
import edu.nju.onlinestock.factory.EJBFactory;
import edu.nju.onlinestock.model.Course;
import edu.nju.onlinestock.model.Selection;
import edu.nju.onlinestock.service.CourseService;
import edu.nju.onlinestock.service.SelectionService;
import edu.nju.onlinestock.service.StudentService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhouxiaofan on 2016/12/8.
 */

@WebServlet("/show")
public class ShowServlet extends HttpServlet {

    private StudentService studentService;

    private SelectionService selectionService;

    private CourseService courseService;

    private static final long serialVersionUID = 1L;

    public void init() throws ServletException {
        this.studentService = (StudentService) EJBFactory
    			.getEJB("ejb:/onlineStockJPAEJB/StudentServiceBean!edu.nju.onlinestock.service.StudentService");
    	
        this.selectionService = (SelectionService) EJBFactory
    			.getEJB("ejb:/onlineStockJPAEJB/SelectionServiceBean!edu.nju.onlinestock.service.SelectionService");
    	
        this.courseService = (CourseService) EJBFactory
    			.getEJB("ejb:/onlineStockJPAEJB/CourseServiceBean!edu.nju.onlinestock.service.CourseService");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        processRequest(req, res);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
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

        //没有session不会创建
        HttpSession session = request.getSession(false);
        System.out.println("in request login = " + request.getParameter("login") +
                " ,pass = " + request.getParameter("password"));

        // 根据session跟踪登录的状态,强迫用户登录
        if (session == null) {

            //如果从/Login输入,请求里面有login这个参数,isLoginAction是true
            String loginValue = request.getParameter("login");
            boolean isLoginAction = null != loginValue;

            System.out.println("loginValue = " + loginValue + " session null");
            // User is logging in
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
                this.displayPage(request, response,true);

                //请求里面没有login这个参数,说明访问的直接是show,强迫用户转到登录状态
            } else {
                System.out.println("loginValue = " + loginValue + " session null, redirect to login page");
                // Display the login page. If the cookie exists, set login
                response.sendRedirect(request.getContextPath() + "/Login");
            }

            // session is not null, 用户已经登录, 刷新show界面
        } else {
            String loginValue = (String) session.getAttribute("login");
            System.out.println("loginValue = " + loginValue + " session is not null");

            //将session里面存储的用户名称放入request
            request.setAttribute("login", loginValue);

            //展示信息
            this.displayPage(request, response,false);
        }
    }

    /**
     * 展示信息界面
     *
     * @param request
     * @param response
     * @throws IOException
     */
    private void displayPage(HttpServletRequest request, HttpServletResponse response, boolean increase) throws IOException {
        //获取参数
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        System.out.println("in display login=" + login + ", pass=" + password);

        ServletContext context = getServletContext();

        try {

            //未知的学生(账号不存在),错误界面
            if (!studentService.studentExists(login)) {
                System.out.println("账号不存在");
                request.setAttribute("message", "账号不存在");
                context.getRequestDispatcher("/course/warning.jsp").forward(request, response);
            }

            //只有用户名密码正确登录才增加计数器
            if (studentService.login(login, password)) {
                System.out.println("log in correct");
                if(increase){
                    this.increaseCounter();
                }

                this.displayStudentInfo(request, response);
            }else{
                System.out.println("密码错误");
                request.setAttribute("message", "密码错误");
                context.getRequestDispatcher("/course/warning.jsp").forward(request, response);
            }

        } catch (ServletException e) {
            e.printStackTrace();
        }
    }


    /**
     * 业务逻辑:根据学生选课与参加考试的情况显示不同的界面
     *
     * @param request
     * @param response
     * @throws IOException
     */
    private boolean displayStudentInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletContext context = getServletContext();

        //根据学生是否参加所有测验返回不同界面
        String login = request.getParameter("login");
        boolean isNormal = selectionService.isAllExamTaken(login);

        try {
            //标准界面
            if (isNormal) {
                List<ClassInfoBean> result = new ArrayList<>();
                List<Selection> selections = selectionService.getSelectionOfStudent(login);
                for (Selection one : selections) {
                    int courseId = one.getCourseId();

                    //获取一个课程信息
                    Course targetCourse = courseService.getCourse(courseId);
                    String courseName = targetCourse.getName();
                    int score = one.getScore();

                    //加入list
                    ClassInfoBean classInfoBean = new ClassInfoBean(courseId, courseName, score);
                    result.add(classInfoBean);
                }

                //放入session以便界面获取
                ClassListBean classList = new ClassListBean();
                classList.setClassList(result);
                request.setAttribute("classList", classList);

                //界面跳转
                context.getRequestDispatcher("/course/normal.jsp").forward(request, response);

                //警告界面
            } else {
                request.setAttribute("message", "警告:还有没有参加的考试");
                context.getRequestDispatcher("/course/warning.jsp").forward(request, response);
            }
        } catch (ServletException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                    "This is a ServletException in show servelt.");
        }
        return true;
    }

    /**
     * 增加已经登录的人数和总人数
     */
    private void increaseCounter() {
        ServletContext Context = getServletContext();
        int total = (int) Context.getAttribute("total");
        int logged = (int) Context.getAttribute("logged");
        System.out.println("show servlet total = " + total);
        Context.setAttribute("logged", ++logged);
        Context.setAttribute("total", ++total);
    }

}

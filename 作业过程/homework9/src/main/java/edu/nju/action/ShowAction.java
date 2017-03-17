package edu.nju.action;

import edu.nju.action.business.ClassInfoBean;
import edu.nju.action.business.ClassListBean;
import edu.nju.model.Course;
import edu.nju.model.Selection;
import edu.nju.service.ICourseService;
import edu.nju.service.ISelectionService;
import edu.nju.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.apache.struts2.ServletActionContext.getServletContext;

/**
 * Created by kylin on 28/02/2017.
 * All rights reserved.
 */
public class ShowAction extends BaseAction {

    @Autowired
    private IStudentService studentService;

    @Autowired
    private ISelectionService selectionService;

    @Autowired
    private ICourseService courseService;

    public String execute() throws IOException {

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
                return this.displayPage(request, response, true);

                //请求里面没有login这个参数,说明访问的直接是show,强迫用户转到登录状态
            } else {
                System.out.println("loginValue = " + loginValue + " session null, redirect to login page");
                // Display the login page. If the cookie exists, set login
                return "login";
            }

            // session is not null, 用户已经登录, 刷新show界面
        } else {
            String loginValue = (String) session.getAttribute("login");
            System.out.println("loginValue = " + loginValue + " session is not null");

            //将session里面存储的用户名称放入request
            request.setAttribute("login", loginValue);

            //展示信息
            return this.displayPage(request, response, false);
        }

    }


    /**
     * 展示信息界面
     *
     * @param request
     * @param response
     * @throws IOException
     */
    private String displayPage(HttpServletRequest request, HttpServletResponse response,
                               boolean increase) throws IOException {
        System.out.println("displayPage increase" + increase);
        //获取参数
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        System.out.println("in display login=" + login + ", pass=" + password);

        //未知的学生(账号不存在),错误界面
        if (!studentService.studentExists(login)) {
            System.out.println("账号不存在");
            request.setAttribute("message", "账号不存在");
            return "warning";
        }

        //只有用户名密码正确登录才增加计数器
        if (studentService.login(login, password)) {
            System.out.println("login correct increase = " + increase);

            if (increase) {
                this.increaseCounter();
            }

            return this.displayStudentInfo(request, response);
        } else {
            System.out.println("密码错误");
            request.setAttribute("message", "密码错误");
            return "warning";
        }
    }


    /**
     * 业务逻辑:根据学生选课与参加考试的情况显示不同的界面
     *
     * @param request
     * @param response
     * @throws IOException
     */
    private String displayStudentInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletContext context = getServletContext();

        //根据学生是否参加所有测验返回不同界面
        String login = request.getParameter("login");
        boolean isNormal = selectionService.isAllExamTaken(login);

        System.out.println("in displayStudentInfo");

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
            System.out.println("to normal jsp");
            return "normal";

            //警告界面
        } else {
            System.out.println("to warning jsp");
            request.setAttribute("message", "警告:还有没有参加的考试");
            return "warning";

        }
    }

    /**
     * 增加已经登录的人数和总人数
     */

    private void increaseCounter() {
        System.out.println("show servlet increaseCounter");
        ServletContext Context = getServletContext();
        int total = (int) Context.getAttribute("total");
        int logged = (int) Context.getAttribute("logged");
        System.out.println("show servlet total = " + total);
        Context.setAttribute("logged", ++logged);
        Context.setAttribute("total", ++total);
    }

}

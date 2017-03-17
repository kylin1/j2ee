package edu.nju.action;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import static org.apache.struts2.ServletActionContext.getServletContext;

/**
 * Created by kylin on 28/02/2017.
 * All rights reserved.
 */
public class LoginAction extends BaseAction{

    public String execute(){
        // 5 in login
        System.out.println("in login servlet");

        String login = "";
        //如果当前Session没有就为null
        HttpSession session = request.getSession(false);

        // ServletContext
        ServletContext Context = getServletContext();
        int total = (int) Context.getAttribute("total");
        int logged = (int) Context.getAttribute("logged");
        int guest = (int) Context.getAttribute("guest");

        // 不是退出,而且不是返回过来的,游客人数加1
        boolean isLogout = request.getParameter("Logout") != null;
        boolean isReturn = request.getParameter("return") != null;

        if (!isLogout && !isReturn) {
            System.out.println("guest++\n");
            Context.setAttribute("guest", ++guest);
            Context.setAttribute("total", ++total);
        }

        //用户退出,才能减去登录人数(防止用户重复刷新登出界面)
        if(isLogout){
            Context.setAttribute("logged", --logged);
            Context.setAttribute("total", --total);
            //remove session
            if (null != session) {
                session.invalidate();
                session = null;
            }
        }

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
        return LOGIN;
    }

}

package edu.nju.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 * Created by kylin on 26/12/2016.
 * All rights reserved.
 * <p>
 * doStartTag()→doInitBody()→setBodyContent()→doAfterBody()→doEndTag()
 */
public class CheckLoginHandler extends BodyTagSupport {

    public int doStartTag() throws JspException {
        //如果返回EVAL_BODY_INCLUDE则继续执行；
        //如果返回SKIP_BODY则接下来的doInitBody(),setBodyContent(), doAfterBody()三个方法不会被执行，
        return EVAL_BODY_BUFFERED;
    }

    public int doAfterBody() throws JspException {
        //继续置信标签处理的下一步
        return SKIP_BODY;
    }

    /**
     * 遇到标签结束时使用
     *
     * @return
     * @throws JspException
     */
    public int doEndTag() throws JspException {
//
//        JspContext jspContext = pageContext;
//        String logged = (String) jspContext.findAttribute("logged");
//
//        // 根据session跟踪登录的状态,强迫用户登录
//        if (logged == null) {
//
//            //如果从/Login输入,请求里面有login这个参数,isLoginAction是true
//            String loginValue = (String) jspContext.findAttribute("login");
//            boolean isLoginAction = null != loginValue;
//
//            System.out.println("loginValue = " + loginValue + " session null");
//            // User is logging in
//            if (isLoginAction) {
//                System.out.println("isLoginAction");
//
//                //request添加login参数
//                request.setAttribute("login", loginValue);
//                //展示信息
//                this.displayPage(request, response,true);
//
//                //请求里面没有login这个参数,说明访问的直接是show,强迫用户转到登录状态
//            } else {
//                System.out.println("loginValue = " + loginValue + " session null, redirect to login page");
//                // Display the login page. If the cookie exists, set login
//                response.sendRedirect(request.getContextPath() + "/Login");
//            }
//        // session is not null, 用户已经登录, 刷新show界面
//        } else {
//            return EVAL_PAGE;
//        }
//
//        // EVAL_PAGE 处理标签后继续执行以下的JSP页面

        //不处理接下来的JSP页面
        return SKIP_PAGE;
    }
}

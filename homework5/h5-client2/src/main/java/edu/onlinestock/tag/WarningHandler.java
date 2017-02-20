package edu.onlinestock.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Created by kylin on 26/12/2016.
 * All rights reserved.
 */
public class WarningHandler extends SimpleTagSupport {

    public void doTag() throws JspException, IOException {

        try {
            //获取JSP里面的listStock变量,这个变量在servlet里面被设置
            // session.setAttribute("listStock", listStock);
            String message = (String) getJspContext().findAttribute("message");
            JspWriter out = getJspContext().getOut();
            // 遍历这个list,输出到界面上
            out.println("<p>");
            out.println(message);
            out.println("</p>");
        } catch (Exception e) {
            e.printStackTrace();
            throw new JspException(e.getMessage());
        }
    }
}

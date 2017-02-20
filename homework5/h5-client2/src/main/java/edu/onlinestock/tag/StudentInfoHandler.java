package edu.onlinestock.tag;

import edu.onlinestock.action.business.ClassInfoBean;
import edu.onlinestock.action.business.ClassListBean;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Created by kylin on 26/12/2016.
 * All rights reserved.
 */
public class StudentInfoHandler extends SimpleTagSupport {

    public void doTag() throws JspException, IOException {

        try {
            //获取JSP里面的listStock变量,这个变量在servlet里面被设置
            // session.setAttribute("listStock", listStock);
            ClassListBean classList = (ClassListBean) getJspContext().findAttribute("classList");
            JspWriter out = getJspContext().getOut();
            // 遍历这个list,输出到界面上
            for (int i = 0; i < classList.getClassList().size(); i++) {
                ClassInfoBean oneClass = classList.getClass(i);
                out.println("<tr>");
                out.println("<td>" + oneClass.getId() + "</td>");
                out.println("<td>" + oneClass.getName() + "</td>");
                out.println("<td>" + oneClass.getScore() + "</td>");
                out.println("</tr>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new JspException(e.getMessage());
        }
    }

}

package edu.nju.tag;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Created by kylin on 26/12/2016.
 * All rights reserved.
 */
public class CountNumberHandler extends SimpleTagSupport {

    public void doTag() throws JspException, IOException {
        JspContext jspContext = getJspContext();
        // Searches for the named attribute in page, request, session (if valid),
        // and application scope(s)
        int logged = (int) jspContext.findAttribute("logged");
        int guest = (int) jspContext.findAttribute("guest");
        int total = (int) jspContext.findAttribute("total");
        JspWriter writer = jspContext.getOut();
        writer.println("<p> 登录人数 "+logged+"</p>");
        writer.println("<p> 游客人数 "+guest+"</p>");
        writer.println("<p> 总人数 "+total+"</p>");
    }

}

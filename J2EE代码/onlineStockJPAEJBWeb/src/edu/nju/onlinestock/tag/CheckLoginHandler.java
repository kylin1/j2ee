package edu.nju.onlinestock.tag;

import com.mysql.cj.api.Session;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 * Created by kylin on 26/12/2016.
 * All rights reserved.
 * <p>
 * doStartTag()→doInitBody()→setBodyContent()→doAfterBody()→doEndTag()
 */
public class CheckLoginHandler extends BodyTagSupport {

    public int doAfterBody() throws JspException {
        PageContext context = pageContext;
        Session session = (Session) context.getSession();

        //EVAL_BODY_TAG，表示继续计算一次Body
        if (session == null) {
            System.out.println("session is null in after body");
            return EVAL_BODY_AGAIN;

            //直到返回SKIP_BODY才继续往下执行 要求JSP容器忽略主体，进入下一步的处理工作。
        } else {
            System.out.println("session is not null in after body");
            return SKIP_BODY;
        }
    }

}

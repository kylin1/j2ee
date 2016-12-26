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
        //不处理接下来的JSP页面
        return SKIP_PAGE;

        // EVAL_PAGE 处理标签后继续执行以下的JSP页面
    }
}

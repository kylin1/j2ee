package edu.onlinestock.tag;

import com.mysql.cj.api.Session;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class BodyTagExample extends BodyTagSupport {
    private int counts;

    public BodyTagExample() {
        super();
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }

    //1
    public int doStartTag() throws JspTagException {



        System.out.println("doStartTag...");
        if (counts > 0) {
            //EVAL_BODY_BUFFERED:JSP容器会将标签主体的处理结果建立成一个BodyContent对象。这是默认返回值。
            return EVAL_BODY_BUFFERED;
        } else {
            //SKIP_BODY:要求JSP容器忽略主体
            return SKIP_BODY;
        }
    }

    //2 提供BodyContent实例的一个引用，该实例为此标签处理类将主计算结果加以缓存
    public void setBodyContent(BodyContent bodyContent) {
        System.out.println("setBodyContent...");
        this.bodyContent = bodyContent;
    }

    //3 在第一次处理标签主体内容时，他讲对主体进行初始化的工作。
    public void doInitBody() throws JspTagException {
        System.out.println("doInitBody....");
    }

    //4 如果标签有主体内容，容器在执行完标签主体后，会调用这个方法。
    public int doAfterBody() throws JspTagException {
        System.out.println("do After body..." + counts);
        PageContext context = pageContext;
        Session session = (Session) context.getSession();

//        if (session == null) {
//            System.out.println("session is null in after body");
//            return EVAL_BODY_AGAIN;
//        } else {
//            System.out.println("session is not null in after body");
//            return SKIP_BODY;
//        }
        return EVAL_BODY_AGAIN;
    }

    //5 容器在遇到结束标签是会调用这个方法。
    public int doEndTag() throws JspTagException {
        System.out.println("do end Tag...");
        try {
            if (bodyContent != null) {
                bodyContent.writeOut(bodyContent.getEnclosingWriter());
            }
        } catch (java.io.IOException e) {
            throw new JspTagException("IO Error: " + e.getMessage());
        }
        //当返回 EVAL_PAGE 时，容器将在标签结束时继续计算JSP页面其他的部分
        return EVAL_PAGE;

        //如果返回 SKIP_PAGE，容器将在标签结束时停止计算JSP页面其他的部分
    }
}
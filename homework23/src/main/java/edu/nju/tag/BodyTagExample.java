package edu.nju.tag;

import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.JspTagException;

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
        //EVAL_BODY_TAG，表示继续计算一次Body
        if (counts > 1) {
            counts--;
            return EVAL_BODY_AGAIN;

            //直到返回SKIP_BODY才继续往下执行 要求JSP容器忽略主体，进入下一步的处理工作。
        } else {
            return SKIP_BODY;
        }
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
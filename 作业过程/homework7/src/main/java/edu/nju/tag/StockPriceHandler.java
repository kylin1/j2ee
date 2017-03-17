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
public class StockPriceHandler extends SimpleTagSupport {

    //如果标签类包含属性，每个属性都有对应的 getter 和 setter 方法
    private String tickerSymbol;

    //For each tag attribute, you must define a set method in the tag handler
    public void setTickerSymbol(String ts) {
        // 1. get attribute form jsp page
        tickerSymbol = ts;
    }

    /**
     * 为什么要使用自定义标签呢？主要是为了取代丑陋的 JSP 脚本
     *
     * JSP 脚本非常丑陋，难以阅读。
     * JSP 脚本和 HTML 代码混杂，维护成本高。
     * HTML 页面中嵌入 JSP 脚本，导致美工人员难以参与开发。
     *
     * 将复杂的功能封装在HTML风格的标签中
     * 处理格式化任务
     * 访问外部资源
     *
     * @throws JspException
     * @throws IOException
     */
    public void doTag() throws JspException, IOException {

        //The JspContext object provides access to implicit objects
        JspContext context = getJspContext();
        String price = "25 cents";

        try {
            JspWriter out = context.getOut();
            // 2. return price of jsp ticket
            out.println(tickerSymbol + ":" + price);
        } catch (Exception e) {
            e.printStackTrace();
            throw new JspException(e.getMessage());
        }

    }

}

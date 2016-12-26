package edu.nju.tag;


import edu.nju.action.business.StockListBean;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class StockInfoHandler extends SimpleTagSupport {

    public void doTag() throws JspException, IOException {

        try {
            //获取JSP里面的listStock变量,这个变量在servlet里面被设置
            // session.setAttribute("listStock", listStock);
            StockListBean listStock = (StockListBean) getJspContext().findAttribute("listStock");
            JspWriter out = getJspContext().getOut();
            // 遍历这个list,输出到界面上
            for (int i = 0; i < listStock.getStockList().size(); i++) {
                out.println("<tr><TD align='left'>"
                        + listStock.getStockList(i).getId() + "</TD>");
                out.println("<TD align='center'>"
                        + listStock.getStockList(i).getCompanyName() + "</TD>");
                out.println("<TD align='left'>"
                        + listStock.getStockList(i).getType() + "</TD>");
                out.println("<TD align='center'>"
                        + listStock.getStockList(i).getPrice() + "</TD>");
                out.println("<TD align='center'>"
                        + listStock.getStockList(i).getDate() + "</TD></tr>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new JspException(e.getMessage());
        }
    }

}

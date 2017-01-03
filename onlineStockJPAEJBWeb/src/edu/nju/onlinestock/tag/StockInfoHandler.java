package edu.nju.onlinestock.tag;


import edu.nju.onlinestock.action.StockListBean;
import edu.nju.onlinestock.model.Stock;

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
                Stock oneStock = listStock.getStockList(i);
                out.println("<tr>");
                out.println("<TD align='left'>" + oneStock.getId() + "</TD>");
                out.println("<TD align='center'>" + oneStock.getCompanyName() + "</TD>");
                out.println("<TD align='left'>" + oneStock.getType() + "</TD>");
                out.println("<TD align='center'>" + oneStock.getPrice() + "</TD>");
                out.println("<TD align='center'>" + oneStock.getDate() + "</TD>");
                out.println("</tr>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new JspException(e.getMessage());
        }
    }

}

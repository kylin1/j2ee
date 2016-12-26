package edu.nju.servlets;

import edu.nju.action.business.StockListBean;
import edu.nju.factory.ServiceFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet implementation class StockListServlet
 */
@WebServlet("/StockListServlet")
public class StockListServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        HttpSession session = req.getSession(true);
        ServletContext context = getServletContext();
        StockListBean listStock = new StockListBean();
        
        //listStock.setStockList(DaoFactory.getStockDao().find());
        listStock.setStockList(ServiceFactory.getStockManageService().getStock());

        try {
            // if there is no stock
            if (listStock.getStockList().size() < 1) {
                context.getRequestDispatcher("/stock/noListStock.jsp").forward(
                        req, resp);

                //there are some stocks
            } else {
                session.setAttribute("listStock", listStock);
                context.getRequestDispatcher("/stock/listStock.jsp").forward(
                        req, resp);
            }
        } catch (ServletException e) {
            // System error - report error 500 and message
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                    "This is a ServletException.");
        }
    }

}

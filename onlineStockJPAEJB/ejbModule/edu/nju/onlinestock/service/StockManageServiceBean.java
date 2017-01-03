package edu.nju.onlinestock.service;

import edu.nju.onlinestock.dao.StockDao;
import edu.nju.onlinestock.factory.EJBFactory;

import javax.ejb.Stateless;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Stateless
public class StockManageServiceBean implements StockManageService {

    /**
     * Default constructor. 
     */
/*	private static UserManageServiceBean userService=new UserManageServiceBean();
	
	private UserManageServiceBean()
	{
		
	}*/
	

	public List getStock()
	{
		StockDao stockDao = (StockDao) EJBFactory
				.getEJB("ejb:/onlineStockJPAEJB/StockDaoBean!edu.nju.onlinestock.dao.StockDao");
		return stockDao.find();
				
	}


	
	public void sentErrorMessage(String message,HttpServletRequest req) 
					throws ServletException,IOException
	{
		req.setAttribute("message",message);
//		RequestDispatcher dispater=req.getRequestDispatcher(resp.encodeURL("/error/error.jsp"));
//		dispater.forward(req,resp);
	}
	

	public void sentMessage(String message,HttpServletRequest req) 
					throws ServletException,IOException
	{
		req.setAttribute("message",message);
//		RequestDispatcher dispater=req.getRequestDispatcher(resp.encodeURL("/message/message.jsp"));
//		dispater.forward(req,resp);
	}
	

	public void forwardPage(String page,HttpServletRequest req,HttpServletResponse resp) 
					throws ServletException,IOException
	{
		RequestDispatcher dispater=req.getRequestDispatcher(resp.encodeURL(page));
		dispater.forward(req,resp);
	}

	public String test(){
		System.out.println(" test");
		return "test";

	}


}

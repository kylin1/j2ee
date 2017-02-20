package edu.nju.service.impl;

import edu.nju.factory.DaoFactory;
import edu.nju.service.StockManageService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class StockManageServiceImpl implements StockManageService {

    /**
     * Default constructor. 
     */
/*	private static UserManageServiceBean userService=new UserManageServiceBean();
	
	private UserManageServiceBean()
	{
		
	}*/
	
	private static StockManageService stockService=new StockManageServiceImpl();
	public static StockManageService getInstance()
	{
		return stockService;
	}

	public List getStock()
	{
		return DaoFactory.getStockDao().find();
				
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

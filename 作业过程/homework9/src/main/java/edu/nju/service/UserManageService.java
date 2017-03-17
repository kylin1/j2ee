package edu.nju.service;

import edu.nju.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface UserManageService {
	public User validateUser(String userid, String password);
	
//	public String validateRegister(User user,String message) throws PasswordNotMatchException ,UsernameExistException;
	

//	public String validateUpdateUser(User user,String message) throws PasswordNotMatchException;
	

	public Integer validateNumber(String number);
	

	public void sentErrorMessage(String message, HttpServletRequest req)
					throws ServletException,IOException;

	public void sentMessage(String message, HttpServletRequest req)
					throws ServletException,IOException;
	
	public void forwardPage(String page, HttpServletRequest req, HttpServletResponse resp)
					throws ServletException,IOException;
	
	public String registerUser(User user);
	public String test();

}

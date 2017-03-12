package com.kylin.controller.main;

import com.kylin.service.SystemUserService;
import com.kylin.tools.MyResponse;
import com.kylin.tools.myenum.SystemUserType;
import com.kylin.tools.myexception.BadInputException;
import com.kylin.tools.myexception.NotFoundException;
import com.kylin.vo.LoginResultVO;
import com.kylin.vo.common.MyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by kylin on 11/03/2017.
 * All rights reserved.
 */
@Controller
public class SystemUserController {

    @Autowired
    private SystemUserService systemUserService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request) {
        String account = request.getParameter("account");
        String password = request.getParameter("password");

        try {
            LoginResultVO resultVO = this.systemUserService.login(account, password);
            int userID = resultVO.getUserID();
            SystemUserType userType = resultVO.getUserType();

            HttpSession session = request.getSession();
            session.setAttribute("userID",userID);
            System.out.println("userID="+userID);

            String page = this.getLadingPageOfUser(userType);

            ModelAndView mv = new ModelAndView(page);
            return mv;
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (BadInputException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(HttpServletRequest request) {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        int type = Integer.parseInt(request.getParameter("type"));
        SystemUserType userType = SystemUserType.getType(type);

        MyMessage myMessage = this.systemUserService.signUp(account, password, userType);
        if (myMessage.isSuccess()) {
            return "index";
        } else {
            return MyResponse.failure("注册失败");
        }
    }

    private String getLadingPageOfUser(SystemUserType userType){
        if (userType == SystemUserType.Guest) {
            return "/guest/membership";
        } else if (userType == SystemUserType.Hotel) {
            return "/hotel/request";
        } else if (userType == SystemUserType.Manager) {
            return "/manager/approve";
        }
        return null;
    }
}

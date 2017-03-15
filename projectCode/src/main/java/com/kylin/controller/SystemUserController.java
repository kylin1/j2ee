package com.kylin.controller;

import com.kylin.model.Hotel;
import com.kylin.model.SystemUser;
import com.kylin.repository.HotelRepository;
import com.kylin.repository.SystemUserRepository;
import com.kylin.service.MemberService;
import com.kylin.service.SystemUserService;
import com.kylin.tools.myenum.SystemUserType;
import com.kylin.vo.LoginResultVO;
import com.kylin.vo.MemberInfoVO;
import com.kylin.vo.common.MyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
public class SystemUserController extends MyController{

    @Autowired
    private SystemUserService systemUserService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private SystemUserRepository userRepository;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login() {
        return "index";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "common/signup";
    }

    @RequestMapping(value = "/logout/{userId}", method = RequestMethod.GET)
    public String logout(HttpServletRequest request,
                         @PathVariable("userId") int userId) {
        SystemUser systemUser = userRepository.findOne(userId);
        return "redirect:/";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request) {
        String account = request.getParameter("account");
        String password = request.getParameter("password");

        ModelAndView modelAndView = new ModelAndView();
        // 用户登录
        LoginResultVO resultVO = this.systemUserService.login(account, password);

        // 登录成功
        if (resultVO.isSuccess()) {
            // 获取用户信息
            int userID = resultVO.getUserID();
            SystemUserType userType = resultVO.getUserType();

            // 获取用户登录之后的主页
            String page = this.getLadingPageOfUser(userType);
            modelAndView.setViewName(page);

            // 设置用户信息到session之中
            this.setSession(request, userID, userType);

            // 返回错误提示信息
        } else {
            String message = resultVO.getDisplayMessage();
            modelAndView = new ModelAndView("index");
            modelAndView.addObject("error", message);
        }

        // 返回结果
        return modelAndView;
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ModelAndView register(HttpServletRequest request) {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        int type = Integer.parseInt(request.getParameter("type"));
        SystemUserType userType = SystemUserType.getType(type);

        // 注册用户 以及对应的实体类
        MyMessage myMessage = this.systemUserService.signUp(account, password, userType);

        // 注册之后的界面
        String successPage = this.getLadingPageOfUser(userType);
        String errorPage = "common/signup";

        if(myMessage.isSuccess()){
            int userId = (int) myMessage.getData();
            // 设置新用户信息
            this.setSession(request,userId,userType);
        }

        return this.handleMessage(myMessage,successPage,errorPage);
    }

    /**
     * 根据用户类别获取登录之后的主页面
     *
     * @param userType
     * @return
     */
    private String getLadingPageOfUser(SystemUserType userType) {
        if (userType == SystemUserType.Guest) {
            return "redirect:/guest/membership";
        } else if (userType == SystemUserType.Hotel) {
            return "redirect:/hotel/customer-register";
        } else if (userType == SystemUserType.Manager) {
            return "redirect:/my-manager/approve";
        }
        return null;
    }

    /**
     * 用户登录之后将用户信息写入session
     *
     * @param request
     * @param userID
     * @param userType
     */
    private void setSession(HttpServletRequest request, int userID, SystemUserType userType) {
        // 得到一个用户信息
        HttpSession session = request.getSession();
        session.setAttribute("userID", userID);
        System.out.println("session set userID = " + userID);

        // 客人
        if (userType == SystemUserType.Guest) {
            MemberInfoVO memberInfoVO = memberService.getMemberInfoByUserId(userID);
            this.setUpMember(request,memberInfoVO);

            //酒店
        } else if (userType == SystemUserType.Hotel) {
            Hotel hotel = hotelRepository.findByUserId(userID);
            this.setUpHotel(request,hotel);

            //经理
        } else if (userType == SystemUserType.Manager) {
            this.setUpManager(request,userID);
        }
    }


}

package com.kylin.controller;

import com.kylin.model.Hotel;
import com.kylin.service.HotelStatusService;
import com.kylin.service.MemberService;
import com.kylin.tools.myenum.MyAuthority;
import com.kylin.vo.MemberInfoVO;
import com.kylin.vo.common.MyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by kylin on 14/03/2017.
 * All rights reserved.
 */
public class MyController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private HotelStatusService statusService;

    protected void refreshMemberInfo(HttpServletRequest request, int memberID){
        // 重新查询用户信息
        MemberInfoVO memberInfoVO = memberService.getMemberInfo(memberID);
        // 刷新session
        this.setUpMember(request,memberInfoVO);
    }


    protected void setUpMember(HttpServletRequest request, MemberInfoVO memberInfoVO) {
        HttpSession session = request.getSession();
        session.setAttribute("memberInfo", memberInfoVO);
        System.out.println("session set memberInfo = " + memberInfoVO);

        // 如果用户是激活的
        if(memberInfoVO.isActivating()){
            // 设置权限代表用户已经激活
            session.setAttribute("memberAuth",true);
            System.out.println("session set memberAuth = " + true);
        }else {
            session.setAttribute("memberAuth",false);
            System.out.println("session set memberAuth = " + false);
        }

    }

    protected void setUpHotel(HttpServletRequest request,Hotel hotel) {
        HttpSession session = request.getSession();

        // 酒店不存在,还没有通过开店审批
        if(hotel != null){
            int hotelId = hotel.getId();
            MyMessage myMessage = this.statusService.isHotelOpened(hotelId);
            boolean isHotelOpen = myMessage.isSuccess();

            session.setAttribute("hotelId", hotelId);
            session.setAttribute("hotel", hotel);
            session.setAttribute(MyAuthority.hotelAuth, isHotelOpen);

            System.out.println("session set hotelId = " + hotelId);
            System.out.println("session set hotel = " + hotel);
            System.out.println("session set hotelAuth = " + isHotelOpen);
        }
    }


    protected void setUpManager(HttpServletRequest request, int userID) {

    }

    protected ModelAndView handleMessage(MyMessage myMessage, String page) {
        ModelAndView modelAndView = new ModelAndView(page);
        if (!myMessage.isSuccess()) {
            modelAndView.addObject("error", myMessage.getDisplayMessage());
        }
        return modelAndView;
    }

    protected ModelAndView handleMessage(MyMessage myMessage, String page, Map<String, Object> object) {
        ModelAndView modelAndView = new ModelAndView(page);
        if (!myMessage.isSuccess()) {
            modelAndView.addObject("error", myMessage.getDisplayMessage());
        }
        // 都返回相同的数据到界面
        this.addDataToMV(object,modelAndView);
        return modelAndView;
    }

    protected ModelAndView handleMessage(MyMessage myMessage, String successPage, String errorPage) {
        ModelAndView modelAndView;
        // 处理成功
        if (myMessage.isSuccess()) {
            modelAndView = new ModelAndView(successPage);
            // 处理失败
        } else {
            modelAndView = new ModelAndView(errorPage);
            modelAndView.addObject("error", myMessage.getDisplayMessage());
        }
        return modelAndView;
    }

    protected ModelAndView handleMessage(MyMessage myMessage, String successPage, String errorPage,
                                         Map<String, Object> successObject, Map<String, Object> errorObjects) {
        ModelAndView modelAndView;
        // 处理成功
        if (myMessage.isSuccess()) {
            modelAndView = new ModelAndView(successPage);
            // 添加成功时候的数据
            this.addDataToMV(successObject, modelAndView);

            // 处理失败
        } else {
            modelAndView = new ModelAndView(errorPage);
            modelAndView.addObject("error", myMessage.getDisplayMessage());
            // 添加错误时候的数据
            this.addDataToMV(errorObjects, modelAndView);
        }
        return modelAndView;
    }

    private void addDataToMV(Map<String, Object> inputMap, ModelAndView modelAndView) {
        if (inputMap == null) {
            return;
        }
        for (Map.Entry<String, Object> entry : inputMap.entrySet()) {
            modelAndView.addObject(entry.getKey(), entry.getValue());
        }
    }
}

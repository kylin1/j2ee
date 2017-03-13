package com.kylin.controller.hotel;

import com.kylin.service.HotelManageService;
import com.kylin.tools.DateHelper;
import com.kylin.vo.HotelPlanInputVO;
import com.kylin.vo.common.MyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.text.ParseException;

/**
 * Created by kylin on 13/03/2017.
 * All rights reserved.
 */
@Controller
@RequestMapping("hotel")
public class HotelPlanController {

    @Autowired
    private HotelManageService manageService;

    @RequestMapping(value = "plan/{roomId}", method = RequestMethod.GET)
    public ModelAndView getPlan(HttpServletRequest request, @PathVariable("roomId") int roomId) {
        // 获取参数
        String date1 = request.getParameter("date1");
        String date2 = request.getParameter("date2");
        String room = request.getParameter("room");

        // 返回到界面
        ModelAndView modelAndView = new ModelAndView("/hotel/post-plan");
        modelAndView.addObject("hotelRoomId",roomId);

        String oldPlanEndDate = date2;

        try {
            // 新计划的开始日期,默认设置为旧的计划的下一天
            Date dateOldPlanEnd = DateHelper.getDate(oldPlanEndDate);
            Date newPlanStartDate = DateHelper.addDate(dateOldPlanEnd,1);
            String newPlanDate = DateHelper.getDateString(newPlanStartDate);
            modelAndView.addObject("newPlanDate",newPlanDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        modelAndView.addObject("room",room);

        return modelAndView;
    }

    @RequestMapping(value = "new-plan", method = RequestMethod.POST)
    public ModelAndView makePlan(HttpServletRequest request,
                                 @ModelAttribute("hotelPlanInputVO")HotelPlanInputVO hotelPlanInputVO) {
        ModelAndView modelAndView;
        System.out.println(hotelPlanInputVO);

        MyMessage myMessage = this.manageService.makePlan(hotelPlanInputVO);

        if(myMessage.isSuccess()){
            modelAndView = new ModelAndView("redirect:/hotel/plan");
        }else {
            modelAndView = new ModelAndView("/hotel/post-plan");
            modelAndView.addObject("error",myMessage.getDisplayMessage());
            modelAndView.addObject("hotelRoomId",hotelPlanInputVO.getHotelRoomId());
            modelAndView.addObject("room",hotelPlanInputVO.getRoom());
        }

        return modelAndView;
    }

}

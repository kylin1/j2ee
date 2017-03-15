package com.kylin.controller.hotel;

import com.kylin.service.HotelManageService;
import com.kylin.service.HotelModifyService;
import com.kylin.service.HotelStatisticService;
import com.kylin.vo.HotelOrderItemVO;
import com.kylin.vo.HotelPlanVO;
import com.kylin.vo.RequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by kylin on 12/03/2017.
 * All rights reserved.
 */
@Controller
@RequestMapping("hotel")
public class HotelNavigationController {

    @Autowired
    private HotelManageService manageService;
    @Autowired
    private HotelModifyService modifyService;
    @Autowired
    private HotelStatisticService statisticService;

    @RequestMapping(value = "room-search", method = RequestMethod.GET)
    public ModelAndView roomSearch() {
        ModelAndView modelAndView = new ModelAndView("hotel/room-search");
        return modelAndView;
    }

    @RequestMapping(value = "customer-register", method = RequestMethod.GET)
    public ModelAndView customerRegister(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("hotel/room-register");

        HttpSession session = request.getSession();
        int hotelId = (int) session.getAttribute("hotelId");

        // 预订信息:已预订未入住的房客订单
        List<HotelOrderItemVO> list = statisticService.getReservedOrderList(hotelId);
        modelAndView.addObject("reservedList", list);

        // 房间入住信息:每日每房间入住情况与房客信息
        return modelAndView;
    }

    @RequestMapping(value = "plan", method = RequestMethod.GET)
    public ModelAndView currentPlan(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("hotel/show-plan");

        HttpSession session = request.getSession();
        int hotelId = (int) session.getAttribute("hotelId");

        List<HotelPlanVO> planVOS = this.manageService.getHotelPlan(hotelId);
        modelAndView.addObject("planVOS", planVOS);
        return modelAndView;
    }

    @RequestMapping(value = "statistic", method = RequestMethod.GET)
    public ModelAndView statistic(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("hotel/statistic");

        return modelAndView;
    }

    @RequestMapping(value = "request", method = RequestMethod.GET)
    public ModelAndView request(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("hotel/request");
        HttpSession session = request.getSession();
        int hotelId = (int) session.getAttribute("hotelId");
        List<RequestVO> deniedList = modifyService.getDeniedRequest(hotelId);
        List<RequestVO> passedList = modifyService.getPassedRequest(hotelId);
        List<RequestVO> waitingList = modifyService.getWaitingRequest(hotelId);

        modelAndView.addObject("deniedList", deniedList);
        modelAndView.addObject("passedList", passedList);
        modelAndView.addObject("waitingList", waitingList);
        return modelAndView;
    }

}

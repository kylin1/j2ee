package com.kylin.controller.hotel;

import com.kylin.service.HotelManageService;
import com.kylin.service.HotelModifyService;
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

    @RequestMapping(value = "room-search", method = RequestMethod.GET)
    public ModelAndView roomSearch() {
        ModelAndView modelAndView = new ModelAndView("hotel/room-search");
        return modelAndView;
    }

    @RequestMapping(value = "customer-register", method = RequestMethod.GET)
    public ModelAndView customerRegister() {
        ModelAndView modelAndView = new ModelAndView("hotel/room-register");
        return modelAndView;
    }

    @RequestMapping(value = "plan", method = RequestMethod.GET)
    public ModelAndView currentPlan(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("hotel/show-plan");

        HttpSession session = request.getSession();
        int hotelId = (int) session.getAttribute("hotelId");

        List<HotelPlanVO> planVOS = this.manageService.getHotelPlan(hotelId);
        modelAndView.addObject("planVOS",planVOS);
        return modelAndView;
    }

    @RequestMapping(value = "statistic", method = RequestMethod.GET)
    public ModelAndView statistic() {
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

        modelAndView.addObject("deniedList",deniedList);
        modelAndView.addObject("passedList",passedList);
        modelAndView.addObject("waitingList",waitingList);
        return modelAndView;
    }

}

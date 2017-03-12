package com.kylin.controller.guest;

import com.kylin.service.ReserveService;
import com.kylin.vo.ReserveInputTableVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by kylin on 11/03/2017.
 * All rights reserved.
 */
@Controller
@RequestMapping("guest")
public class ReserveController {

    @Autowired
    private ReserveService reserveService;

    @RequestMapping(value = "search", method = RequestMethod.GET)
    public ModelAndView search(HttpServletRequest request, ModelMap modelMap) {
//        String location = request.getParameter("location");
//        String fromDate = request.getParameter("fromDate");
//        String endDate = request.getParameter("endDate");
//        int roomTypeInt = Integer.parseInt(request.getParameter("location"));
//        int roomNumber = Integer.parseInt(request.getParameter("location"));
//        List<SearchHotelItemVO> result = this.reserveService.search(location, fromDate, endDate,
//                roomTypeInt, roomNumber);
//        modelMap.put("result",result);
        ModelAndView result = new ModelAndView("guest/search");
        return result;
    }

    @RequestMapping(value = "reserve", method = RequestMethod.GET)
    public ModelAndView reserve(@ModelAttribute("reserveInputTableVO") ReserveInputTableVO reserveInputTableVO) {
//        MyMessage myMessage = this.reserveService.makeReservation(reserveInputTableVO);
//        if (myMessage.isSuccess()) {
//            return "";
//        } else {
//            return "";
//        }
        ModelAndView result = new ModelAndView("guest/reserve");
        return result;
    }

    @RequestMapping(value = "search-result", method = RequestMethod.GET)
    public ModelAndView makeReservation() {
//        MyMessage myMessage = this.reserveService.makeReservation(reserveInputTableVO);
//        if (myMessage.isSuccess()) {
//            return "";
//        } else {
//            return "";
//        }
        ModelAndView result = new ModelAndView("guest/search-result");
        return result;
    }
}

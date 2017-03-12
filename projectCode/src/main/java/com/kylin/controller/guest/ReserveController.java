package com.kylin.controller.guest;

import com.kylin.service.ReserveService;
import com.kylin.vo.ReserveInputTableVO;
import com.kylin.vo.SearchHotelItemVO;
import com.kylin.vo.common.MyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    public ModelAndView search() {
        return new ModelAndView("guest/search");
    }

    @RequestMapping(value = "search", method = RequestMethod.POST)
    public ModelAndView searchResult(HttpServletRequest request) {
        String location = request.getParameter("location");
        String fromDate = request.getParameter("fromDate");
        String endDate = request.getParameter("endDate");
        int roomTypeInt = Integer.parseInt(request.getParameter("roomTypeInt"));
        int roomNumber = Integer.parseInt(request.getParameter("roomNumber"));

        List<SearchHotelItemVO> result = this.reserveService.search(location, fromDate, endDate,
                roomTypeInt, roomNumber);

        ModelAndView modelAndView = new ModelAndView("guest/search-result");
        modelAndView.addObject("searchResult", result);

        return modelAndView;
    }

    @RequestMapping(value = "reserve", method = RequestMethod.POST)
    public ModelAndView reserve(@ModelAttribute("reserveInputTableVO") ReserveInputTableVO reserveInputTableVO) {
        MyMessage myMessage = this.reserveService.makeReservation(reserveInputTableVO);
        ModelAndView result;
        if (myMessage.isSuccess()) {
            result = new ModelAndView("guest/order");
        } else {
            result = new ModelAndView("guest/reserve");
            result.addObject("info", myMessage.getDisplayMessage());
        }
        return result;
    }

}

package com.kylin.controller.guest;

import com.kylin.service.ReserveService;
import com.kylin.vo.ReserveInputTableVO;
import com.kylin.vo.SearchHotelItemVO;
import com.kylin.vo.common.MyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by kylin on 11/03/2017.
 * All rights reserved.
 */
public class ReserveController {

    @Autowired
    private ReserveService reserveService;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(HttpServletRequest request, ModelMap modelMap) {
        String location = request.getParameter("location");
        String fromDate = request.getParameter("fromDate");
        String endDate = request.getParameter("endDate");
        int roomTypeInt = Integer.parseInt(request.getParameter("location"));
        int roomNumber = Integer.parseInt(request.getParameter("location"));
        List<SearchHotelItemVO> result = this.reserveService.search(location, fromDate, endDate,
                roomTypeInt, roomNumber);
        modelMap.put("result",result);

        return "";
    }

    @RequestMapping(value = "/makeReservation", method = RequestMethod.POST)
    public String makeReservation(@ModelAttribute("reserveInputTableVO") ReserveInputTableVO reserveInputTableVO) {
        MyMessage myMessage = this.reserveService.makeReservation(reserveInputTableVO);
        if (myMessage.isSuccess()) {
            return "";
        } else {
            return "";
        }
    }

}

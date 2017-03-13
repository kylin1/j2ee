package com.kylin.controller.hotel;

import com.kylin.service.HotelManageService;
import com.kylin.service.ReserveService;
import com.kylin.tools.myenum.RoomType;
import com.kylin.vo.HotelRemainRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
public class HotelRegisterController {

    @Autowired
    private ReserveService reserveService;
    @Autowired
    private HotelManageService hotelManageService;

    @RequestMapping(value = "search-room", method = RequestMethod.POST)
    public ModelAndView searchRoom(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("hotel/room-search");

        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        int roomType = Integer.parseInt(request.getParameter("roomType"));
        RoomType realType = RoomType.getEnum(roomType);

        HttpSession session = request.getSession();
        int hotelId = (int) session.getAttribute("hotelId");

        // 获取酒店剩余房间信息
        List<HotelRemainRoom> remainRoomList = this.reserveService.emptyRoomSearch(hotelId, startDate, endDate, realType);
        modelAndView.addObject("remainRoomList", remainRoomList);

        return modelAndView;
    }

    @RequestMapping(value = "select-room/{roomId}", method = RequestMethod.GET)
    public ModelAndView selectRoom(HttpServletRequest request, @PathVariable("roomId") int roomId) {
        ModelAndView modelAndView = new ModelAndView("hotel/room-register");

        return modelAndView;
    }

    @RequestMapping(value = "register-room", method = RequestMethod.POST)
    public ModelAndView registerRoom(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("hotel/room-register");

//        HotelCheckInTableVO checkInTableVO = new HotelCheckInTableVO();
//
//        MyMessage myMessage = this.hotelManageService.customCheckIn(checkInTableVO);
//
//        if (!myMessage.isSuccess()) {
//            modelAndView.addObject("error", myMessage.getDisplayMessage());
//        }
        return modelAndView;
    }

}

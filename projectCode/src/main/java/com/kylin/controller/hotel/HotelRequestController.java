package com.kylin.controller.hotel;

import com.kylin.controller.MyController;
import com.kylin.service.HotelModifyService;
import com.kylin.tools.myenum.RoomType;
import com.kylin.vo.HotelOpenVO;
import com.kylin.vo.common.MyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by kylin on 13/03/2017.
 * All rights reserved.
 */
@Controller
@RequestMapping("hotel")
public class HotelRequestController extends MyController{

    @Autowired
    private HotelModifyService modifyService;

    @RequestMapping(value = "request-open", method = RequestMethod.POST)
    public ModelAndView openRequest(HttpServletRequest request,
                                    @ModelAttribute("hotelOpenVO") HotelOpenVO hotelOpenVO) {
        MyMessage myMessage = this.modifyService.openHotelRequest(hotelOpenVO);
        return this.handleMessage(myMessage,"/hotel/request");
    }

    @RequestMapping(value = "add-room", method = RequestMethod.POST)
    public ModelAndView addRoom(HttpServletRequest request) {

        int roomType = Integer.parseInt(request.getParameter("roomType"));
        String roomNumber = request.getParameter("roomNumber");
        String roomInfo = request.getParameter("roomInfo");
        RoomType roomType1 = RoomType.getEnum(roomType);

        HttpSession httpSession = request.getSession();
        int hotelId = (int) httpSession.getAttribute("hotelId");

        MyMessage myMessage = this.modifyService.addRoom(hotelId, roomType1, roomNumber, roomInfo);

        return this.handleMessage(myMessage,"/hotel/request");
    }

}

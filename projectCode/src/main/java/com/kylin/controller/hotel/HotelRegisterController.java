package com.kylin.controller.hotel;

import com.kylin.controller.MyController;
import com.kylin.service.HotelManageService;
import com.kylin.service.ReserveService;
import com.kylin.tools.DateHelper;
import com.kylin.tools.myenum.RoomType;
import com.kylin.vo.HotelCheckInTableVO;
import com.kylin.vo.HotelRemainRoom;
import com.kylin.vo.NonMemberCheckInVO;
import com.kylin.vo.common.MyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kylin on 12/03/2017.
 * All rights reserved.
 */
@Controller
@RequestMapping("hotel")
public class HotelRegisterController extends MyController {

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
        modelAndView.addObject("startDate", startDate);
        modelAndView.addObject("endDate", endDate);

        if(remainRoomList.isEmpty()){
            modelAndView.addObject("error", "没有找到符合条件的空房信息!");
        }

        return modelAndView;
    }

    // 非会员入住:在搜索界面下面选择房间进行入住操作
    @RequestMapping(value = "select-room/{roomId}", method = RequestMethod.GET)
    public ModelAndView selectRoom(HttpServletRequest request, @PathVariable("roomId") int roomId) {
        ModelAndView modelAndView = new ModelAndView("hotel/room-register-non");
        String roomNumber = request.getParameter("room");
        String roomType = request.getParameter("roomType");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");

        // 单价
        int price = Integer.parseInt(request.getParameter("price"));

        modelAndView.addObject("roomNumber",roomNumber);
        modelAndView.addObject("roomType",roomType);
        modelAndView.addObject("startDate",startDate);
        modelAndView.addObject("endDate",endDate);

        // 计算总价
        int days = DateHelper.getDaysNumber(startDate,endDate);
        int totalPrice = price * days;
        modelAndView.addObject("totalPrice",totalPrice);

        // 跳转到为非会员登记的界面
        return modelAndView;
    }

    @RequestMapping(value = "register-room", method = RequestMethod.POST)
    public ModelAndView registerRoom(HttpServletRequest request,
                                     @ModelAttribute("checkInTableVO") HotelCheckInTableVO checkInTableVO) {
        Map<String, Object> object = new HashMap<>();
        object.put("checkInVO",checkInTableVO);

        System.out.println("before init : " + checkInTableVO);
        MyMessage myMessage1 = hotelManageService.initCheckInTableVO(checkInTableVO);
        if(!myMessage1.isSuccess()){
            return new ModelAndView("hotel/room-register","error",myMessage1.getDisplayMessage());
        }
        System.out.println("after init : " + checkInTableVO);
        MyMessage myMessage = this.hotelManageService.customCheckIn(checkInTableVO);
        return this.handleMessage(myMessage, "redirect:/hotel/customer-register",object);
    }

    @RequestMapping(value = "register-room-non", method = RequestMethod.POST)
    public ModelAndView registerRoomNonMem(HttpServletRequest request,
                                     @ModelAttribute("nonMemberCheckInVO") NonMemberCheckInVO nonMemberCheckInVO) {
        System.out.println(nonMemberCheckInVO);

        MyMessage myMessage = this.reserveService.reserveNonMember(nonMemberCheckInVO);

        return this.handleMessage(myMessage,"hotel/room-register-non");
    }

}

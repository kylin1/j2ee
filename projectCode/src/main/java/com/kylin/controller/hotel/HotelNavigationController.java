package com.kylin.controller.hotel;

import com.kylin.controller.MyController;
import com.kylin.model.Hotel;
import com.kylin.repository.HotelRepository;
import com.kylin.service.HotelManageService;
import com.kylin.service.HotelModifyService;
import com.kylin.service.HotelStatisticService;
import com.kylin.tools.DateHelper;
import com.kylin.vo.HotelOrderItemVO;
import com.kylin.vo.HotelPlanVO;
import com.kylin.vo.HotelRoomStatusVO;
import com.kylin.vo.RequestVO;
import com.kylin.vo.chart.HotelIncomeChartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by kylin on 12/03/2017.
 * All rights reserved.
 */
@Controller
@RequestMapping("hotel")
public class HotelNavigationController  extends MyController {

    @Autowired
    private HotelManageService manageService;
    @Autowired
    private HotelModifyService modifyService;
    @Autowired
    private HotelStatisticService statisticService;

    private Date start = DateHelper.START;
    private Date end = DateHelper.END;

    @Autowired
    private HotelRepository hotelRepository;

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
        boolean hotelAuth = (boolean) session.getAttribute("hotelAuth");
        // 酒店还没有通过开店申请
        if (!hotelAuth) {
            return new ModelAndView("hotel/error", "error", "请提交开店申请,再进行酒店管理操作!");
        }

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
        boolean hotelAuth = (boolean) session.getAttribute("hotelAuth");
        // 酒店还没有通过开店申请
        if (!hotelAuth) {
            return new ModelAndView("hotel/error", "error", "请提交开店申请,再进行酒店管理操作!");
        }

        List<HotelPlanVO> planVOS = this.manageService.getHotelPlan(hotelId);
        modelAndView.addObject("planVOS", planVOS);
        return modelAndView;
    }

    @RequestMapping(value = "statistic", method = RequestMethod.GET)
    public ModelAndView statistic(HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView("hotel/statistic");
        HttpSession session = request.getSession();
        boolean hotelAuth = (boolean) session.getAttribute("hotelAuth");
        // 酒店还没有通过开店申请
        if (!hotelAuth) {
            return new ModelAndView("hotel/error", "error", "请提交开店申请,再进行酒店管理操作!");
        }
        // get statistic info
        int hotelId = (int) session.getAttribute("hotelId");
        HotelIncomeChartVO incomeChartVO = statisticService.getIncomeInfo(hotelId,this.start,this.end);

        // hotel room check in info of today
        List<HotelRoomStatusVO> roomStatusVOS = statisticService.getRoomStatus(hotelId,this.end);
        modelAndView.addObject("roomStatusVOS",roomStatusVOS);

        Hotel hotel = this.hotelRepository.findOne(hotelId);
        this.setUpHotel(request,hotel);

        return this.handleChart(incomeChartVO,modelAndView);
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

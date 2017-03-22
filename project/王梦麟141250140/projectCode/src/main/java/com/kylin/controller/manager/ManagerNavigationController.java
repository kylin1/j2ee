package com.kylin.controller.manager;

import com.kylin.controller.MyController;
import com.kylin.service.ManagerApprovalService;
import com.kylin.service.ManagerStatisticService;
import com.kylin.service.PaymentService;
import com.kylin.tools.DateHelper;
import com.kylin.vo.ManagerHotelStatusVO;
import com.kylin.vo.PaymentVO;
import com.kylin.vo.RequestVO;
import com.kylin.vo.chart.HotelIncomeChartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

/**
 * Created by kylin on 12/03/2017.
 * All rights reserved.
 */
@Controller
@RequestMapping("my-manager")
public class ManagerNavigationController extends MyController{

    @Autowired
    private ManagerApprovalService approvalService;
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private ManagerStatisticService statisticService;

    private Date start = DateHelper.START;
    private Date today = DateHelper.NOW;
    private Date tomorrow = DateHelper.TOMORROW;

    @RequestMapping(value = "approve", method = RequestMethod.GET)
    public ModelAndView approve() {
        ModelAndView modelAndView = new ModelAndView("manager/approve");
        List<RequestVO> waitingList = approvalService.getWaitingRequest();
        List<RequestVO> doneList = approvalService.getDoneRequest();
        modelAndView.addObject("waitingList",waitingList);
        modelAndView.addObject("doneList",doneList);
        return modelAndView;
    }

    @RequestMapping(value = "member", method = RequestMethod.GET)
    public ModelAndView member() {
        ModelAndView modelAndView = new ModelAndView("manager/member");
        return modelAndView;
    }

    @RequestMapping(value = "settle", method = RequestMethod.GET)
    public ModelAndView settle() {
        ModelAndView modelAndView = new ModelAndView("manager/settle");
        List<PaymentVO> waitingList = this.paymentService.getWaitingPayment();
        List<PaymentVO> doneList = this.paymentService.getDonePayment();
        modelAndView.addObject("waitingList",waitingList);
        modelAndView.addObject("doneList",doneList);
        return modelAndView;
    }

    @RequestMapping(value = "statistic", method = RequestMethod.GET)
    public ModelAndView statistic() {
        ModelAndView modelAndView = new ModelAndView("manager/statistic");
        HotelIncomeChartVO paymentChartVO = statisticService.getPaymentChartVO(start, tomorrow);

        //获取今天所有酒店入住情况
        List<ManagerHotelStatusVO> list = this.statisticService.getHotelRoomStatus(today);
        modelAndView.addObject("list",list);

        return this.handleChart(paymentChartVO,modelAndView);
    }



}

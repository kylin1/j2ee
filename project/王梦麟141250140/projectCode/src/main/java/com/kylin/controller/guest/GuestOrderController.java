package com.kylin.controller.guest;

import com.kylin.controller.MyController;
import com.kylin.model.MemberOrder;
import com.kylin.repository.OrderRepository;
import com.kylin.service.ReserveService;
import com.kylin.vo.common.MyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by kylin on 15/03/2017.
 * All rights reserved.
 */
@Controller
@RequestMapping("guest")
public class GuestOrderController extends MyController{

    @Autowired
    private ReserveService service;
    @Autowired
    private OrderRepository repository;

    @RequestMapping(value = "order/cancel/{orderId}", method = RequestMethod.GET)
    public ModelAndView pass(HttpServletRequest request,
                             @PathVariable("orderId") int orderId) {
        MemberOrder memberOrder = this.repository.findOne(orderId);
        System.out.println("cancel orderId = " + orderId);
        MyMessage myMessage = this.service.cancelReservation(orderId);
        this.refreshMemberInfo(request,memberOrder.getMemberId());
        return this.handleMessage(myMessage,"redirect:/guest/orders","guest/activate-warning");
    }

}

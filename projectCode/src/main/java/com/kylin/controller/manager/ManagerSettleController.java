package com.kylin.controller.manager;

import com.kylin.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by kylin on 12/03/2017.
 * All rights reserved.
 */
@Controller
@RequestMapping("my-manager")
public class ManagerSettleController {

    @Autowired
    private PaymentService paymentService;

    private String approveMainPage = "redirect:/my-manager/settle";

    @RequestMapping(value = "payment/settle/{id}", method = RequestMethod.GET)
    public ModelAndView settle(@PathVariable("id") int id) {
        this.paymentService.settlePayment(id);
        return new ModelAndView(approveMainPage);
    }

    @RequestMapping(value = "payment/{id}", method = RequestMethod.GET)
    public ModelAndView show(@PathVariable("id") int id) {

        return new ModelAndView(approveMainPage);
    }


}

package com.kylin.controller.hotel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by kylin on 12/03/2017.
 * All rights reserved.
 */
@Controller
@RequestMapping("hotel")
public class HotelNavigationController {


    @RequestMapping(value = "customer-register", method = RequestMethod.GET)
    public ModelAndView customerRegister() {
        ModelAndView modelAndView = new ModelAndView("hotel/customer-register");
        return modelAndView;
    }

    @RequestMapping(value = "post-plan", method = RequestMethod.GET)
    public ModelAndView postPlan() {
        ModelAndView modelAndView = new ModelAndView("hotel/post-plan");
        return modelAndView;
    }

    @RequestMapping(value = "statistic", method = RequestMethod.GET)
    public ModelAndView statistic() {
        ModelAndView modelAndView = new ModelAndView("hotel/statistic");
        return modelAndView;
    }

    @RequestMapping(value = "request", method = RequestMethod.GET)
    public ModelAndView request() {
        ModelAndView modelAndView = new ModelAndView("hotel/request");
        return modelAndView;
    }

}

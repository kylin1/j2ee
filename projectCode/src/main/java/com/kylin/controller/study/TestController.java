package com.kylin.controller.study;

import com.kylin.repository.HotelRepository;
import com.kylin.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by kylin on 18/02/2017.
 * All rights reserved.
 */

@Controller
public class TestController {

    @Autowired
    HotelRepository repository;

    @Autowired
    MemberService service;

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public ModelAndView test() {
        ModelAndView modelAndView = new ModelAndView("guest/order");
        return modelAndView;
    }


    @RequestMapping(value = "/member", method = RequestMethod.GET)
    public ModelAndView test2() {
        ModelAndView modelAndView = new ModelAndView("guest/membership");
        return modelAndView;
    }


    @RequestMapping(value = "/pocket", method = RequestMethod.GET)
    public ModelAndView test3() {
        ModelAndView modelAndView = new ModelAndView("guest/pocket");
        return modelAndView;
    }


    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView test4() {
        ModelAndView modelAndView = new ModelAndView("guest/profile");
        return modelAndView;
    }

    @RequestMapping(value = "/customer-register", method = RequestMethod.GET)
    public ModelAndView test5() {
        ModelAndView modelAndView = new ModelAndView("hotel/customer-register");
        return modelAndView;
    }

    @RequestMapping(value = "/post-plan", method = RequestMethod.GET)
    public ModelAndView test6() {
        ModelAndView modelAndView = new ModelAndView("hotel/post-plan");
        return modelAndView;
    }

    @RequestMapping(value = "/statistic", method = RequestMethod.GET)
    public ModelAndView test7() {
        ModelAndView modelAndView = new ModelAndView("hotel/statistic");
        return modelAndView;
    }

    @RequestMapping(value = "/request", method = RequestMethod.GET)
    public ModelAndView test8() {
        ModelAndView modelAndView = new ModelAndView("hotel/request");
        return modelAndView;
    }
}

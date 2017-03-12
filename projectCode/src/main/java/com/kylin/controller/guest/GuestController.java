package com.kylin.controller.guest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by kylin on 12/03/2017.
 * All rights reserved.
 */
@Controller
@RequestMapping("guest")
public class GuestController {

    @RequestMapping(value = "order", method = RequestMethod.GET)
    public ModelAndView test() {
        ModelAndView modelAndView = new ModelAndView("guest/order");
        return modelAndView;
    }


    @RequestMapping(value = "member", method = RequestMethod.GET)
    public ModelAndView test2() {
        ModelAndView modelAndView = new ModelAndView("guest/membership");
        return modelAndView;
    }


    @RequestMapping(value = "pocket", method = RequestMethod.GET)
    public ModelAndView test3() {
        ModelAndView modelAndView = new ModelAndView("guest/pocket");
        return modelAndView;
    }


    @RequestMapping(value = "profile", method = RequestMethod.GET)
    public ModelAndView test4() {
        ModelAndView modelAndView = new ModelAndView("guest/profile");
        return modelAndView;
    }
}

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
public class HotelRegisterController {

    @RequestMapping(value = "search-room", method = RequestMethod.POST)
    public ModelAndView customerRegister() {
        ModelAndView modelAndView = new ModelAndView("hotel/customer-register");


        return modelAndView;
    }
}

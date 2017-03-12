package com.kylin.controller.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by kylin on 12/03/2017.
 * All rights reserved.
 */
@Controller
@RequestMapping("my-manager")
public class ManagerNavigationController {

    @RequestMapping(value = "approve", method = RequestMethod.GET)
    public ModelAndView approve() {
        ModelAndView modelAndView = new ModelAndView("manager/approve");
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
        return modelAndView;
    }

    @RequestMapping(value = "statistic", method = RequestMethod.GET)
    public ModelAndView statistic() {
        ModelAndView modelAndView = new ModelAndView("manager/statistic");
        return modelAndView;
    }

}

package com.kylin.controller.guest;

import com.kylin.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class InfoController {

    @Autowired
    private MemberService memberService;


    @RequestMapping(value = "cancel-member",method = RequestMethod.GET)
    public ModelAndView cancel(){
        ModelAndView result = new ModelAndView("guest/membership");
        return result;
    }

}

package com.kylin.controller.guest;

import com.kylin.service.MemberService;
import com.kylin.vo.common.MyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by kylin on 12/03/2017.
 * All rights reserved.
 */
@Controller
@RequestMapping("guest")
public class PocketController {

    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "top-up",method = RequestMethod.POST)
    public ModelAndView topUp(HttpServletRequest request){
        ModelAndView result = new ModelAndView("guest/pocket");

        int money = Integer.parseInt(request.getParameter("money"));
        int score = Integer.parseInt(request.getParameter("score"));

        HttpSession session = request.getSession();
        int memberId = (int) session.getAttribute("memberId");

        MyMessage myMessage = this.memberService.topUp(memberId,money,score);
        if(myMessage.isSuccess()){
            result.addObject("info","充值成功");
        }else {
            result.addObject("info",myMessage.getDisplayMessage());
        }
        return result;
    }
}

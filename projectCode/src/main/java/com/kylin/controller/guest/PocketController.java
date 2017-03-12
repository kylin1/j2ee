package com.kylin.controller.guest;

import com.kylin.service.MemberService;
import com.kylin.vo.MemberInfoVO;
import com.kylin.vo.common.MyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by kylin on 12/03/2017.
 * All rights reserved.
 */
@Controller
@RequestMapping("guest")
public class PocketController {

    @Autowired
    private MemberService memberService;

    int memberId = 1;

    @RequestMapping(value = "top-up",method = RequestMethod.GET)
    public ModelAndView getTopUp(){
        MemberInfoVO memberInfoVO = memberService.getMemberInfo(memberId);

        ModelAndView result = new ModelAndView("guest/pocket");
        result.addObject("memberInfo",memberInfoVO);

        return result;
    }

    @RequestMapping(value = "top-up",method = RequestMethod.POST)
    public ModelAndView topUp(HttpServletRequest request){
        ModelAndView result = new ModelAndView("guest/pocket");

        int money = Integer.parseInt(request.getParameter("money"));
        int score = Integer.parseInt(request.getParameter("score"));

        MyMessage myMessage = this.memberService.topUp(memberId,money,score);
        if(myMessage.isSuccess()){
            result.addObject("info","充值成功");
        }else {
            result.addObject("info",myMessage.getDisplayMessage());
        }
        return result;
    }
}

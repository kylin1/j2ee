package com.kylin.controller.guest;

import com.kylin.service.MemberService;
import com.kylin.vo.MemberInfoVO;
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
public class GuestInfoController {

    @Autowired
    private MemberService memberService;


    @RequestMapping(value = "cancel-member",method = RequestMethod.GET)
    public ModelAndView cancel(HttpServletRequest request){
        ModelAndView result = new ModelAndView("guest/membership");

        HttpSession session = request.getSession();
        MemberInfoVO memberInfoVO = (MemberInfoVO) session.getAttribute("memberInfo");
        int memberId = memberInfoVO.getId();

        memberService.cancelMember(memberId);
        return result;
    }

}

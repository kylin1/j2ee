package com.kylin.controller.guest;

import com.kylin.controller.MyController;
import com.kylin.service.MemberService;
import com.kylin.vo.MemberInfoVO;
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
public class GuestPocketController extends MyController {

    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "top-up", method = RequestMethod.POST)
    public ModelAndView topUp(HttpServletRequest request) {

        int money = Integer.parseInt(request.getParameter("money"));
        int score = Integer.parseInt(request.getParameter("score"));

        HttpSession session = request.getSession();
        MemberInfoVO memberInfoVO = (MemberInfoVO) session.getAttribute("memberInfo");
        System.out.println("top-up, money = " + money + " , score = " + score);

        int memberId = memberInfoVO.getId();
        MyMessage myMessage = this.memberService.topUp(memberId, money, score);

        this.refreshMemberInfo(request, memberId);

        return this.handleMessage(myMessage, "redirect:/guest/pocket");
    }
}

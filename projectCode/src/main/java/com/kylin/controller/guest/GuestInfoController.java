package com.kylin.controller.guest;

import com.kylin.controller.MyController;
import com.kylin.service.MemberService;
import com.kylin.vo.MemberInfoVO;
import com.kylin.vo.MemberUpdateTableVO;
import com.kylin.vo.common.MyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
public class GuestInfoController extends MyController {

    @Autowired
    private MemberService memberService;


    @RequestMapping(value = "cancel-member", method = RequestMethod.GET)
    public ModelAndView cancel(HttpServletRequest request) {

        HttpSession session = request.getSession();
        MemberInfoVO memberInfoVO = (MemberInfoVO) session.getAttribute("memberInfo");
        int memberId = memberInfoVO.getId();

        MyMessage myMessage = memberService.cancelMember(memberId);
        // 更新用户信息
        this.refreshMemberInfo(request,memberId);

        return this.handleMessage(myMessage, "guest/membership");
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ModelAndView update(HttpServletRequest request,
                               @ModelAttribute("updateVO") MemberUpdateTableVO updateVO) {
        System.out.println(updateVO);
        MyMessage myMessage = this.memberService.updateInfo(updateVO);

        // 更新用户信息
        int memberId = updateVO.getMemberId();
        this.refreshMemberInfo(request,memberId);
        return this.handleMessage(myMessage, "guest/profile");
    }

}

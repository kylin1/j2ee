package com.kylin.controller.guest;

import com.kylin.service.MemberService;
import com.kylin.tools.DateHelper;
import com.kylin.vo.MemberInfoVO;
import com.kylin.vo.MemberOrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by kylin on 12/03/2017.
 * All rights reserved.
 */
@Controller
@RequestMapping("guest")
public class GuestNavigationController {

    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "search", method = RequestMethod.GET)
    public ModelAndView search() {
        ModelAndView modelAndView = new ModelAndView("guest/search");
        modelAndView.addObject("city", "上海");
        Date today = DateHelper.NOW;
        Date tomorrow = DateHelper.TOMORROW;

        modelAndView.addObject("today", DateHelper.getDateString(today));
        modelAndView.addObject("tomorrow", DateHelper.getDateString(tomorrow));
        return modelAndView;
    }

    @RequestMapping(value = "membership", method = RequestMethod.GET)
    public ModelAndView membership() {
        ModelAndView result = new ModelAndView("guest/membership");
        return result;
    }

    @RequestMapping(value = "orders", method = RequestMethod.GET)
    public ModelAndView orders(HttpServletRequest request) {
        // 从session中获取member id
        HttpSession session = request.getSession();
        MemberInfoVO member = (MemberInfoVO) session.getAttribute("memberInfo");
        int memberId = member.getId();

        List<MemberOrderVO> doneOrderVOList = this.memberService.getDoneOrderList(memberId);
        List<MemberOrderVO> orderVOList = this.memberService.getCurrentOrderList(memberId);

        ModelAndView result = new ModelAndView("guest/order");
        result.addObject("doneOrderVOList", doneOrderVOList);
        result.addObject("orderVOList", orderVOList);
        return result;
    }

    @RequestMapping(value = "pocket", method = RequestMethod.GET)
    public ModelAndView pocket() {
        ModelAndView result = new ModelAndView("guest/pocket");
        return result;
    }

    @RequestMapping(value = "profile", method = RequestMethod.GET)
    public ModelAndView profile() {
        ModelAndView result = new ModelAndView("guest/profile");
        return result;
    }
}

package com.kylin.controller.guest;

import com.kylin.service.MemberService;
import com.kylin.vo.MemberOrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by kylin on 12/03/2017.
 * All rights reserved.
 */
@Controller
@RequestMapping("guest/order")
public class MemberOrderController {

    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView orderList() {
        System.out.println("orderlist");

        int memberId = 1;
        List<MemberOrderVO> orderVOList = this.memberService.getOrderList(memberId);
        ModelAndView result = new ModelAndView("guest/order");
        System.out.println(orderVOList.size());
        result.addObject("orderVOList", orderVOList);

        return result;
    }

}

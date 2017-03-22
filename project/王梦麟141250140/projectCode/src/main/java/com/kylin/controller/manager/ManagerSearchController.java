package com.kylin.controller.manager;

import com.kylin.controller.MyController;
import com.kylin.service.MemberService;
import com.kylin.tools.myexception.NotFoundException;
import com.kylin.vo.SearchMemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by kylin on 14/03/2017.
 * All rights reserved.
 */
@Controller
@RequestMapping("my-manager")
public class ManagerSearchController extends MyController{

    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "search-member", method = RequestMethod.POST)
    public ModelAndView search(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("manager/member");
        String input = request.getParameter("input");

        List<SearchMemberVO> searchResult = null;
        try {
            searchResult = memberService.getOrderHistory(input);
            modelAndView.addObject("searchResult",searchResult);
        } catch (NotFoundException e) {
            e.printStackTrace();
            modelAndView.addObject("error",e.getMessage());
        }
        return modelAndView;
    }

}

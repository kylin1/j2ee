package com.kylin.controller.manager;

import com.kylin.service.ManagerApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by kylin on 12/03/2017.
 * All rights reserved.
 */
@Controller
@RequestMapping("my-manager")
public class ManagerApprovalController {

    @Autowired
    private ManagerApprovalService approvalService;

    private String approveMainPage = "redirect:/my-manager/approve";

    @RequestMapping(value = "approve/pass/{id}", method = RequestMethod.GET)
    public ModelAndView pass(@PathVariable("id") int id) {
        this.approvalService.passRequest(id);
        return new ModelAndView(approveMainPage);
    }

    @RequestMapping(value = "approve/deny/{id}", method = RequestMethod.GET)
    public ModelAndView deny(@PathVariable("id") int id) {
        this.approvalService.denyRequest(id);
        return new ModelAndView(approveMainPage);
    }


    @RequestMapping(value = "approve/show/{id}", method = RequestMethod.GET)
    public ModelAndView show(@PathVariable("id") int id) {
        return new ModelAndView(approveMainPage);
    }

}

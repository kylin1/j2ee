package com.kylin.controller.manager;

import com.kylin.controller.MyController;
import com.kylin.model.Hotel;
import com.kylin.model.HotelRequest;
import com.kylin.repository.HotelRepository;
import com.kylin.repository.HotelRequestRepository;
import com.kylin.service.ManagerApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by kylin on 12/03/2017.
 * All rights reserved.
 */
@Controller
@RequestMapping("my-manager")
public class ManagerApprovalController extends MyController{

    @Autowired
    private ManagerApprovalService approvalService;
    @Autowired
    private HotelRequestRepository requestRepository;
    @Autowired
    private HotelRepository hotelRepository;

    private String approveMainPage = "redirect:/my-manager/approve";

    @RequestMapping(value = "approve/pass/{id}", method = RequestMethod.GET)
    public ModelAndView pass(HttpServletRequest request, @PathVariable("id") int id) {
        this.approvalService.passRequest(id);
        this.refreshHotel(request,id);
        return new ModelAndView(approveMainPage);
    }

    @RequestMapping(value = "approve/deny/{id}", method = RequestMethod.GET)
    public ModelAndView deny(HttpServletRequest request, @PathVariable("id") int id) {
        this.approvalService.denyRequest(id);
        this.refreshHotel(request,id);
        return new ModelAndView(approveMainPage);
    }


    @RequestMapping(value = "approve/show/{id}", method = RequestMethod.GET)
    public ModelAndView show(HttpServletRequest request, @PathVariable("id") int id) {
        return new ModelAndView(approveMainPage);
    }


    private void refreshHotel(HttpServletRequest request, int requestId) {
        HotelRequest hotelRequest = this.requestRepository.findOne(requestId);
        int hotelId = hotelRequest.getHotelId();
        Hotel hotel = this.hotelRepository.findOne(hotelId);
        this.setUpHotel(request,hotel);
    }


}

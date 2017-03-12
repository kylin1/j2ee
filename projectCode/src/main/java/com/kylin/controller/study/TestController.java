package com.kylin.controller.study;

import com.kylin.repository.HotelRepository;
import com.kylin.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by kylin on 18/02/2017.
 * All rights reserved.
 */

@Controller
public class TestController {

    @Autowired
    HotelRepository repository;

    @Autowired
    MemberService service;



}

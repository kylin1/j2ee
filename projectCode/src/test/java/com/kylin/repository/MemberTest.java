package com.kylin.repository;

import com.kylin.service.MemberService;
import com.kylin.vo.MyMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by kylin on 21/02/2017.
 * All rights reserved.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:jpa.xml"})
public class MemberTest {

    @Autowired
    private MemberService memberService;

    @Test
    public void save(){
        MyMessage myMessage = memberService.topUp(1,1,1);
        System.out.println(myMessage);
    }

}

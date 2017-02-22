package com.kylin.service;

import com.kylin.vo.MemberInfoVO;
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
@ContextConfiguration(locations = {"classpath:META-INF/test/test-context.xml"})
public class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Test
    public void testServiceToRepo(){
        MemberInfoVO vo = this.memberService.getMemberInfo(1);
        System.out.println(vo.getId());
        System.out.println(vo.getAccount());
        System.out.println(vo.getActivatedTime());
    }

}

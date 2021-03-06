package com.kylin.service;

import com.kylin.vo.RequestVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by kylin on 10/03/2017.
 * All rights reserved.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/test/test-context.xml"})
public class ManagerApprovalServiceTest {

    @Autowired
    private ManagerApprovalService service;

    @Test
    public void testGelAllApprove(){
        List<RequestVO> requestVOS = service.getWaitingRequest();
        requestVOS.forEach(System.out::println);
    }

    @Test
    public void testPassRequest(){
        this.service.passRequest(13);
    }

}

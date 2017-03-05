package com.kylin.service;

import com.kylin.vo.PaymentVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by kylin on 22/02/2017.
 * All rights reserved.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/test/test-context.xml"})
public class PaymentServiceTest {

    @Autowired
    private PaymentService service;

    @Test
    public void test(){
        List<PaymentVO> paymentVOS = this.service.getWaitingPayment();
        for (PaymentVO vo:paymentVOS){
            System.out.println(vo.getHotelName());
            System.out.println(vo.getMemberName());
            System.out.println(vo.getPrice());
        }
    }

    @Test
    public void testSettle(){
        this.service.settlePayment(1);
    }

    @Test
    public void test2(){
        List<PaymentVO> paymentVOS = this.service.getDonePayment();
        for (PaymentVO vo:paymentVOS){
            System.out.println(vo.getHotelName());
            System.out.println(vo.getMemberName());
            System.out.println(vo.getPrice());
        }
    }

}

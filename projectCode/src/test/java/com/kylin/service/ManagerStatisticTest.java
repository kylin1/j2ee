package com.kylin.service;

import com.kylin.model.Payment;
import com.kylin.repository.PaymentRepository;
import com.kylin.tools.DateHelper;
import com.kylin.vo.ManagerHotelStatusVO;
import com.kylin.vo.chart.IncomeChartVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Created by kylin on 05/03/2017.
 * All rights reserved.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/test/test-context.xml"})
public class ManagerStatisticTest {

    @Autowired
    private ManagerStatisticService service;
    @Autowired
    private PaymentRepository paymentRepository;

    @Test
    public void test(){
        List<ManagerHotelStatusVO> statusVOList = this.service.getHotelRoomStatus();
        statusVOList.forEach(System.out::println);
    }

    @Test
    public void testChart(){
        IncomeChartVO chartVO = this.service.getIncomeVO(
                DateHelper.START,new Date());
    }

    @Test
    public void testChart2() throws ParseException {
        List<Payment> incomeList = this.paymentRepository.findByDate(DateHelper.START,new Date());
        System.out.println(incomeList.size());
    }


}

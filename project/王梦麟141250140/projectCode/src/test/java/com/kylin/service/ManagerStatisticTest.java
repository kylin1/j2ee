package com.kylin.service;

import com.kylin.model.Payment;
import com.kylin.repository.PaymentRepository;
import com.kylin.tools.DateHelper;
import com.kylin.tools.MyResponse;
import com.kylin.vo.ManagerHotelStatusVO;
import com.kylin.vo.chart.HotelIncomeChartVO;
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


    private Date start = DateHelper.START;
    private Date end = DateHelper.END;

    @Test
    public void test(){
        List<ManagerHotelStatusVO> statusVOList = this.service.getHotelRoomStatus(DateHelper.NOW);
        statusVOList.forEach(System.out::println);
    }

    @Test
    public void testChart() throws ParseException {
        HotelIncomeChartVO chartVO = this.service.getPaymentChartVO(start,end);
        System.out.println(chartVO);

        String json = MyResponse.toJson(chartVO);
        System.out.println(json);
    }

    @Test
    public void testChart2() throws ParseException {
        List<Payment> incomeList = this.paymentRepository.findByDate(DateHelper.START,new Date());
        System.out.println(incomeList.size());
    }


}

package com.kylin.service;

import com.kylin.tools.DateHelper;
import com.kylin.tools.MyResponse;
import com.kylin.vo.HotelRoomStatusVO;
import com.kylin.vo.chart.HotelIncomeChartVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by kylin on 22/02/2017
 * All rights reserved.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/test/test-context.xml"})
public class HotelStatisticServiceTest {

    @Autowired
    private HotelStatisticService service;
    private Date start = DateHelper.START;
    private Date end = DateHelper.END;

    @Test
    public void test(){
        List<HotelRoomStatusVO> list = this.service.getRoomStatus(1,end);
        for(HotelRoomStatusVO roomStatusVO:list){
            System.out.println(roomStatusVO);
        }
    }


    @Test
    public void testChart(){
        int hotelId = 1;
        HotelIncomeChartVO incomeChartVO = service.getIncomeInfo(hotelId,this.start,this.end);
        System.out.println(MyResponse.toJson(incomeChartVO));
    }


}

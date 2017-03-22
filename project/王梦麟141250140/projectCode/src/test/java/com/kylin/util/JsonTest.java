package com.kylin.util;

import com.kylin.service.ManagerStatisticService;
import com.kylin.tools.DateHelper;
import com.kylin.tools.MyResponse;
import com.kylin.vo.chart.HotelIncomeChartVO;
import com.kylin.vo.chart.MyChartDataLine;
import com.kylin.vo.chart.MyChartXYItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by kylin on 15/03/2017.
 * All rights reserved.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/test/test-context.xml"})
public class JsonTest {

    private Date start = DateHelper.START;
    private Date end = DateHelper.TOMORROW;

    @Autowired
    private ManagerStatisticService statisticService;

    @Test
    public void test(){
        HotelIncomeChartVO paymentChartVO = statisticService.getPaymentChartVO(start,end);

        List<MyChartDataLine> chartDataLines  = paymentChartVO.getChartData();
        MyChartDataLine chartDataLine = chartDataLines.get(0);
        List<MyChartXYItem> chartXYItemList = chartDataLine.getChartXYItemList();
        chartXYItemList.remove(chartXYItemList.size()-1);

        int lowBond = chartDataLine.getLowBond();
        int upBond = chartDataLine.getUpBond();

        String data = MyResponse.getChartData(chartXYItemList);
        System.out.println(data);
    }
}

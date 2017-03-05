package com.kylin.service;

import com.kylin.vo.ManagerHotelStatusVO;
import com.kylin.vo.chart.InOutcomeChartVO;
import com.kylin.vo.chart.ProfitChartVO;

import java.util.Date;
import java.util.List;

/**
 * Created by kylin on 20/02/2017.
 * All rights reserved.
 */
public interface ManagerStatisticService {

    /**
     * 得到一周内各店入住情况
     *
     * @return
     */
    List<ManagerHotelStatusVO> getHotelRoomStatus();

    /**
     * 收入/支出折线图
     *
     * @return
     */
    InOutcomeChartVO getIncomeOutcomeVO(Date start, Date end);

    /**
     * 利润柱状图
     *
     * @return
     */
    ProfitChartVO getProfitVO(Date start,Date end);

}

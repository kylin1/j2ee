package com.kylin.service;

import com.kylin.vo.ManagerHotelStatusVO;
import com.kylin.vo.chart.IncomeChartVO;

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
    IncomeChartVO getIncomeVO(Date start, Date end);

}

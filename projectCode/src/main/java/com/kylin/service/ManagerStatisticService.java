package com.kylin.service;

import com.kylin.vo.ManagerHotelStatusVO;
import com.kylin.vo.chart.HotelIncomeChartVO;

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
     * 每日业务总收入折线图
     *
     * @return
     */
    HotelIncomeChartVO getPaymentChartVO(Date start, Date end);

}

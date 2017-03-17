package com.kylin.service;

import com.kylin.vo.HotelOrderItemVO;
import com.kylin.vo.HotelRoomStatusVO;
import com.kylin.vo.chart.HotelIncomeChartVO;

import java.util.Date;
import java.util.List;

/**
 * Created by kylin on 20/02/2017.
 * All rights reserved.
 */
public interface HotelStatisticService {

    /**
     * 一个酒店已预订未入住的房客订单
     *
     * @param hotelId
     * @return
     */
    List<HotelOrderItemVO> getReservedOrderList(int hotelId);

    /**
     * 每日每房间入住情况与房客信息
     *
     * @param hotelId
     * @return
     */
    List<HotelRoomStatusVO> getRoomStatus(int hotelId, Date date);

    /**
     * 酒店每日收入图表
     *
     * @param hotelId
     * @return
     */
    HotelIncomeChartVO getIncomeInfo(int hotelId, Date startDate, Date endDate);
}

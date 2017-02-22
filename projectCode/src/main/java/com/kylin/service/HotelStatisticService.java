package com.kylin.service;

import com.kylin.vo.chart.HotelIncomeChartVO;
import com.kylin.vo.HotelOrderItemVO;
import com.kylin.vo.HotelRoomStatusVO;

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
    List<HotelOrderItemVO> getOrderList(int hotelId);

    /**
     * 每日每房间入住情况与房客信息
     *
     * @param hotelId
     * @return
     */
    List<HotelRoomStatusVO> getRoomStatus(int hotelId);

    /**
     * 酒店每日收入图表
     *
     * @param hotelId
     * @return
     */
    HotelIncomeChartVO getIncomeInfo(int hotelId);
}

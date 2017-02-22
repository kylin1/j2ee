package com.kylin.service;

import com.kylin.vo.HotelCheckInTableVO;
import com.kylin.vo.HotelPlanInputVO;
import com.kylin.vo.HotelPlanVO;
import com.kylin.vo.HotelRemainRoom;
import com.kylin.vo.common.MyMessage;
import com.kylin.vo.myenum.RoomType;

import java.util.List;

/**
 * Created by kylin on 20/02/2017.
 * All rights reserved.
 */
public interface HotelManageService {

    /**
     * 酒店管理人员搜索空闲房间，给客户分配
     *
     * @param fromDate
     * @param endDate
     * @param roomType
     * @return
     */
    List<HotelRemainRoom> hotelRoomSearch(String fromDate, String endDate, RoomType roomType);

    /**
     * 从列表中选择一个房间登记入住人信息
     *
     * @param hotelCheckInTableVO
     * @return
     */
    MyMessage customCheckIn(HotelCheckInTableVO hotelCheckInTableVO);

    /**
     * 得到酒店已经发布的计划
     * 每个房间的信息
     *
     * @param hotelId
     * @return
     */
    List<HotelPlanVO> getHotelPlan(int hotelId);

    /**
     * 发布一个房间的入住计划
     *
     * @param hotelPlanInputVO
     * @return
     */
    MyMessage makePlan(HotelPlanInputVO hotelPlanInputVO);
}

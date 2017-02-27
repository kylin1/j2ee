package com.kylin.service;

import com.kylin.service.myexception.BadInputException;
import com.kylin.service.myexception.DataIntegrityException;
import com.kylin.vo.*;
import com.kylin.vo.common.MyMessage;
import com.kylin.vo.myenum.RoomType;

import java.util.List;

/**
 * Created by kylin on 20/02/2017.
 * All rights reserved.
 */
public interface HotelManageService {

    /**
     * 搜索目标地点、日期、人数的酒店信息
     * 返回符合条件的酒店列表
     *
     * @param location
     * @param fromDate
     * @param endDate
     * @param roomTypeInt
     * @param roomNumber
     * @return
     */
    List<SearchHotelItemVO> search(String location, String fromDate, String endDate,
                                   int roomTypeInt, int roomNumber);

    /**
     * 用户输入预定信息表格完成预定
     *
     * @param reserveInputTableVO
     * @return
     */
    boolean makeReservation(ReserveInputTableVO reserveInputTableVO);

    /**
     * 酒店管理人员搜索空闲房间，给客户分配
     *
     * @param fromDate
     * @param endDate
     * @param roomType
     * @return
     */
    List<HotelRemainRoom> emptyRoomSearch(int hotelId, String fromDate, String endDate, RoomType roomType);

    /**
     * 从列表中选择一个房间登记入住人信息
     *
     * @param hotelCheckInTableVO
     * @return
     */
    MyMessage customCheckIn(HotelCheckInTableVO hotelCheckInTableVO) throws BadInputException;

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
    MyMessage makePlan(HotelPlanInputVO hotelPlanInputVO) throws DataIntegrityException;
}

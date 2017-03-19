package com.kylin.service;

import com.kylin.vo.HotelCheckInTableVO;
import com.kylin.vo.HotelPlanInputVO;
import com.kylin.vo.HotelPlanVO;
import com.kylin.vo.NonMemberCheckInVO;
import com.kylin.vo.common.MyMessage;

import java.util.List;

/**
 * Created by kylin on 20/02/2017.
 * All rights reserved.
 */
public interface HotelManageService {


    /**
     * 发布一个房间的入住计划
     *
     * @param hotelPlanInputVO
     * @return
     */
    MyMessage makePlan(HotelPlanInputVO hotelPlanInputVO);

    /**
     * 得到酒店已经发布的计划
     * 每个房间的信息
     *
     * @param hotelId
     * @return
     */
    List<HotelPlanVO> getHotelPlan(int hotelId);


    /**
     * 从列表中选择一个房间登记入住人信息
     *
     * @param hotelCheckInTableVO
     * @return
     */
    MyMessage customCheckIn(HotelCheckInTableVO hotelCheckInTableVO) ;


    MyMessage reserveNonMember(NonMemberCheckInVO nonMemberCheckInVO);


    MyMessage initCheckInTableVO(HotelCheckInTableVO checkInTableVO);
}

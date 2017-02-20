package com.kylin.service;

import com.kylin.vo.CheckInVO;
import com.kylin.vo.HotelPlanVO;
import com.kylin.vo.MyMessage;

/**
 * Created by kylin on 20/02/2017.
 * All rights reserved.
 */
public interface HotelService {

    /**
     * 登记入住人信息
     *
     * @param checkInVO
     * @return
     */
    MyMessage customCheckIn(CheckInVO checkInVO);

    /**
     * 发布计划
     *
     * @param hotelPlanVO
     * @return
     */
    MyMessage makePlan(HotelPlanVO hotelPlanVO);
}

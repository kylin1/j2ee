package com.kylin.service.impl;

import com.kylin.service.HotelManageService;
import com.kylin.vo.HotelCheckInTableVO;
import com.kylin.vo.HotelPlanInputVO;
import com.kylin.vo.HotelPlanVO;
import com.kylin.vo.HotelRemainRoom;
import com.kylin.vo.common.MyMessage;
import com.kylin.vo.myenum.RoomType;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kylin on 22/02/2017.
 * All rights reserved.
 */
@Service
public class HotelManageServiceImpl implements HotelManageService {
    @Override
    public List<HotelRemainRoom> hotelRoomSearch(String fromDate, String endDate, RoomType roomType) {
        return null;
    }

    @Override
    public MyMessage customCheckIn(HotelCheckInTableVO hotelCheckInTableVO) {
        return null;
    }

    @Override
    public List<HotelPlanVO> getHotelPlan(int hotelId) {
        return null;
    }

    @Override
    public MyMessage makePlan(HotelPlanInputVO hotelPlanInputVO) {
        return null;
    }
}

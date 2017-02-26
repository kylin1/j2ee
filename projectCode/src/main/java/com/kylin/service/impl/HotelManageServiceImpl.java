package com.kylin.service.impl;

import com.kylin.model.HotelRoom;
import com.kylin.model.HotelRoomStatus;
import com.kylin.repository.HotelRoomRepository;
import com.kylin.repository.HotelRoomStatusRepository;
import com.kylin.service.HotelManageService;
import com.kylin.service.myexception.DataIntegrityException;
import com.kylin.tools.DateHelper;
import com.kylin.vo.HotelCheckInTableVO;
import com.kylin.vo.HotelPlanInputVO;
import com.kylin.vo.HotelPlanVO;
import com.kylin.vo.HotelRemainRoom;
import com.kylin.vo.common.MyMessage;
import com.kylin.vo.myenum.RoomStatus;
import com.kylin.vo.myenum.RoomType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by kylin on 22/02/2017.
 * All rights reserved.
 */
@Service
public class HotelManageServiceImpl implements HotelManageService {

    @Autowired
    private HotelRoomRepository hotelRoomRepository;

    @Autowired
    private HotelRoomStatusRepository roomStatusRepository;

    @Override
    public List<HotelRemainRoom> hotelRoomSearch(int hotelId, String fromDate, String endDate, RoomType roomType) {
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
    public MyMessage makePlan(HotelPlanInputVO hotelPlanInputVO) throws DataIntegrityException {
        // get the room of the hotel
        int hotelRoomId = hotelPlanInputVO.getHotelRoomId();
        HotelRoom hotelRoom = this.hotelRoomRepository.getOne(hotelRoomId);
        if(hotelRoom == null)
            throw new DataIntegrityException("酒店房间不存在, hotelRoomId = "+hotelRoomId);

        // get room plan info
        Date checkInDate = hotelPlanInputVO.getCheckInDate();
        Date checkOutDate = hotelPlanInputVO.getCheckOutDate();
        int price = hotelPlanInputVO.getPrice();

        // current plan
        List<HotelRoomStatus> list = roomStatusRepository.
                findByHotelRoomIdOrderByDateDesc(hotelRoomId);
        if(list.size() > 0){
            HotelRoomStatus latestPlan = list.get(0);
            Date latestDate = latestPlan.getDate();
            if(checkInDate.before(latestDate)){
                throw new DataIntegrityException("计划冲突！已有的计划结束日期:"+DateHelper.getDateString(latestDate)+"" +
                        "输入的计划开始日期:"+DateHelper.getDateString(checkInDate));
            }
        }

        // set room is available between these days
        List<Date> dates = DateHelper.getBetweenDates(checkInDate,checkOutDate);
        for (Date date:dates){
            HotelRoomStatus roomStatus = new HotelRoomStatus(hotelRoomId,date,
                    RoomStatus.Empty.ordinal(),price);
            roomStatusRepository.save(roomStatus);
        }
        return new MyMessage(true);
    }
}

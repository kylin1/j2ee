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

import java.text.ParseException;
import java.util.ArrayList;
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
        // get all room of this hotel
        List<HotelRoom> hotelRoomIdList = this.hotelRoomRepository.findByHotelId(hotelId);
        List<HotelRemainRoom> result = new ArrayList<>();

        try {
            // date info
            Date from = DateHelper.getDate(fromDate);
            Date end = DateHelper.getDate(endDate);
            int dayNumber = DateHelper.getDaysNumber(from, end);
            // every room of this hotel
            for (HotelRoom room : hotelRoomIdList) {
                // every target type room between these dates
                if (room.getType() == roomType.ordinal()) {
                    List<HotelRoomStatus> roomStatusList = this.roomStatusRepository.findByRoomAndDateAndStatus
                            (room.getId(), from, end, RoomStatus.Empty.ordinal());
                    // 房间必须在所有这些天数里面都是空闲的
                    if (roomStatusList.size() == dayNumber) {
                        //发现一个符合要求的房间
                        HotelRemainRoom remainRoom = new HotelRemainRoom(room.getId(),
                                room.getRoomNumber(), RoomType.getEnum(room.getType()),
                                RoomStatus.Empty, room.getInformation());
                        result.add(remainRoom);
                    }
                }
                // type is wrong, check next room
            }
            return result;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public MyMessage customCheckIn(HotelCheckInTableVO hotelCheckInTableVO) {
        return null;
    }

    @Override
    public List<HotelPlanVO> getHotelPlan(int hotelId) {
        // get all room of this hotel
        List<HotelRoom> hotelRoomIdList = this.hotelRoomRepository.findByHotelId(hotelId);

        // current plan of every room
        List<HotelPlanVO> result = new ArrayList<>();
        for (HotelRoom hotelRoom : hotelRoomIdList) {
            int hotelRoomId = hotelRoom.getId();
            // the current plan of thi room
            List<HotelRoomStatus> list = roomStatusRepository.
                    findByHotelRoomIdOrderByDateDesc(hotelRoomId);

            // if this room has plan
            int listSize = list.size();
            if (listSize > 0) {
                Date end = list.get(0).getDate();
                Date start = list.get(listSize - 1).getDate();

                HotelPlanVO hotelPlanVO = new HotelPlanVO(hotelRoomId, hotelRoom.getRoomNumber(),
                        RoomType.getEnum(hotelRoom.getType()), start, end);
                // add this room to planned list
                result.add(hotelPlanVO);
            }
        }

        return result;
    }

    @Override
    public MyMessage makePlan(HotelPlanInputVO hotelPlanInputVO) throws DataIntegrityException {
        // get the room of the hotel
        int hotelRoomId = hotelPlanInputVO.getHotelRoomId();
        HotelRoom hotelRoom = this.hotelRoomRepository.getOne(hotelRoomId);
        if (hotelRoom == null)
            throw new DataIntegrityException("酒店房间不存在, hotelRoomId = " + hotelRoomId);

        // get room plan info
        Date checkInDate = hotelPlanInputVO.getCheckInDate();
        Date checkOutDate = hotelPlanInputVO.getCheckOutDate();
        int price = hotelPlanInputVO.getPrice();

        // current plan
        List<HotelRoomStatus> list = roomStatusRepository.
                findByHotelRoomIdOrderByDateDesc(hotelRoomId);
        if (list.size() > 0) {
            HotelRoomStatus latestPlan = list.get(0);
            Date latestDate = latestPlan.getDate();
            if (checkInDate.before(latestDate)) {
                throw new DataIntegrityException("计划冲突！已有的计划结束日期:" + DateHelper.getDateString(latestDate) + "" +
                        "输入的计划开始日期:" + DateHelper.getDateString(checkInDate));
            }
        }

        // set room is available between these days
        List<Date> dates = DateHelper.getBetweenDates(checkInDate, checkOutDate);
        for (Date date : dates) {
            HotelRoomStatus roomStatus = new HotelRoomStatus(hotelRoomId, date,
                    RoomStatus.Empty.ordinal(), price);
            roomStatusRepository.save(roomStatus);
        }
        return new MyMessage(true);
    }
}

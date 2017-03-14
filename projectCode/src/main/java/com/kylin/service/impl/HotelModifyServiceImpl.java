package com.kylin.service.impl;

import com.kylin.model.HotelRequest;
import com.kylin.model.HotelRoom;
import com.kylin.repository.HotelRequestRepository;
import com.kylin.repository.HotelRepository;
import com.kylin.repository.HotelRoomRepository;
import com.kylin.service.HotelModifyService;
import com.kylin.tools.myenum.HotelLevel;
import com.kylin.tools.myenum.RequestStatus;
import com.kylin.tools.myenum.RoomType;
import com.kylin.vo.HotelModifyVO;
import com.kylin.vo.HotelOpenVO;
import com.kylin.vo.RequestVO;
import com.kylin.vo.common.MyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kylin on 10/03/2017.
 * All rights reserved.
 */
@Service
public class HotelModifyServiceImpl extends ApprovalService implements HotelModifyService {

    @Autowired
    private HotelRequestRepository cacheRepository;
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private HotelRoomRepository roomRepository;


    @Override
    public MyMessage openHotelRequest(HotelOpenVO openVO) {
        int userId = openVO.getUserId();
        String name = openVO.getName();
        String location = openVO.getLocation();
        HotelLevel type = openVO.getHotelLevel();

        HotelRequest hotelRequest = new HotelRequest();
        hotelRequest.setName(name);
        hotelRequest.setLocation(location);
        hotelRequest.setType(type.ordinal());

        hotelRequest.setUserId(userId);
        hotelRequest.setStatus(RequestStatus.Waiting.ordinal());

        this.cacheRepository.save(hotelRequest);

        int hotelId = hotelRequest.getId();
        return new MyMessage(true,hotelId);
    }

    @Override
    public MyMessage modifyHotelRequest(HotelModifyVO modifyVO) {
        int userId = modifyVO.getUserId();
        String name = modifyVO.getName();
        String location = modifyVO.getLocation();
        HotelLevel type = modifyVO.getHotelLevel();
        String phone = modifyVO.getPhone();
        String represent = modifyVO.getLegalRepresentative();

        HotelRequest hotelRequest = new HotelRequest();
        hotelRequest.setName(name);
        hotelRequest.setLocation(location);
        hotelRequest.setType(type.ordinal());
        hotelRequest.setPhone(phone);
        hotelRequest.setRepresentative(represent);

        hotelRequest.setUserId(userId);
        hotelRequest.setStatus(RequestStatus.Waiting.ordinal());

        this.cacheRepository.save(hotelRequest);

        int hotelId = hotelRequest.getId();
        return new MyMessage(true,hotelId);
    }

    @Override
    public MyMessage addRoom(int hotelId, RoomType roomType, String roomNumber, String roomInfo) {
        HotelRoom oldRoom = this.roomRepository.findByHotelIdAndRoomNumber(hotelId,roomNumber);
        // 房间已经存在
        if(oldRoom != null){
            return new MyMessage(false,"房间号 "+roomNumber+" 已经存在!");
        }
        // 房间不存在,新建房间
        HotelRoom room = new HotelRoom();
        room.setHotelId(hotelId);
        room.setRoomNumber(roomNumber);
        room.setType(roomType.ordinal());
        room.setInformation(roomInfo);

        this.roomRepository.save(room);

        return new MyMessage(true);
    }

    @Override
    public List<RequestVO> getWaitingRequest(int hotelId) {
        int status = RequestStatus.Waiting.ordinal();
        return this.getRequestByHotelAndStatus(hotelId, status);
    }

    @Override
    public List<RequestVO> getPassedRequest(int hotelId) {
        int status = RequestStatus.Passed.ordinal();
        return this.getRequestByHotelAndStatus(hotelId, status);
    }

    @Override
    public List<RequestVO> getDeniedRequest(int hotelId) {
        int status = RequestStatus.Denied.ordinal();
        return this.getRequestByHotelAndStatus(hotelId, status);
    }

    private List<RequestVO> getRequestByHotelAndStatus(int hotelId, int status) {
        System.out.println(this.hotelRepository == null);
        HotelRequest hotel = this.cacheRepository.findOne(hotelId);
        int userId = hotel.getUserId();
        System.out.println("userId="+userId);
        List<HotelRequest> hotelCaches = this.cacheRepository.findByUserIdAndStatus(userId, status);
        return this.getRequestVOList(hotelCaches);
    }


}

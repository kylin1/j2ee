package com.kylin.service.impl;

import com.kylin.model.HotelRequest;
import com.kylin.model.HotelRoom;
import com.kylin.repository.HotelRequestRepository;
import com.kylin.repository.HotelRepository;
import com.kylin.repository.HotelRoomRepository;
import com.kylin.service.HotelModifyService;
import com.kylin.tools.myenum.HotelLevel;
import com.kylin.tools.myenum.RequestStatus;
import com.kylin.tools.myenum.RequestType;
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
        if(this.hasRequestOpen(openVO)){
            return new MyMessage(false,"已经提交过开店申请!");
        }

        String name = openVO.getName();
        String location = openVO.getLocation();
        int intLevel = openVO.getLevel();
        HotelLevel hotelLevel = HotelLevel.getEnum(intLevel);

        HotelRequest hotelRequest = new HotelRequest();
        //基本信息
        hotelRequest.setName(name);
        hotelRequest.setLocation(location);
        hotelRequest.setLevel(hotelLevel.ordinal());
        hotelRequest.setType(RequestType.OpenHotel.ordinal());
        hotelRequest.setStatus(RequestStatus.Waiting.ordinal());
        //外键
        hotelRequest.setHotelId(openVO.getHotelId());

        this.cacheRepository.save(hotelRequest);
        return new MyMessage(true);
    }

    private boolean hasRequestOpen(HotelOpenVO openVO) {
        int hotelId = openVO.getHotelId();
        int openType = RequestType.OpenHotel.ordinal();
        int waitStatus = RequestStatus.Waiting.ordinal();

        List<HotelRequest> requests = this.cacheRepository.findByHotelIdAndStatusAndType(hotelId,waitStatus,openType);

        // 不是空的,则代表已经提交了申请
        return !requests.isEmpty();
    }

    @Override
    public MyMessage modifyHotelRequest(HotelModifyVO modifyVO) {

        if(this.hasRequestModify(modifyVO)){
            return new MyMessage(false,"已经提交过修改信息申请!");
        }

        String name = modifyVO.getName();
        String location = modifyVO.getLocation();
        int intLevel = modifyVO.getLevel();
        HotelLevel hotelLevel = HotelLevel.getEnum(intLevel);
        String phone = modifyVO.getPhone();
        String represent = modifyVO.getLegalRepresentative();

        HotelRequest hotelRequest = new HotelRequest();

        //基本信息
        hotelRequest.setName(name);
        hotelRequest.setLocation(location);
        hotelRequest.setLevel(hotelLevel.ordinal());
        hotelRequest.setPhone(phone);
        hotelRequest.setRepresentative(represent);
        hotelRequest.setType(RequestType.Management.ordinal());
        hotelRequest.setStatus(RequestStatus.Waiting.ordinal());

        //外键
        hotelRequest.setHotelId(modifyVO.getHotelId());

        this.cacheRepository.save(hotelRequest);

        int hotelId = hotelRequest.getId();
        return new MyMessage(true, hotelId);
    }

    private boolean hasRequestModify(HotelModifyVO modifyVO) {
        int hotelId = modifyVO.getHotelId();
        int openType = RequestType.Management.ordinal();
        int waitStatus = RequestStatus.Waiting.ordinal();

        List<HotelRequest> requests = this.cacheRepository.findByHotelIdAndStatusAndType(hotelId,waitStatus,openType);

        // 不是空的,则代表已经提交了申请
        return !requests.isEmpty();
    }

    @Override
    public MyMessage addRoom(int hotelId, RoomType roomType, String roomNumber, String roomInfo) {
        HotelRoom oldRoom = this.roomRepository.findByHotelIdAndRoomNumber(hotelId, roomNumber);
        // 房间已经存在
        if (oldRoom != null) {
            return new MyMessage(false, "房间号 " + roomNumber + " 已经存在!");
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
        List<HotelRequest> requests = this.cacheRepository.findByHotelIdAndStatus(hotelId, status);
        return this.getRequestVOList(requests);
    }


}

package com.kylin.service.impl;

import com.kylin.model.Hotel;
import com.kylin.model.HotelRequest;
import com.kylin.repository.HotelRequestRepository;
import com.kylin.repository.HotelRepository;
import com.kylin.service.ManagerApprovalService;
import com.kylin.tools.myenum.RequestStatus;
import com.kylin.vo.RequestVO;
import com.kylin.vo.common.MyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kylin on 22/02/2017.
 * All rights reserved.
 */
@Service
public class ManagerApprovalServiceImpl extends ApprovalService implements ManagerApprovalService {

    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private HotelRequestRepository requestRepository;

    @Override
    public List<RequestVO> getWaitingRequest() {
        int waiting = RequestStatus.Waiting.ordinal();
        List<HotelRequest> cacheList = this.requestRepository.findByStatus(waiting);
        return this.getRequestVOList(cacheList);
    }


    @Override
    public List<RequestVO> getDoneRequest() {
        int passed = RequestStatus.Passed.ordinal();
        int denied = RequestStatus.Denied.ordinal();
        List<HotelRequest> passedList = this.requestRepository.findByStatus(passed);
        List<HotelRequest> deniedList = this.requestRepository.findByStatus(denied);

        List<RequestVO> result = new ArrayList<>();
        result.addAll(this.getRequestVOList(passedList));
        result.addAll(this.getRequestVOList(deniedList));
        return result;
    }



    @Override
    public MyMessage passRequest(int requestId) {
        // 修改缓存表为通过
        HotelRequest cache = this.requestRepository.findOne(requestId);
        cache.setStatus(RequestStatus.Passed.ordinal());
        this.requestRepository.save(cache);

        // 将数据写入真正的表
        int hotelId = cache.getId();
        Hotel oldHotel = this.hotelRepository.findOne(hotelId);

        // 酒店已经存在，修改信息
        if(oldHotel != null){
            this.copyHotel(oldHotel,cache);
            this.hotelRepository.save(oldHotel);
        }else {
            // 酒店不存在，新建酒店
            Hotel newHotel = new Hotel();
            this.copyHotel(newHotel,cache);
            this.hotelRepository.save(newHotel);
        }
        return new MyMessage(true);
    }

    private void copyHotel(Hotel newHotel, HotelRequest cache) {
        newHotel.setId(cache.getId());
        newHotel.setName(cache.getName());
        newHotel.setLocation(cache.getLocation());
        newHotel.setLevel(cache.getLevel());
        newHotel.setUserId(cache.getUserId());
        newHotel.setPhone(cache.getPhone());
        newHotel.setRepresentative(cache.getRepresentative());
    }


    @Override
    public MyMessage denyRequest(int requestId) {
        // 修改缓存表为不通过
        HotelRequest cache = this.requestRepository.findOne(requestId);
        cache.setStatus(RequestStatus.Denied.ordinal());
        this.requestRepository.save(cache);
        return new MyMessage(true);
    }

}

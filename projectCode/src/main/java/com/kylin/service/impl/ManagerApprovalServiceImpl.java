package com.kylin.service.impl;

import com.kylin.model.Hotel;
import com.kylin.model.HotelCache;
import com.kylin.repository.HotelCacheRepository;
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
public class ManagerApprovalServiceImpl extends ApprovalServiceImpl implements ManagerApprovalService {

    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private HotelCacheRepository cacheRepository;

    @Override
    public List<RequestVO> getWaitingRequest() {
        int waiting = RequestStatus.Waiting.ordinal();
        List<HotelCache> cacheList = this.cacheRepository.findByStatus(waiting);
        return this.getRequestVOList(cacheList);
    }


    @Override
    public List<RequestVO> getDoneRequest() {
        int passed = RequestStatus.Passed.ordinal();
        int denied = RequestStatus.Denied.ordinal();
        List<HotelCache> passedList = this.cacheRepository.findByStatus(passed);
        List<HotelCache> deniedList = this.cacheRepository.findByStatus(denied);

        List<RequestVO> result = new ArrayList<>();
        result.addAll(this.getRequestVOList(passedList));
        result.addAll(this.getRequestVOList(deniedList));
        return result;
    }



    @Override
    public MyMessage passRequest(int requestId) {
        // 修改缓存表为通过
        HotelCache cache = this.cacheRepository.findOne(requestId);
        cache.setStatus(RequestStatus.Passed.ordinal());
        this.cacheRepository.save(cache);

        // 将数据写入真正的表
        int hotelId = cache.getId();
        Hotel oldHotel = this.hotelRepository.findOne(hotelId);
        oldHotel.setName(cache.getName());
        oldHotel.setLocation(cache.getLocation());
        oldHotel.setLevel(cache.getLevel());
        this.hotelRepository.save(oldHotel);

        return new MyMessage(true);
    }

    @Override
    public MyMessage denyRequest(int requestId) {
        // 修改缓存表为不通过
        HotelCache cache = this.cacheRepository.findOne(requestId);
        cache.setStatus(RequestStatus.Denied.ordinal());
        this.cacheRepository.save(cache);
        return new MyMessage(true);
    }
}

package com.kylin.service.impl;

import com.kylin.model.HotelCache;
import com.kylin.repository.HotelCacheRepository;
import com.kylin.repository.HotelRepository;
import com.kylin.service.HotelModifyService;
import com.kylin.tools.myenum.HotelLevel;
import com.kylin.tools.myenum.RequestStatus;
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
public class HotelModifyServiceImpl extends ApprovalServiceImpl implements HotelModifyService {

    @Autowired
    private HotelCacheRepository repository;
    @Autowired
    private HotelRepository hotelRepository;


    @Override
    public MyMessage openHotelRequest(HotelOpenVO openVO) {
        int userId = openVO.getUserId();
        String name = openVO.getName();
        String location = openVO.getLocation();
        HotelLevel type = openVO.getType();


        HotelCache hotelCache = new HotelCache();
        hotelCache.setName(name);
        hotelCache.setLocation(location);
        hotelCache.setType(type.ordinal());

        hotelCache.setUserId(userId);
        hotelCache.setStatus(RequestStatus.Waiting.ordinal());

        this.repository.save(hotelCache);

        int hotelId = hotelCache.getId();
        return new MyMessage(true,hotelId);
    }

    @Override
    public MyMessage modifyHotelRequest(HotelModifyVO modifyVO) {
        int userId = modifyVO.getUserId();
        String name = modifyVO.getName();
        String location = modifyVO.getLocation();
        HotelLevel type = modifyVO.getType();
        String phone = modifyVO.getPhone();
        String represent = modifyVO.getLegalRepresentative();

        HotelCache hotelCache = new HotelCache();
        hotelCache.setName(name);
        hotelCache.setLocation(location);
        hotelCache.setType(type.ordinal());
        hotelCache.setPhone(phone);
        hotelCache.setRepresentative(represent);

        hotelCache.setUserId(userId);
        hotelCache.setStatus(RequestStatus.Waiting.ordinal());

        this.repository.save(hotelCache);

        int hotelId = hotelCache.getId();
        return new MyMessage(true,hotelId);
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
        int userId = this.hotelRepository.findIdByUserId(hotelId);
        List<HotelCache> hotelCaches = this.repository.findByUserIdAndStatus(userId, status);
        return this.getRequestVOList(hotelCaches);
    }
}

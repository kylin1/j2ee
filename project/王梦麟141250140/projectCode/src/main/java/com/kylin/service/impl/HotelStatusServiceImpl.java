package com.kylin.service.impl;

import com.kylin.model.Hotel;
import com.kylin.model.HotelRequest;
import com.kylin.repository.HotelRepository;
import com.kylin.repository.HotelRequestRepository;
import com.kylin.service.HotelStatusService;
import com.kylin.tools.myenum.RequestStatus;
import com.kylin.tools.myenum.RequestType;
import com.kylin.vo.common.MyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kylin on 14/03/2017.
 * All rights reserved.
 */
@Service
public class HotelStatusServiceImpl implements HotelStatusService{

    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private HotelRequestRepository requestRepository;

    @Override
    public MyMessage isHotelOpened(int hotelId) {
        Hotel hotel = this.hotelRepository.findOne(hotelId);
        if(hotel == null){
            return new MyMessage(false,"酒店不存在! hotelId = "+hotelId);
        }
        int passedStatus = RequestStatus.Passed.ordinal();
        int openRequestType = RequestType.OpenHotel.ordinal();

        // 一个酒店id对应有 开店申请0,已经通过1,才是开了的酒店
        List<HotelRequest> request = this.requestRepository.findByHotelIdAndStatusAndType(
                hotelId,passedStatus,openRequestType);

        if(!request.isEmpty()){
            return new MyMessage(true);
        }else {
            return new MyMessage(false,"酒店尚未通过开店申请!");
        }
    }
}

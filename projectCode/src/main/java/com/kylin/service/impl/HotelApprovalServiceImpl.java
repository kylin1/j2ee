package com.kylin.service.impl;

import com.kylin.service.HotelApprovalService;
import com.kylin.vo.RequestVO;
import com.kylin.vo.common.MyMessage;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kylin on 22/02/2017.
 * All rights reserved.
 */
@Service
public class HotelApprovalServiceImpl implements HotelApprovalService {

    @Override
    public MyMessage postRequest(RequestVO requestVO) {
        return null;
    }

    @Override
    public List<RequestVO> getWaitingRequest(int hotelId) {
        return null;
    }

    @Override
    public List<RequestVO> getDoneRequest(int hotelId) {
        return null;
    }
}

package com.kylin.service.impl;

import com.kylin.model.HotelRequest;
import com.kylin.repository.HotelRequestRepository;
import com.kylin.tools.myenum.RequestType;
import com.kylin.vo.RequestVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kylin on 10/03/2017.
 * All rights reserved.
 */
public class ApprovalService {

    @Autowired
    private HotelRequestRepository cacheRepository;

    protected List<RequestVO> getRequestVOList(List<HotelRequest> cacheList) {
        List<RequestVO> requestVOS = new ArrayList<>();
        for (HotelRequest hotelRequest : cacheList) {
            int hotelId = hotelRequest.getId();
            String hotelName = this.cacheRepository.findNameById(hotelId);

            int hotelTypeInt = hotelRequest.getType();
            RequestType type = RequestType.getEnum(hotelTypeInt);
            String mainContent = hotelName + "正在申请" + type.getStringType();
            String detailedContent = hotelRequest.readDetail();

            RequestVO vo = new RequestVO(hotelId, hotelName, mainContent, type, detailedContent);
            requestVOS.add(vo);
        }

        return requestVOS;
    }
}

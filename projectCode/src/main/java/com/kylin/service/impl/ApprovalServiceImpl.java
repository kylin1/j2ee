package com.kylin.service.impl;

import com.kylin.model.HotelCache;
import com.kylin.repository.HotelRepository;
import com.kylin.tools.myenum.RequestType;
import com.kylin.vo.RequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kylin on 10/03/2017.
 * All rights reserved.
 */
@Service
public class ApprovalServiceImpl {

    @Autowired
    private HotelRepository hotelRepository;

    protected List<RequestVO> getRequestVOList(List<HotelCache> cacheList) {
        List<RequestVO> requestVOS = new ArrayList<>();
        for (HotelCache hotelCache : cacheList) {
            int hotelId = hotelCache.getId();
            String hotelName = this.hotelRepository.findNameById(hotelId);

            int hotelTypeInt = hotelCache.getType();
            RequestType type = RequestType.getEnum(hotelTypeInt);
            String mainContent = hotelName + "正在申请" + type.getStringType();
            String detailedContent = hotelCache.readDetail();

            RequestVO vo = new RequestVO(hotelId, hotelName, mainContent, type, detailedContent);
            requestVOS.add(vo);
        }

        return requestVOS;
    }
}

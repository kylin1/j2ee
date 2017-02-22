package com.kylin.service;

import com.kylin.vo.common.MyMessage;
import com.kylin.vo.RequestVO;

import java.util.List;

/**
 * Created by kylin on 20/02/2017.
 * All rights reserved.
 */
public interface HotelApprovalService {


    // ------------酒店接口------------

    /**
     * 新的申请
     *
     * @param requestVO
     * @return
     */
    MyMessage postRequest(RequestVO requestVO);


    /**
     * 获取正在审批的信息
     *
     * @return
     */
    List<RequestVO> getWaitingRequest(int hotelId);

    /**
     * 获取审批结束的信息
     *
     * @return
     */
    List<RequestVO> getDoneRequest(int hotelId);

}

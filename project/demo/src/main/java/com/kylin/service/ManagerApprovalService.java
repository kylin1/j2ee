package com.kylin.service;

import com.kylin.vo.RequestVO;
import com.kylin.vo.MyMessage;

import java.util.List;

/**
 * Created by kylin on 20/02/2017.
 * All rights reserved.
 */
public interface ManagerApprovalService {

    // ------------经理接口------------

    /**
     * 获取没有审批的信息
     *
     * @return
     */
    List<RequestVO> getWaitingRequest();

    /**
     * 获取审批结束的信息
     *
     * @return
     */
    List<RequestVO> getDoneRequest();

    /**
     * 通过一个申请
     *
     * @param requestId
     * @return
     */
    MyMessage passRequest(int requestId);

    /**
     * 否决一个申请
     *
     * @param requestId
     * @return
     */
    MyMessage denyRequest(int requestId);



}

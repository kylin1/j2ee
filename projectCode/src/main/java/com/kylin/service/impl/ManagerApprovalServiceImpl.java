package com.kylin.service.impl;

import com.kylin.service.ManagerApprovalService;
import com.kylin.vo.RequestVO;
import com.kylin.vo.common.MyMessage;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kylin on 22/02/2017.
 * All rights reserved.
 */
@Service
public class ManagerApprovalServiceImpl implements ManagerApprovalService {
    @Override
    public List<RequestVO> getWaitingRequest() {
        return null;
    }

    @Override
    public List<RequestVO> getDoneRequest() {
        return null;
    }

    @Override
    public MyMessage passRequest(int requestId) {
        return null;
    }

    @Override
    public MyMessage denyRequest(int requestId) {
        return null;
    }
}

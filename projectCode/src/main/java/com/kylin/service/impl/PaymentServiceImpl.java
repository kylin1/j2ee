package com.kylin.service.impl;

import com.kylin.service.PaymentService;
import com.kylin.vo.PaymentVO;
import com.kylin.vo.common.MyMessage;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kylin on 22/02/2017.
 * All rights reserved.
 */
@Service
public class PaymentServiceImpl implements PaymentService {



    @Override
    public List<PaymentVO> getWaitingPayment() {
        return null;
    }

    @Override
    public List<PaymentVO> getDonePayment() {
        return null;
    }

    @Override
    public MyMessage settlePayment(int paymentId) {
        return null;
    }
}

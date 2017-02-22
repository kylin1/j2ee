package com.kylin.service;

import com.kylin.vo.common.MyMessage;
import com.kylin.vo.PaymentVO;

import java.util.List;

/**
 * Created by kylin on 20/02/2017.
 * All rights reserved.
 */
public interface PaymentService {

    List<PaymentVO> getAllPayment();

    MyMessage settlePayment(int paymentId);

}

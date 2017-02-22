package com.kylin.service;

import com.kylin.vo.common.MyMessage;
import com.kylin.vo.PaymentVO;

import java.util.List;

/**
 * Created by kylin on 20/02/2017.
 * All rights reserved.
 */
public interface PaymentService {

    /**
     * 没有处理的会员卡付款
     * @return
     */
    List<PaymentVO> getWaitingPayment();

    /**
     * 已经结算
     */
    List<PaymentVO> getDonePayment();

    /**
     * 将会员卡支付结算给各店
     *
     * @param paymentId
     * @return
     */
    MyMessage settlePayment(int paymentId);

}

package com.kylin.service.impl;

import com.kylin.model.Hotel;
import com.kylin.model.Member;
import com.kylin.model.Payment;
import com.kylin.repository.HotelRepository;
import com.kylin.repository.MemberRepository;
import com.kylin.repository.PaymentRepository;
import com.kylin.service.PaymentService;
import com.kylin.vo.PaymentVO;
import com.kylin.vo.common.MyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kylin on 22/02/2017.
 * All rights reserved.
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository repository;
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private MemberRepository memberRepository;

    private int settled = 1;
    private int waiting = 0;

    @Override
    public List<PaymentVO> getWaitingPayment() {
        return this.getPayment(waiting);
    }

    @Override
    public List<PaymentVO> getDonePayment() {
        return this.getPayment(settled);
    }

    private List<PaymentVO> getPayment(int isSettled) {
        List<PaymentVO> result = new ArrayList<>();

        List<Payment> payments = this.repository.findAll();
        for (Payment payment : payments) {
            // 付款状态
            int statusInt = payment.getStatus();

            // 其他信息
            int hotelId = payment.getHotelId();
            int memberId = payment.getMemberId();
            Hotel hotel = hotelRepository.findOne(hotelId);
            Member member = memberRepository.findOne(memberId);

            // 付款状态是 输入的状态
            if (statusInt == isSettled) {
                PaymentVO vo = new PaymentVO(payment.getId(),hotelId, hotel.getName(), member.getName(),
                        payment.getTime(), payment.getPrice(), isSettled == this.settled);
                result.add(vo);
            }

        }
        return result;
    }

    @Override
    public MyMessage settlePayment(int paymentId) {
        Payment payment = this.repository.findOne(paymentId);
        if (payment == null) {
            return new MyMessage(false, "Payment不存在，id=" + paymentId);
        }
        // 如果状态不是 没有处理
        if (payment.getStatus() != 0) {
            return new MyMessage(false, "Payment已经被处理过，id=" + paymentId);
        }
        //设置为已经处理
        payment.setStatus(1);
        this.repository.save(payment);
        return new MyMessage(true);
    }
}

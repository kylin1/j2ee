package com.kylin.vo;

import com.kylin.vo.myenum.PaymentType;

import java.util.List;

/**
 * Created by kylin on 20/02/2017.
 * All rights reserved.
 */
public class HotelCheckInTableVO {

    private int hotelId;

    private int roomId;

    // 房间入住人信息
    private List<HotelGuest> hotelGuestList;

    // 是否会员
    private boolean isMember;

    // 付款方式
    private PaymentType paymentType;

    public HotelCheckInTableVO(int hotelId, int roomId, List<HotelGuest> hotelGuestList, boolean isMember, PaymentType paymentType) {
        this.hotelId = hotelId;
        this.roomId = roomId;
        this.hotelGuestList = hotelGuestList;
        this.isMember = isMember;
        this.paymentType = paymentType;
    }

    public int getHotelId() {
        return hotelId;
    }

    public int getRoomId() {
        return roomId;
    }

    public List<HotelGuest> getHotelGuestList() {
        return hotelGuestList;
    }

    public boolean isMember() {
        return isMember;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }
}

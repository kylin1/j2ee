package com.kylin.vo;

import com.kylin.tools.myenum.PaymentType;

import java.util.List;

/**
 * Created by kylin on 20/02/2017.
 * All rights reserved.
 *
 * 酒店入住登记表格
 */
public class HotelCheckInTableVO {

    private int hotelId;

    private int orderId;

    // 房间入住人信息
    private List<HotelRoomCheckIn> hotelRoomCheckInList;

    // 是否会员
    private boolean isMember;

    // 付款方式
    private PaymentType paymentType;

    public HotelCheckInTableVO(int hotelId, int orderId, List<HotelRoomCheckIn> hotelRoomCheckInList, boolean isMember, PaymentType paymentType) {
        this.hotelId = hotelId;
        this.orderId = orderId;
        this.hotelRoomCheckInList = hotelRoomCheckInList;
        this.isMember = isMember;
        this.paymentType = paymentType;
    }

    public int getHotelId() {
        return hotelId;
    }

    public int getOrderId() {
        return orderId;
    }

    public List<HotelRoomCheckIn> getHotelRoomCheckInList() {
        return hotelRoomCheckInList;
    }

    public boolean isMember() {
        return isMember;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    @Override
    public String toString() {
        return "HotelCheckInTableVO{" +
                "hotelId=" + hotelId +
                ", orderId=" + orderId +
                ", hotelRoomCheckInList=" + hotelRoomCheckInList +
                ", isMember=" + isMember +
                ", paymentType=" + paymentType +
                '}';
    }
}

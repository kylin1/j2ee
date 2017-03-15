package com.kylin.vo;

import com.kylin.tools.myenum.PaymentType;

import java.util.Arrays;
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

    private String[] roomNumbers = new String[2];
    private String[] guests = new String[4];
    private String[] cards = new String[4];

    // 是否会员
    private boolean isMember;

    // 付款方式
    private int intPaymentType;


    // 房间入住人信息
    private List<HotelRoomCheckIn> hotelRoomCheckInList;

    public HotelCheckInTableVO() {
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
        return PaymentType.getEnum(this.intPaymentType);
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String[] getRoomNumbers() {
        return roomNumbers;
    }

    public void setRoomNumbers(String[] roomNumbers) {
        this.roomNumbers = roomNumbers;
    }

    public String[] getGuests() {
        return guests;
    }

    public void setGuests(String[] guests) {
        this.guests = guests;
    }

    public String[] getCards() {
        return cards;
    }

    public void setCards(String[] cards) {
        this.cards = cards;
    }

    public void setMember(boolean member) {
        isMember = member;
    }

    public int getIntPaymentType() {
        return intPaymentType;
    }

    public void setIntPaymentType(int intPaymentType) {
        this.intPaymentType = intPaymentType;
    }

    public void setHotelRoomCheckInList(List<HotelRoomCheckIn> hotelRoomCheckInList) {
        this.hotelRoomCheckInList = hotelRoomCheckInList;
    }

    @Override
    public String toString() {
        return "HotelCheckInTableVO{" +
                "hotelId=" + hotelId +
                ", orderId=" + orderId +
                ", roomNumbers=" + Arrays.toString(roomNumbers) +
                ", guests=" + Arrays.toString(guests) +
                ", cards=" + Arrays.toString(cards) +
                ", isMember=" + isMember +
                ", intPaymentType=" + intPaymentType +
                ", hotelRoomCheckInList=" + hotelRoomCheckInList +
                '}';
    }

}

package com.kylin.vo;

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

    private String roomNumber;
    private String guest1;
    private String guest2;
    private String card1;
    private String card2;

    // 是否会员
    private boolean isMember;

    // 付款方式
    private int intPaymentType;


    // 房间入住人信息
    private List<HotelRoomCheckIn> hotelRoomCheckInList;

    public HotelCheckInTableVO() {
    }

    @Override
    public String toString() {
        return "HotelCheckInTableVO{" +
                "hotelId=" + hotelId +
                ", orderId=" + orderId +
                ", roomNumber='" + roomNumber + '\'' +
                ", guest1='" + guest1 + '\'' +
                ", guest2='" + guest2 + '\'' +
                ", card1='" + card1 + '\'' +
                ", card2='" + card2 + '\'' +
                ", isMember=" + isMember +
                ", intPaymentType=" + intPaymentType +
                ", hotelRoomCheckInList=" + hotelRoomCheckInList +
                '}';
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getGuest1() {
        return guest1;
    }

    public void setGuest1(String guest1) {
        this.guest1 = guest1;
    }

    public String getGuest2() {
        return guest2;
    }

    public void setGuest2(String guest2) {
        this.guest2 = guest2;
    }

    public String getCard1() {
        return card1;
    }

    public void setCard1(String card1) {
        this.card1 = card1;
    }

    public String getCard2() {
        return card2;
    }

    public void setCard2(String card2) {
        this.card2 = card2;
    }

    public boolean isMember() {
        return isMember;
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

    public List<HotelRoomCheckIn> getHotelRoomCheckInList() {
        return hotelRoomCheckInList;
    }

    public void setHotelRoomCheckInList(List<HotelRoomCheckIn> hotelRoomCheckInList) {
        this.hotelRoomCheckInList = hotelRoomCheckInList;
    }
}

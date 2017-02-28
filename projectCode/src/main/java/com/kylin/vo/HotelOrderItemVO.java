package com.kylin.vo;

import com.kylin.tools.myenum.RoomType;

import java.util.Date;

/**
 * Created by kylin on 20/02/2017.
 * All rights reserved.
 *
 * 已预订未入住的房客订单
 */
public class HotelOrderItemVO {

    //预定时间
    private Date orderTime;

    //房间信息
    private RoomType roomType;

    private int roomNumber;

    //入住离开时间
    private Date checkInDate;

    private Date checkOutDate;

    //联系人
    private String contactPersonName;

    private String contactPhone;

    public HotelOrderItemVO(Date orderTime, RoomType roomType, int roomNumber, Date checkInDate, Date checkOutDate, String contactPersonName, String contactPhone) {
        this.orderTime = orderTime;
        this.roomType = roomType;
        this.roomNumber = roomNumber;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.contactPersonName = contactPersonName;
        this.contactPhone = contactPhone;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public String getContactPhone() {
        return contactPhone;
    }
}

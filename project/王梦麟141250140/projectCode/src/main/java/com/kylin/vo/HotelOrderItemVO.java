package com.kylin.vo;

import com.kylin.tools.DateHelper;
import com.kylin.tools.myenum.RoomType;

import java.util.Date;

/**
 * Created by kylin on 20/02/2017.
 * All rights reserved.
 *
 * 已预订未入住的房客订单
 */
public class HotelOrderItemVO {

    private int orderId;

    //预定时间
    private Date orderTime;
    private String orderTimeStr;

    //房间信息
    private RoomType roomType;
    private String strType;

    private int roomNumber;

    private String hotelRoomNumbers;

    //入住离开时间
    private Date checkInDate;
    private String date1;

    private Date checkOutDate;
    private String date2;

    //联系人
    private String contactPersonName;

    private String contactPhone;

    public HotelOrderItemVO(int orderId, Date orderTime, RoomType roomType, int roomNumber, String hotelRoomNumbers, Date checkInDate, Date checkOutDate, String contactPersonName, String contactPhone) {
        this.orderId = orderId;
        this.orderTime = orderTime;
        this.roomType = roomType;
        this.roomNumber = roomNumber;
        this.hotelRoomNumbers = hotelRoomNumbers;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.contactPersonName = contactPersonName;
        this.contactPhone = contactPhone;
        this.init();
    }

    private void init() {
        this.strType = this.roomType.getType();
        this.date1 = DateHelper.getDateString(checkInDate);
        this.date2 = DateHelper.getDateString(checkOutDate);
        this.orderTimeStr = DateHelper.getDateString(orderTime);
    }

    public String getOrderTimeStr() {
        return orderTimeStr;
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

    public String getHotelRoomNumbers() {
        return hotelRoomNumbers;
    }

    @Override
    public String toString() {
        return "HotelOrderItemVO{" +
                "orderTime=" + orderTime +
                ", roomType=" + roomType +
                ", strType='" + strType + '\'' +
                ", roomNumber=" + roomNumber +
                ", hotelRoomNumbers='" + hotelRoomNumbers + '\'' +
                ", checkInDate=" + checkInDate +
                ", date1='" + date1 + '\'' +
                ", checkOutDate=" + checkOutDate +
                ", date2='" + date2 + '\'' +
                ", contactPersonName='" + contactPersonName + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                '}';
    }

    public String getStrType() {
        return strType;
    }

    public String getDate1() {
        return date1;
    }

    public String getDate2() {
        return date2;
    }

    public int getOrderId() {
        return orderId;
    }
}

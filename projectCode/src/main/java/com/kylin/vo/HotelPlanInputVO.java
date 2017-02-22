package com.kylin.vo;

import java.util.Date;

/**
 * Created by kylin on 20/02/2017.
 * All rights reserved.
 *
 * 一个房间的入住计划
 */
public class HotelPlanInputVO {

    private int hotelId;

    // 房间ID
    private int roomId;

    // date info
    private Date checkInDate;

    private Date checkOutDate;

    //每日每晚价格
    private int price;

    public int getHotelId() {
        return hotelId;
    }

    public int getRoomId() {
        return roomId;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public int getPrice() {
        return price;
    }

    public HotelPlanInputVO(int hotelId, int roomId, Date checkInDate, Date checkOutDate, int price) {
        this.hotelId = hotelId;
        this.roomId = roomId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.price = price;
    }
}

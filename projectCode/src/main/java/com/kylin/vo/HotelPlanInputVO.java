package com.kylin.vo;

import com.kylin.tools.DateHelper;

import java.text.ParseException;
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
    private String room;
    private int hotelRoomId;

    // date info
    private String startDate;
    private String endDate;

    //每日每晚价格
    private int price;

    public HotelPlanInputVO(int hotelId, String room, int hotelRoomId, String startDate, String endDate, int price) {
        this.hotelId = hotelId;
        this.room = room;
        this.hotelRoomId = hotelRoomId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public HotelPlanInputVO() {
    }

    public int getHotelId() {
        return hotelId;
    }

    public int getHotelRoomId() {
        return hotelRoomId;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public int getPrice() {
        return price;
    }

    public Date getCheckInDate() {
        try {
            return DateHelper.getDate(startDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Date getCheckOutDate() {
        try {
            return DateHelper.getDate(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public void setHotelRoomId(int hotelRoomId) {
        this.hotelRoomId = hotelRoomId;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "HotelPlanInputVO{" +
                "hotelId=" + hotelId +
                ", hotelRoomId=" + hotelRoomId +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", price=" + price +
                '}';
    }
}

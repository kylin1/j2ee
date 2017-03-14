package com.kylin.vo;

import java.util.Date;

/**
 * Created by kylin on 20/02/2017.
 * All rights reserved.
 *
 * 各店入住情况
 */
public class ManagerHotelStatusVO {

    private Date date;

    private String hotelName;

    //空闲房间
    private int emptyRoom;

    //已入住/预定房间
    private int busyRoom;

    public ManagerHotelStatusVO(Date date, String hotelName, int emptyRoom, int busyRoom) {
        this.date = date;
        this.hotelName = hotelName;
        this.emptyRoom = emptyRoom;
        this.busyRoom = busyRoom;
    }

    public Date getDate() {
        return date;
    }

    public String getHotelName() {
        return hotelName;
    }

    public int getEmptyRoom() {
        return emptyRoom;
    }

    public int getBusyRoom() {
        return busyRoom;
    }

    @Override
    public String toString() {
        return "ManagerHotelStatusVO{" +
                "date=" + date +
                ", hotelName='" + hotelName + '\'' +
                ", emptyRoom=" + emptyRoom +
                ", busyRoom=" + busyRoom +
                '}';
    }
}

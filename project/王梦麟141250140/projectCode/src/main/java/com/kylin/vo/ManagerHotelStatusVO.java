package com.kylin.vo;

import com.kylin.tools.DateHelper;

import java.util.Date;

/**
 * Created by kylin on 20/02/2017.
 * All rights reserved.
 *
 * 各店入住情况
 */
public class ManagerHotelStatusVO {

    private Date date;
    private String strDate;

    private String hotelName;

    //空闲房间
    private int emptyRoom;

    //已入住/预定房间
    private int busyRoom;

    //没有计划的房间
    private int notAvail;

    public ManagerHotelStatusVO(Date date, String hotelName, int emptyRoom, int busyRoom, int notAvail) {
        this.date = date;
        this.strDate = DateHelper.getDateString(date);
        this.hotelName = hotelName;
        this.emptyRoom = emptyRoom;
        this.busyRoom = busyRoom;
        this.notAvail = notAvail;
    }

    @Override
    public String toString() {
        return "ManagerHotelStatusVO{" +
                "date=" + date +
                ", strDate='" + strDate + '\'' +
                ", hotelName='" + hotelName + '\'' +
                ", emptyRoom=" + emptyRoom +
                ", busyRoom=" + busyRoom +
                ", notAvail=" + notAvail +
                '}';
    }

    public int getNotAvail() {
        return notAvail;
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

    public String getStrDate() {
        return strDate;
    }

}

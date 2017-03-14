package com.kylin.vo;

import com.kylin.tools.DateHelper;
import com.kylin.tools.myenum.RoomType;

import java.util.Date;

/**
 * Created by kylin on 22/02/2017.
 * All rights reserved.
 *
 * 酒店已经发布的计划信息
 */
public class HotelPlanVO {

    private int roomId;

    private String room;

    private RoomType roomType;
    private String strType;

    private Date startDate;
    private Date endDate;

    private String date1;
    private String date2;


    public HotelPlanVO(int roomId, String room, RoomType roomType, Date startDate, Date endDate) {
        this.roomId = roomId;
        this.room = room;
        this.roomType = roomType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.init();
    }

    public HotelPlanVO(int hotelRoomId, String roomNumber, RoomType anEnum, String s, String s1) {
        this.roomId = hotelRoomId;
        this.room = roomNumber;
        this.roomType = anEnum;
        this.date1 = s;
        this.date2 = s1;
        this.init2();
    }

    private void init2() {
        this.strType = this.roomType.getType();
        this.startDate = DateHelper.NOW;
        this.endDate = DateHelper.NOW;
    }

    private void init() {
        this.strType = this.roomType.getType();
        this.date1 = DateHelper.getDateString(this.startDate);
        this.date2 = DateHelper.getDateString(this.endDate);
    }

    public int getRoomId() {
        return roomId;
    }

    public String getRoom() {
        return room;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
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

    @Override
    public String toString() {
        return "HotelPlanVO{" +
                "roomId=" + roomId +
                ", room='" + room + '\'' +
                ", roomType=" + roomType +
                ", strType='" + strType + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", date1='" + date1 + '\'' +
                ", date2='" + date2 + '\'' +
                '}';
    }
}

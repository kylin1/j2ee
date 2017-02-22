package com.kylin.vo;

import com.kylin.vo.myenum.RoomType;

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

    private Date startDate;
    private Date endDate;

    public HotelPlanVO(int roomId, String room, RoomType roomType, Date startDate, Date endDate) {
        this.roomId = roomId;
        this.room = room;
        this.roomType = roomType;
        this.startDate = startDate;
        this.endDate = endDate;
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
}

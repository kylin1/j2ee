package com.kylin.vo;

import com.kylin.vo.myenum.RoomType;

/**
 * Created by kylin on 22/02/2017.
 * All rights reserved.
 *
 * 输入时间地点之后找到的一个符合条件的酒店 info
 */
public class RemainRoomInfo {

    private RoomType roomType;

    private int remainNumber;

    private int pricePerNight;

    public RemainRoomInfo(RoomType roomType, int remainNumber, int pricePerNight) {
        this.roomType = roomType;
        this.remainNumber = remainNumber;
        this.pricePerNight = pricePerNight;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public int getRemainNumber() {
        return remainNumber;
    }

    public int getPricePerNight() {
        return pricePerNight;
    }
}


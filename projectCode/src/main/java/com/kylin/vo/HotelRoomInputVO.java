package com.kylin.vo;

import com.kylin.tools.myenum.RoomType;

/**
 * Created by kylin on 10/03/2017.
 * All rights reserved.
 */
public class HotelRoomInputVO {

    private String roomNumber;

    private RoomType roomType;

    private String info;

    public HotelRoomInputVO(String roomNumber, RoomType roomType, String info) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.info = info;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public String getInfo() {
        return info;
    }

    @Override
    public String toString() {
        return "HotelRoomInputVO{" +
                "roomNumber='" + roomNumber + '\'' +
                ", roomType=" + roomType +
                ", info='" + info + '\'' +
                '}';
    }
}

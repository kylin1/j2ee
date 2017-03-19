package com.kylin.vo;

import com.kylin.tools.DateHelper;
import com.kylin.tools.myenum.RoomStatus;

import java.util.Date;

/**
 * Created by kylin on 20/02/2017.
 * All rights reserved.
 *
 * 房间入住信息
 * 每日每房间入住情况与房客信息
 */
public class HotelRoomStatusVO {

    private Date date;
    private String strDate;

    //房间号
    private String roomNumber;

    private String strStatus;

    //已入住人数
    private String roomType;

    public HotelRoomStatusVO(Date date, String roomNumber, RoomStatus status,String roomType) {
        this.date = date;
        this.strDate = DateHelper.getDateString(date);
        this.roomNumber = roomNumber;
        this.strStatus = status.getType();
        this.roomType = roomType;
    }


    @Override
    public String toString() {
        return "HotelRoomStatusVO{" +
                "date=" + date +
                ", strDate='" + strDate + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", strStatus='" + strStatus + '\'' +
                ", roomType=" + roomType +
                '}';
    }

    public Date getDate() {
        return date;
    }

    public String getStrDate() {
        return strDate;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getStrStatus() {
        return strStatus;
    }

    public String getRoomType() {
        return roomType;
    }
}

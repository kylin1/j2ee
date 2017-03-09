package com.kylin.vo;

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

    //房间号
    private String roomNumber;

    //已入住人数
    private int checkedInNumber;

    public HotelRoomStatusVO(Date date, String roomNumber, int checkedInNumber) {
        this.date = date;
        this.roomNumber = roomNumber;
        this.checkedInNumber = checkedInNumber;
    }

    public Date getDate() {
        return date;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public int getCheckedInNumber() {
        return checkedInNumber;
    }

    @Override
    public String toString() {
        return "date="+date+"roomNumber="+roomNumber+"checkedInNumber="+checkedInNumber;
    }
}

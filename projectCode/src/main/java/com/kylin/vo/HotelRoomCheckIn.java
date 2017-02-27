package com.kylin.vo;

import java.util.List;

/**
 * Created by kylin on 22/02/2017.
 * All rights reserved.
 *
 * 酒店入住人员的个人信息
 */
public class HotelRoomCheckIn {

    //room
    private int roomId;

    private List<HotelGuestCheckIn> guestList;

    public HotelRoomCheckIn(int roomId, List<HotelGuestCheckIn> guestList) {
        this.roomId = roomId;
        this.guestList = guestList;
    }

    public int getRoomId() {
        return roomId;
    }

    public List<HotelGuestCheckIn> getGuestList() {
        return guestList;
    }
}

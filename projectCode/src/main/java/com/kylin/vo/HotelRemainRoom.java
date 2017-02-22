package com.kylin.vo;

import com.kylin.vo.myenum.RoomStatus;
import com.kylin.vo.myenum.RoomType;

/**
 * Created by kylin on 22/02/2017.
 * All rights reserved.
 *
 * 酒店管理人员搜索空闲房间，给客户分配
 */
public class HotelRemainRoom {

    private int roomId;

    // 房间号，401
    private String room;

    // 类型
    private RoomType type;

    private RoomStatus status;

    // 房间其他信息
    private String information;

    public HotelRemainRoom(int roomId, String room, RoomType type, RoomStatus status, String information) {
        this.roomId = roomId;
        this.room = room;
        this.type = type;
        this.status = status;
        this.information = information;
    }

    public int getRoomId() {
        return roomId;
    }

    public String getRoom() {
        return room;
    }

    public RoomType getType() {
        return type;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public String getInformation() {
        return information;
    }
}

package com.kylin.vo;

import com.kylin.tools.myenum.RoomStatus;
import com.kylin.tools.myenum.RoomType;

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
    private String strType;

    private RoomStatus status;
    private String strStatus;

    // 房间其他信息
    private String information;

    private int price;

    public HotelRemainRoom(int roomId, String room, RoomType type, RoomStatus status,
                           String information,int price) {
        this.roomId = roomId;
        this.room = room;
        this.type = type;
        this.status = status;
        this.information = information;
        this.price = price;
        this.init();
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public void setStrType(String strType) {
        this.strType = strType;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    public void setStrStatus(String strStatus) {
        this.strStatus = strStatus;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private void init() {
        this.strStatus = this.status.getType();
        this.strType = this.type.getType();
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

    public String getStrType() {
        return strType;
    }

    public String getStrStatus() {
        return strStatus;
    }

    @Override
    public String toString() {
        return "HotelRemainRoom{" +
                "roomId=" + roomId +
                ", room='" + room + '\'' +
                ", type=" + type +
                ", strType='" + strType + '\'' +
                ", status=" + status +
                ", strStatus='" + strStatus + '\'' +
                ", information='" + information + '\'' +
                '}';
    }
}

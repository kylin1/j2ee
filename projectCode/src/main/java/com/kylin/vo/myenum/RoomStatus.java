package com.kylin.vo.myenum;

/**
 * Created by kylin on 22/02/2017.
 * All rights reserved.
 */
public enum RoomStatus {

    Empty("空闲"),
    Occupied("已入住"),
    Cleaning("正在打扫"),
    NotAvailable("装修/审批");

    private String stringStatus;

    RoomStatus(String stringStatus) {
        this.stringStatus = stringStatus;
    }

    public String getType() {
        return stringStatus;
    }

}

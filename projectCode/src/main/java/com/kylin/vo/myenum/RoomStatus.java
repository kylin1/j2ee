package com.kylin.vo.myenum;

/**
 * Created by kylin on 22/02/2017.
 * All rights reserved.
 */
public enum RoomStatus {

    Empty("空闲"),
    Reserved("预定但未入住"),
    CheckedIn("已入住"),
    NotAvailable("不可用:装修/审批");

    private String stringStatus;

    RoomStatus(String stringStatus) {
        this.stringStatus = stringStatus;
    }

    public String getType() {
        return stringStatus;
    }

    public static RoomStatus getEnum(String input) {
        for (RoomStatus type : RoomStatus.values()) {
            if (type.getType().equals(input))
                return type;
        }
        return null;
    }

}

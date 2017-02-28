package com.kylin.tools.myenum;

/**
 * Created by kylin on 22/02/2017.
 * All rights reserved.
 */
public enum MemberOrderStatus {

    Canceled("已取消"),
    Reserved("预定但未入住"),
    CheckedIn("已入住");


    private String stringStatus;

    MemberOrderStatus(String stringStatus) {
        this.stringStatus = stringStatus;
    }

    public String getStringStatus() {
        return stringStatus;
    }

    public static MemberOrderStatus getEnum(String input) {
        for (MemberOrderStatus type : MemberOrderStatus.values()) {
            if (type.getStringStatus().equals(input))
                return type;
        }
        return null;
    }

    public static MemberOrderStatus getEnum(int status) {
        return MemberOrderStatus.values()[status];
    }
}

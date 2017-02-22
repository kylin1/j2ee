package com.kylin.vo.myenum;

/**
 * Created by kylin on 22/02/2017.
 * All rights reserved.
 */
public enum MemberStatus {

    NeverActivated(0),

    Activated(1),

    Expired(2);

    private Integer status;

    MemberStatus(int status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public static MemberStatus getEnum(int input) {
        for (MemberStatus type : MemberStatus.values()) {
            if (type.getStatus() == input)
                return type;
        }
        return null;
    }
}

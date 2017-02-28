package com.kylin.tools.myenum;

/**
 * Created by kylin on 22/02/2017.
 * All rights reserved.
 */
public enum MemberStatus {

    // 新用户,从未激活
    NeverActivated(0),

    // 已经激活,有效期一年,一年过后变成2
    Activated(1),

    // 一年到期,已经过期,等待激活,一旦支付则恢复1
    Expired(2),

    // 过期一年还没付钱,停止
    Stopped(3);

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

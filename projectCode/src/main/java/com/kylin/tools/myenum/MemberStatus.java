package com.kylin.tools.myenum;

/**
 * Created by kylin on 22/02/2017.
 * All rights reserved.
 */
public enum MemberStatus {

    // 新用户,从未激活
    NeverActivated("未激活"),

    // 已经激活,有效期一年,一年过后变成2
    Activated("已经激活"),

    // 一年到期,已经过期,等待激活,一旦支付则恢复1
    Expired("过期"),

    // 过期一年还没付钱,停止
    Stopped("停止");

    private String strStatus;

    MemberStatus(String strStatus) {
        this.strStatus = strStatus;
    }

    public String getStrStatus() {
        return strStatus;
    }

    public static MemberStatus getEnum(int input) {
        return MemberStatus.values()[input];
    }

    public static MemberStatus getEnum(String input) {
        for (MemberStatus type : MemberStatus.values()) {
            if (type.getStrStatus().equals(input))
                return type;
        }
        return null;
    }
}

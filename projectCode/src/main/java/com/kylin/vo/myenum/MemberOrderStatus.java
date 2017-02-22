package com.kylin.vo.myenum;

/**
 * Created by kylin on 22/02/2017.
 * All rights reserved.
 */
public enum MemberOrderStatus {

    Compelete("已成交"),
    Processing("正在处理"),
    Cancled("已取消");

    private String stringStatus;

    MemberOrderStatus(String stringStatus) {
        this.stringStatus = stringStatus;
    }

    public String getStringStatus() {
        return stringStatus;
    }
}

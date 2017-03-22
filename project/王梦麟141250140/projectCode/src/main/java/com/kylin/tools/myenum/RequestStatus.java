package com.kylin.tools.myenum;

/**
 * Created by kylin on 22/02/2017.
 * All rights reserved.
 */
public enum  RequestStatus {

    Waiting("等待审批"),
    Passed("审批通过"),
    Denied("审批拒绝"),
    Done("已经执行");

    private String stringStatus;

    RequestStatus(String stringStatus) {
        this.stringStatus = stringStatus;
    }

    public String getType() {
        return stringStatus;
    }

    public static RequestStatus getRequestStatus(int input) {
        return RequestStatus.values()[input];
    }

}

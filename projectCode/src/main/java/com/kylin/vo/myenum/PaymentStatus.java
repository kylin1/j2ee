package com.kylin.vo.myenum;

import com.kylin.tools.myenum.MemberOrderStatus;

/**
 * Created by kylin on 28/02/2017.
 * All rights reserved.
 */
public enum PaymentStatus {

    PayedToHotel("已经付款(未结算)"),
    SettledBack("已经结算");

    private String stringStatus;

    PaymentStatus(String stringStatus) {
        this.stringStatus = stringStatus;
    }

    public String getStringStatus() {
        return stringStatus;
    }

    public static PaymentStatus getEnum(String input) {
        for (PaymentStatus type : PaymentStatus.values()) {
            if (type.getStringStatus().equals(input))
                return type;
        }
        return null;
    }

    public static PaymentStatus getEnum(int status) {
        return PaymentStatus.values()[status];
    }
}

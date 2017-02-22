package com.kylin.vo.myenum;

/**
 * Created by kylin on 22/02/2017.
 * All rights reserved.
 */
public enum PaymentType {

    MemberBalance("会员卡"),
    Cash("现金结账"),
    Other("其他");

    private String stringType;

    PaymentType(String stringType) {
        this.stringType = stringType;
    }

    public String getStringType() {
        return stringType;
    }
}

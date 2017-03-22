package com.kylin.tools.myenum;

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

    public static PaymentType getEnum(String input) {
        for (PaymentType type : PaymentType.values()) {
            if (type.getStringType().equals(input))
                return type;
        }
        return null;
    }

    public static PaymentType getEnum(int input) {
        return PaymentType.values()[input];
    }
}

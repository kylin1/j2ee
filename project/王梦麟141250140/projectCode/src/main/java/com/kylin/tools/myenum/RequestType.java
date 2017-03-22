package com.kylin.tools.myenum;

/**
 * Created by kylin on 22/02/2017.
 * All rights reserved.
 */
public enum RequestType {

    OpenHotel("开店申请"),
    Management("修改信息"),
    Other("其他");

    private String stringType;

    RequestType(String stringType) {
        this.stringType = stringType;
    }

    public String getStringType() {
        return stringType;
    }

    public static RequestType getEnum(String input) {
        for (RequestType type : RequestType.values()) {
            if (type.getStringType().equals(input))
                return type;
        }
        return null;
    }

    public static RequestType getEnum(int input){
        return RequestType.values()[input];
    }
}

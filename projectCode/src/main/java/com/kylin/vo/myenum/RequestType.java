package com.kylin.vo.myenum;

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
}

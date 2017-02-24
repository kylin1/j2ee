package com.kylin.vo;

/**
 * Created by kylin on 22/02/2017.
 * All rights reserved.
 *
 * 酒店入住人员的个人信息
 */
public class HotelGuest {

    private String name;

    private String IDNum;

    public HotelGuest(String name, String IDNum) {
        this.name = name;
        this.IDNum = IDNum;
    }

    public String getName() {
        return name;
    }

    public String getIDNum() {
        return IDNum;
    }
}
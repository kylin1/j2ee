package com.kylin.vo;

/**
 * Created by kylin on 27/02/2017.
 * All rights reserved.
 */
public class HotelGuestCheckIn {

    //guest
    private String name;

    private String IDNum;

    public HotelGuestCheckIn(String name, String IDNum) {
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

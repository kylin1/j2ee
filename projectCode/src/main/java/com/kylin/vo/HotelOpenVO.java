package com.kylin.vo;

import com.kylin.tools.myenum.HotelLevel;

/**
 * Created by kylin on 10/03/2017.
 * All rights reserved.
 */
public class HotelOpenVO{

    protected int userId;

    protected String name;

    protected String location;

    protected HotelLevel type;

    public HotelOpenVO(int userId, String name, String location, HotelLevel type) {
        this.userId = userId;
        this.name = name;
        this.location = location;
        this.type = type;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public HotelLevel getType() {
        return type;
    }

}

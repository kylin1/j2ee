package com.kylin.vo;

import com.kylin.tools.myenum.HotelLevel;

/**
 * Created by kylin on 10/03/2017.
 * All rights reserved.
 */
public class HotelOpenVO{
    @Override
    public String toString() {
        return "HotelOpenVO{" +
                "hotelId=" + hotelId +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", level=" + level +
                ", hotelLevel=" + hotelLevel +
                '}';
    }

    protected int hotelId;

    protected String name;

    protected String location;

    protected int level;
    protected HotelLevel hotelLevel;

    public HotelOpenVO() {
    }

    public HotelOpenVO(int hotelId, String name, String location, int level) {
        this.hotelId = hotelId;
        this.name = name;
        this.location = location;
        this.level = level;
        this.hotelLevel = HotelLevel.getEnum(this.level);
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public HotelLevel getHotelLevel() {
        return hotelLevel;
    }

    public void setHotelLevel(HotelLevel hotelLevel) {
        this.hotelLevel = hotelLevel;
    }
}

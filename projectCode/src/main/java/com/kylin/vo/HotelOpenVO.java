package com.kylin.vo;

/**
 * Created by kylin on 10/03/2017.
 * All rights reserved.
 */
public class HotelOpenVO {

    protected int hotelId;

    protected String name;

    protected String location;

    protected int level;

    public HotelOpenVO() {
    }

    public HotelOpenVO(int hotelId, String name, String location, int level) {
        this.hotelId = hotelId;
        this.name = name;
        this.location = location;
        this.level = level;
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


    @Override
    public String toString() {
        return "HotelOpenVO{" +
                "hotelId=" + hotelId +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", level=" + level +
                '}';
    }
}

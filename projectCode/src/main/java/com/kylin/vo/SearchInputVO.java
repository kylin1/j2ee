package com.kylin.vo;

/**
 * Created by kylin on 13/03/2017.
 * All rights reserved.
 */
public class SearchInputVO {

    String location;
    String fromDate;
    String endDate;
    int roomTypeInt;
    int roomNumber;

    public SearchInputVO() {
    }

    public SearchInputVO(String location, String fromDate, String endDate, int roomTypeInt, int roomNumber) {
        this.location = location;
        this.fromDate = fromDate;
        this.endDate = endDate;
        this.roomTypeInt = roomTypeInt;
        this.roomNumber = roomNumber;
    }

    public String getLocation() {
        return location;
    }

    public String getFromDate() {
        return fromDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public int getRoomTypeInt() {
        return roomTypeInt;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setRoomTypeInt(int roomTypeInt) {
        this.roomTypeInt = roomTypeInt;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
}

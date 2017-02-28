package com.kylin.vo;

import com.kylin.tools.myenum.HotelType;

import java.util.Date;
import java.util.List;

/**
 * Created by kylin on 20/02/2017.
 * All rights reserved.
 *
 * 输入时间地点之后找到的一个符合条件的酒店 info
 */
public class SearchHotelItemVO {

    // date info
    private Date checkInDate;

    private Date checkOutDate;

    // hotel info
    private int hotelId;

    private String hotelName;

    private HotelType hotelType;

    private String hotelAddress;

    private int lowestPerNightPrice;

    // 一个符合条件的酒店 remain room
    private List<RemainRoomInfo> remainRoomNumber;

    public SearchHotelItemVO(Date checkInDate, Date checkOutDate, int hotelId, String hotelName, HotelType hotelType, String hotelAddress, int lowestPerNightPrice, List<RemainRoomInfo> remainRoomNumber) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.hotelType = hotelType;
        this.hotelAddress = hotelAddress;
        this.lowestPerNightPrice = lowestPerNightPrice;
        this.remainRoomNumber = remainRoomNumber;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public int getHotelId() {
        return hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public HotelType getHotelType() {
        return hotelType;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public int getLowestPerNightPrice() {
        return lowestPerNightPrice;
    }

    public List<RemainRoomInfo> getRemainRoomNumber() {
        return remainRoomNumber;
    }
}

package com.kylin.vo;

import com.kylin.tools.DateHelper;
import com.kylin.tools.myenum.RoomType;

import java.util.Date;

/**
 * Created by kylin on 20/02/2017.
 * All rights reserved.
 *
 * 经理搜索会员信息结果
 */
public class SearchMemberVO {

    private Date orderTime;
    private String date;

    private String hotelName;

    private RoomType roomType;
    private String strType;

    private int roomNumber;

    private int price;

    public SearchMemberVO(Date orderTime, String hotelName, RoomType roomType, int roomNumber, int price) {
        this.orderTime = orderTime;
        this.hotelName = hotelName;
        this.roomType = roomType;
        this.roomNumber = roomNumber;
        this.price = price;
        this.date = DateHelper.getDateString(orderTime);
        this.strType = roomType.getType();
    }

    public String getDate() {
        return date;
    }

    public String getStrType() {
        return strType;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public String getHotelName() {
        return hotelName;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "SearchMemberVO{" +
                "orderTime=" + orderTime +
                ", hotelName='" + hotelName + '\'' +
                ", roomType=" + roomType +
                ", roomNumber=" + roomNumber +
                ", price=" + price +
                '}';
    }
}

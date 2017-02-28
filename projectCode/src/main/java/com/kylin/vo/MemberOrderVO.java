package com.kylin.vo;

import com.kylin.tools.myenum.MemberOrderStatus;

import java.util.Date;
import java.util.List;

/**
 * Created by kylin on 20/02/2017.
 * All rights reserved.
 *
 * 会员界面一个订单历史记录
 */
public class MemberOrderVO {

    // hotel
    private String hotelName;

    // 预定日期
    private Date orderDate;

    // 出行人
    private List<String> customers;

    private Date checkInDate;

    private Date checkOutDate;

    private int totalPrice;

    private MemberOrderStatus orderStatus;

    public MemberOrderVO(String hotelName, Date orderDate, List<String> customers, Date checkInDate, Date checkOutDate, int totalPrice, MemberOrderStatus orderStatus) {
        this.hotelName = hotelName;
        this.orderDate = orderDate;
        this.customers = customers;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalPrice = totalPrice;
        this.orderStatus = orderStatus;
    }

    public String getHotelName() {
        return hotelName;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public List<String> getCustomers() {
        return customers;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public MemberOrderStatus getOrderStatus() {
        return orderStatus;
    }
}

package com.kylin.vo;

import java.util.Date;

/**
 * Created by kylin on 20/02/2017.
 * All rights reserved.
 */
public class PaymentVO {

    // hotel
    private int hotelId;

    private String hotelName;

    //会员名字
    private String memberName;

    //支付时间
    private Date payTime;

    //金额
    private int price;

    //是否已经结算
    private boolean isSettled;

    public PaymentVO(int hotelId, String hotelName, String memberAccount, Date payTime, int price, boolean isSettled) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.memberName = memberAccount;
        this.payTime = payTime;
        this.price = price;
        this.isSettled = isSettled;
    }

    public int getHotelId() {
        return hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getMemberName() {
        return memberName;
    }

    public Date getPayTime() {
        return payTime;
    }

    public int getPrice() {
        return price;
    }

    public boolean isSettled() {
        return isSettled;
    }
}

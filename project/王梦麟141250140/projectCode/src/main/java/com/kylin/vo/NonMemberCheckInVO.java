package com.kylin.vo;

/**
 * Created by kylin on 15/03/2017.
 * All rights reserved.
 */
public class NonMemberCheckInVO extends HotelCheckInTableVO {

    private String startDate;
    private String endDate;

    private int price;

    public NonMemberCheckInVO() {
    }

    @Override
    public String toString() {
        return super.toString() +
                ", NonMemberCheckInVO{" +
                "startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}

package com.kylin.vo;

import com.kylin.tools.DateHelper;
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

    private int orderId;

    // hotel
    private String hotelName;

    // 预定日期
    private Date orderDate;
    private String stringOrderDate;

    // 出行人
    private String stringCustomers;
    private List<String> customers;

    private Date checkInDate;
    private String stringCheckInDate;

    private Date checkOutDate;
    private String stringCheckOutDate;

    private int totalPrice;

    private String stringStatus;
    private MemberOrderStatus orderStatus;

    public MemberOrderVO(int orderId,String hotelName, Date orderDate, List<String> customers,
                         Date checkInDate, Date checkOutDate, int totalPrice, MemberOrderStatus orderStatus) {
        this.orderId = orderId;
        this.hotelName = hotelName;
        this.orderDate = orderDate;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalPrice = totalPrice;
        this.customers = customers;
        this.orderStatus = orderStatus;
        this.init();
    }

    private void init() {
        this.stringCustomers = this.getAllCustomer();
        this.stringStatus = this.orderStatus.getStringStatus();
        this.stringOrderDate = DateHelper.getDateString(orderDate);
        this.stringCheckInDate = DateHelper.getDateString(checkInDate);
        this.stringCheckOutDate = DateHelper.getDateString(checkOutDate);
    }

    public int getOrderId() {
        return orderId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public String getStringOrderDate() {
        return stringOrderDate;
    }

    public String getStringCheckInDate() {
        return stringCheckInDate;
    }

    public String getStringCheckOutDate() {
        return stringCheckOutDate;
    }

    public String getAllCustomer() {
        StringBuilder builder = new StringBuilder();
        for(String name:this.customers){
            builder.append(name);
            builder.append(",");
        }
        return builder.toString();
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

    public String getStringCustomers() {
        return stringCustomers;
    }

    public List<String> getCustomers() {
        return customers;
    }

    public String getStringStatus() {
        return stringStatus;
    }

    @Override
    public String toString() {
        return "MemberOrderVO{" +
                "hotelName='" + hotelName + '\'' +
                ", orderDate=" + orderDate +
                ", stringOrderDate='" + stringOrderDate + '\'' +
                ", stringCustomers='" + stringCustomers + '\'' +
                ", customers=" + customers +
                ", checkInDate=" + checkInDate +
                ", stringCheckInDate='" + stringCheckInDate + '\'' +
                ", checkOutDate=" + checkOutDate +
                ", stringCheckOutDate='" + stringCheckOutDate + '\'' +
                ", totalPrice=" + totalPrice +
                ", stringStatus='" + stringStatus + '\'' +
                ", orderStatus=" + orderStatus +
                '}';
    }
}

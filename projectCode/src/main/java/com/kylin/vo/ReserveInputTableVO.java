package com.kylin.vo;

import com.kylin.tools.DateHelper;
import com.kylin.tools.myenum.RoomType;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by kylin on 20/02/2017.
 * All rights reserved.
 * <p>
 * 会员预定酒店登记表格
 */
public class ReserveInputTableVO {

    private int userId;

    private int hotelId;

    // date info
    private Date checkInDate;
    private String strDate1;

    private Date checkOutDate;
    private String strDate2;

    // room info
    private RoomType roomType;
    private int intRoomType;

    private int roomNumber;

    // contact info
    private String contactPersonName;

    private String contactPhone;

    private String contactEmail;

    // price
    private int totalPrice;

    public ReserveInputTableVO(int userId, int hotelId, String strDate1, String strDate2, int intRoomType, int roomNumber, String contactPersonName, String contactPhone, String contactEmail, int totalPrice) {
        this.userId = userId;
        this.hotelId = hotelId;
        this.strDate1 = strDate1;
        this.strDate2 = strDate2;
        this.intRoomType = intRoomType;
        this.roomNumber = roomNumber;
        this.contactPersonName = contactPersonName;
        this.contactPhone = contactPhone;
        this.contactEmail = contactEmail;
        this.totalPrice = totalPrice;
        try {
            this.init();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void init() throws ParseException {
        this.checkInDate = DateHelper.getDate(this.strDate1);
        this.checkOutDate = DateHelper.getDate(this.strDate2);
        this.roomType = RoomType.getEnum(this.intRoomType);
    }

    public ReserveInputTableVO(int userId, int hotelId, Date checkInDate, Date checkOutDate, RoomType roomType, int roomNumber, String contactPersonName, String contactPhone, String contactEmail, int totalPrice) {
        this.userId = userId;
        this.hotelId = hotelId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.roomType = roomType;
        this.roomNumber = roomNumber;
        this.contactPersonName = contactPersonName;
        this.contactPhone = contactPhone;
        this.contactEmail = contactEmail;
        this.totalPrice = totalPrice;
    }

    public int getUserId() {
        return userId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public int getTotalPrice() {
        return totalPrice;
    }


}

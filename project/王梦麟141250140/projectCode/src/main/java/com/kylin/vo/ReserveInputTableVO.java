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

    private int memberId;

    private int hotelId;

    // date info
    private String strDate1;

    private String strDate2;

    // room info
    private int intRoomType;

    private int roomNumber;

    // contact info
    private String contactPersonName;

    private String contactPhone;

    private String contactEmail;

    // price
    private int totalPrice;

    public ReserveInputTableVO() {
    }

    public ReserveInputTableVO(int memberId, int hotelId, String strDate1, String strDate2,
                               int intRoomType, int roomNumber,
                               String contactPersonName, String contactPhone, String contactEmail, int totalPrice) {
        this.memberId = memberId;
        this.hotelId = hotelId;
        this.strDate1 = strDate1;
        this.strDate2 = strDate2;
        this.intRoomType = intRoomType;
        this.roomNumber = roomNumber;
        this.contactPersonName = contactPersonName;
        this.contactPhone = contactPhone;
        this.contactEmail = contactEmail;
        this.totalPrice = totalPrice;
    }


    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getHotelId() {
        return hotelId;
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

    public String getStrDate1() {
        return strDate1;
    }

    public String getStrDate2() {
        return strDate2;
    }

    public int getIntRoomType() {
        return intRoomType;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public void setStrDate1(String strDate1) {
        this.strDate1 = strDate1;
    }

    public void setStrDate2(String strDate2) {
        this.strDate2 = strDate2;
    }

    public void setIntRoomType(int intRoomType) {
        this.intRoomType = intRoomType;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "ReserveInputTableVO{" +
                "memberId=" + memberId +
                ", hotelId=" + hotelId +
                ", strDate1='" + strDate1 + '\'' +
                ", strDate2='" + strDate2 + '\'' +
                ", intRoomType=" + intRoomType +
                ", roomNumber=" + roomNumber +
                ", contactPersonName='" + contactPersonName + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }

    public Date getCheckInDate() {
        try {
            return DateHelper.getDate(this.strDate1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getMemberId() {
        return memberId;
    }

    public Date getCheckOutDate() {
        try {
            return DateHelper.getDate(this.strDate2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public RoomType getRoomType() {
        return RoomType.getEnum(this.intRoomType);
    }
}

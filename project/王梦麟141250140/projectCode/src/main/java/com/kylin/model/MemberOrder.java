package com.kylin.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by kylin on 17/02/2017.
 * All rights reserved.
 */
@Entity
@Table(name = "member_order")
public class MemberOrder {

    private int id;
    private int memberId;
    private int hotelId;

    private Date orderTime;
    private Date checkIn;
    private Date checkOut;

    private int roomType;
    private int roomNumber;
    private int price;

    private String contactName;
    private String contactPhone;
    private String contactEmail;

    private int status;
    private Integer isMember;
    private Integer isCash;
    private String reservedRoomString;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "memberId")
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    @Column(name = "hotelId")
    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    @Column(name = "orderTime")
    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    @Column(name = "checkIn")
    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    @Column(name = "checkOut")
    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    @Column(name = "roomType")
    public int getRoomType() {
        return roomType;
    }

    public void setRoomType(int roomType) {
        this.roomType = roomType;
    }

    @Column(name = "roomNumber")
    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Column(name = "contactName")
    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    @Column(name = "contactPhone")
    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Column(name = "isMember")
    public Integer getIsMember() {
        return isMember;
    }

    public void setIsMember(Integer isMember) {
        this.isMember = isMember;
    }

    @Column(name = "isCash")
    public Integer getIsCash() {
        return isCash;
    }

    public void setIsCash(Integer isCash) {
        this.isCash = isCash;
    }

    @Column(name = "contactEmail")
    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    @Column(name = "reservedRoomString")
    public void setReservedRoomString(String reservedRoomString) {
        this.reservedRoomString = reservedRoomString;
    }

    @Override
    public String toString() {
        return "MemberOrder{" +
                "id=" + id +
                ", memberId=" + memberId +
                ", hotelId=" + hotelId +
                ", orderTime=" + orderTime +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", roomType=" + roomType +
                ", roomNumber=" + roomNumber +
                ", price=" + price +
                ", contactName='" + contactName + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", status=" + status +
                ", isMember=" + isMember +
                ", isCash=" + isCash +
                '}';
    }

    public String getReservedRoomString() {
        return reservedRoomString;
    }
}

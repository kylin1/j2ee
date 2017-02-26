package com.kylin.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by kylin on 26/02/2017.
 * All rights reserved.
 */
@Entity
@Table(name = "hotel_room_status")
public class HotelRoomStatus {

    private int id;

    private int hotelRoomId;

    private Date date;

    private int status;

    private int price;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Column(name = "hotelRoomId")
    public int getHotelRoomId() {
        return hotelRoomId;
    }

    public void setHotelRoomId(int hotelRoomId) {
        this.hotelRoomId = hotelRoomId;
    }

    public HotelRoomStatus() {
    }

    public HotelRoomStatus(int hotelRoomId, Date date, int status, int price) {
        this.hotelRoomId = hotelRoomId;
        this.date = date;
        this.status = status;
        this.price = price;
    }
}

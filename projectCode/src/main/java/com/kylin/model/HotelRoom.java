package com.kylin.model;

import javax.persistence.*;

/**
 * Created by kylin on 17/02/2017.
 * All rights reserved.
 */
@Entity
@Table(name = "hotel_room")
public class HotelRoom {

    private int id;

    private String roomNumber;

    private int hotelId;

    private int type;

    private String information;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "type")
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Column(name = "hotelId")
    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    @Column(name = "roomNumber")
    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Column(name = "information")
    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    @Override
    public String toString() {
        return "HotelRoom{" +
                "id=" + id +
                ", roomNumber='" + roomNumber + '\'' +
                ", hotelId=" + hotelId +
                ", type=" + type +
                ", information='" + information + '\'' +
                '}';
    }
}

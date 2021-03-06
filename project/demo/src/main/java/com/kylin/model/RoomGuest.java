package com.kylin.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by kylin on 17/02/2017.
 * All rights reserved.
 */
@Entity
@Table(name = "room_guest")
public class RoomGuest {

    private int id;
    private UserOrder orderByOrderId;
    private Date date;
    private HotelRoom roomByRoomId;

    private String name;
    private String idNum;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "orderid", referencedColumnName = "id", nullable = false)
    public UserOrder getOrderByOrderId() {
        return orderByOrderId;
    }

    public void setOrderByOrderId(UserOrder orderByOrderId) {
        this.orderByOrderId = orderByOrderId;
    }

    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @ManyToOne
    @JoinColumn(name = "roomid", referencedColumnName = "id", nullable = false)
    public HotelRoom getRoomByRoomId() {
        return roomByRoomId;
    }

    public void setRoomByRoomId(HotelRoom roomByRoomId) {
        this.roomByRoomId = roomByRoomId;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "idNum")
    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }
}

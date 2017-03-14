package com.kylin.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by kylin on 17/02/2017.
 * All rights reserved.
 */
@Entity
@Table(name = "expenditure")
public class Expenditure {

    private int id;

    private Hotel hotelByHotelId;

    private Date date;

    private int price;

    @Id
    @Column(name = "id")
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    // @JoinColumn indicates that this entity is the owner of the relationship
    @JoinColumn(name = "hotelid", referencedColumnName = "id", nullable = false)
    public Hotel getHotelByHotelId() {
        return hotelByHotelId;
    }

    public void setHotelByHotelId(Hotel hotelByHotelId) {
        this.hotelByHotelId = hotelByHotelId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Expenditure{" +
                "id=" + id +
                ", hotelByHotelId=" + hotelByHotelId +
                ", date=" + date +
                ", price=" + price +
                '}';
    }
}

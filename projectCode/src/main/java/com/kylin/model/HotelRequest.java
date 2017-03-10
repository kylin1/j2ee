package com.kylin.model;

import com.kylin.tools.myenum.HotelLevel;

import javax.persistence.*;

/**
 * Created by kylin on 09/03/2017.
 * All rights reserved.
 */
@Entity
@Table(name = "hotel_cache")
public class HotelRequest {

    private int id;

    private String name;

    private String location;

    private int level;

    private int userId;

    private String phone;

    private String representative;

    // 申请的种类，开店还是修改信息
    private int type;

    // 申请的状况，是否被通过
    private int status;

    @Id
    @GeneratedValue
    @Column(name = "id")public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Column(name = "name")
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Column(name = "level")
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "representative")
    public String getRepresentative() {
        return representative;
    }

    public void setRepresentative(String representative) {
        this.representative = representative;
    }

    @Column(name = "userId")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    @Column(name = "type")
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String readDetail() {
        return "修改后的酒店信息为：" + "名称：" + name + "地点：" + location + "类别:" + HotelLevel.getEnum(this.type).getType();
    }

    @Override
    public String toString() {
        return this.readDetail();
    }
}

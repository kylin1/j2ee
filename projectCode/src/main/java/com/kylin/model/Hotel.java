package com.kylin.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by kylin on 17/02/2017.
 * All rights reserved.
 */
@Entity
@Table(name = "hotel")
public class Hotel {

    private int id;

    private String name;

    private String location;

    private int status;

    private int type;

    //一个酒店可以发出多个申请
    private Collection<Approval> approvals;
    private int userId;

    @Id
    @Column(name = "ID")public int getId() {
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

    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

//     default LAZY;
    @OneToMany(mappedBy = "hotelByHotelId", cascade = CascadeType.ALL)
    public Collection<Approval> getApprovals() {
        return approvals;
    }

    public void setApprovals(Collection<Approval> approvals) {
        this.approvals = approvals;
    }

    @Column(name = "type")
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Column(name = "userId")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}

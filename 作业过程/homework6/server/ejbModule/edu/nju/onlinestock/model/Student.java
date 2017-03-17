package edu.nju.onlinestock.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by kylin on 09/12/2016.
 * All rights reserved.
 */
@Entity
@Table(name = "student")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private String name;

    private String password;


    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}

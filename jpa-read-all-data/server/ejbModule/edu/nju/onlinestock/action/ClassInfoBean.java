package edu.nju.onlinestock.action;

import java.io.Serializable;

/**
 * Created by kylin on 26/12/2016.
 * All rights reserved.
 */
public class ClassInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private int score;

    public ClassInfoBean() {
    }

    public ClassInfoBean(int id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

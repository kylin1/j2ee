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
@Table(name = "selection")
public class Selection implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private int studentid;

    private int courseid;

    private int examtaken;

    private Integer score;

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public int getExamtaken() {
        return examtaken;
    }

    public void setExamtaken(int examtaken) {
        this.examtaken = examtaken;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}

package edu.nju.onlinestock.model;

import edu.nju.onlinestock.dao.CourseDao;
import edu.nju.onlinestock.dao.StudentDao;

import java.io.Serializable;

/**
 * Created by kylin on 09/12/2016.
 * All rights reserved.
 */
public class Selection implements Serializable {

    private int id;

    private int studentid;

    private int courseid;

    private int examtaken;

    private Integer score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void main(String[] args) {

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

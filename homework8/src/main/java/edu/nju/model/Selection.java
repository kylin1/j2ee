package edu.nju.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by kylin on 09/12/2016.
 * All rights reserved.
 */

@Entity
@Table(name="selection")
public class Selection implements Serializable {

    @Id
    private int id;

    private int studentId;

    private int courseId;

    private int examTaken;

    private Integer score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getExamTaken() {
        return examTaken;
    }

    public void setExamTaken(int examTaken) {
        this.examTaken = examTaken;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}

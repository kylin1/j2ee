package edu.nju.model;

import edu.nju.model.database.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kylin on 09/12/2016.
 * All rights reserved.
 */
public class Selection {

    private int id;

    private int studentId;

    private int courseId;

    private int examTaken;

    private int score;

    /**
     * 判断一个学生是否参加了所有的测验
     *
     * @return true(正常结果) false(有未参加的测验)
     */
    public boolean isAllExamTaken() {
        //得到学生的选课与测验情况
        List<Selection> selections = this.getSelectionOfStudent(studentId);

        for (Selection selection : selections) {
            //如果有没有参加的,则返回false
            if (selection.getExamTaken() == 0) {
                return false;
            }
        }
        //此学生参加了所有的测验
        return true;
    }

    public List<Selection> getSelectionOfStudent(int studentId) {
        List<Selection> selections = new ArrayList<>();
        try {
            //获取数据
            Connection connection = MyConnection.getConnection();
            String sql = "select * from `selection` where `stu_id` = ? ";
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, studentId);
            ResultSet result = stmt.executeQuery();

            //遍历结果集
            while (result.next()) {
                int id = result.getInt("id");
                int stuId = result.getInt("stu_id");
                int course = result.getInt("course_id");
                int isTaken = result.getInt("exam_taken");
                int score = result.getInt("score");

                Selection selection = new Selection();
                selection.setId(id);
                selection.setStudentId(stuId);
                selection.setCourseId(course);
                selection.setExamTaken(isTaken);
                selection.setScore(score);
                //添加结果
                selections.add(selection);
            }
            //关闭连接
            MyConnection.close(result, stmt, connection);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        //返回数据
        return selections;
    }

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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


}

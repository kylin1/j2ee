package edu.nju.dao.impl;

import edu.nju.dao.SelectionDao;
import edu.nju.dao.util.MyConnection;
import edu.nju.model.Selection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kylin on 09/12/2016.
 * All rights reserved.
 */
public class SelectionDaoImpl implements SelectionDao {


    @Override
    public List<Selection> getSelectionOfStudent(int studentId) {
        List<Selection> selections = new ArrayList<>();
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        ArrayList list = new ArrayList();
        try {
            connection = MyConnection.getConnection();
            String sql = "select * from `selection` where `stu_id` = ? ";
            stmt = connection.prepareStatement(sql);

            stmt.setInt(1,studentId);
            result = stmt.executeQuery();

            while (result.next()){
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

                selections.add(selection);
            }


            result.close();
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return selections;
    }
}

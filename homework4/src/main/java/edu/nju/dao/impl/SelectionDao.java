package edu.nju.dao.impl;

import edu.nju.dao.ISelectionDao;
import edu.nju.dao.util.MyConnection;
import edu.nju.model.Selection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kylin on 19/12/2016.
 * All rights reserved.
 */
public class SelectionDao implements ISelectionDao {

    private static SelectionDao dao = new SelectionDao();

    public List<Selection> getSelectionOfStudent(int studentId) {
        List<Selection> selections = new ArrayList<>();
        try {
            //获取数据
            Connection connection = MyConnection.getConnection();
            String sql = "select * from `selection` where `studentid` = ? ";
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, studentId);
            ResultSet result = stmt.executeQuery();

            //遍历结果集
            while (result.next()) {
                int id = result.getInt("id");
                int stuId = result.getInt("studentid");
                int course = result.getInt("courseid");
                int isTaken = result.getInt("examtaken");
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //返回数据
        return selections;
    }

    public static SelectionDao getInstance() {
        return dao;
    }

}

package edu.nju.dao.impl;

import edu.nju.dao.IStudentDao;
import edu.nju.dao.util.MyConnection;
import edu.nju.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by kylin on 19/12/2016.
 * All rights reserved.
 */
public class StudentDao implements IStudentDao{

    private static StudentDao dao = new StudentDao();

    public Student getStudent(String name) {
        Student student = null;
        try {
            //获取数据
            Connection connection = MyConnection.getConnection();
            String sql = "select * from `student` where `name` = ? ";
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, name);
            ResultSet result = stmt.executeQuery();

            //遍历结果集
            if (result.first()) {
                int id = result.getInt("id");
                String password = result.getString("password");
                student = new Student();
                student.setId(id);
                student.setName(name);
                student.setPassword(password);
            }
            //关闭连接
            MyConnection.close(result, stmt, connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //return result
        return student;
    }

    public static StudentDao getInstance() {
        return dao;
    }

}

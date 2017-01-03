package edu.nju.onlinestock.dao;

import edu.nju.onlinestock.dao.util.MyConnection;
import edu.nju.onlinestock.model.Student;

import javax.ejb.Stateless;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by kylin on 19/12/2016.
 * All rights reserved.
 */
@Stateless
public class StudentDaoBean implements StudentDao {

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

}

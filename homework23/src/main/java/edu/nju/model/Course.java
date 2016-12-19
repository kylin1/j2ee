package edu.nju.model;

import edu.nju.model.database.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by kylin on 09/12/2016.
 * All rights reserved.
 */
public class Course {

    private int id;

    private String name;

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

    public Course getCourse(int id){
        Course course = null;
        try {
            //获取数据
            Connection connection = MyConnection.getConnection();
            String sql = "select * from `course` where `id` = ? ";
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, id);
            ResultSet result = stmt.executeQuery();

            //遍历结果集
            while (result.next()) {
                String name = result.getString("name");
                course = new Course();
                course.setId(id);
                course.setName(name);
            }

            //关闭连接
            MyConnection.close(result, stmt, connection);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        //返回数据
        return course;
    }
}

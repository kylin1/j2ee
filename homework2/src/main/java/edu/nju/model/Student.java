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
public class Student {

    private int id;

    private String name;

    private String password;

    public boolean checkStudent() {
        Student dbStudent = this.getStudent(this.name);
        if (dbStudent == null) {
            return false;
        } else {
            return true;
        }
    }

    public boolean login() {
        assert this.password != null : "未设置password";
        Student dbStudent = this.getStudent(this.name);
        assert dbStudent != null : "学生不存在!";
        if (this.password.equals(dbStudent.getPassword())) {
            this.id = dbStudent.id;
            return true;
        } else {
            return false;
        }
    }

    private Student getStudent(String name) {
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
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        //return result
        return student;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}

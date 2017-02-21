package edu.nju.onlinestock.dao.util;

import java.sql.*;

/**
 * Created by kylin on 07/11/2016.
 * All rights reserved.
 */
public class MyConnection {

    //数据库连接地址
    private final static String URL = "jdbc:mysql://localhost:3306/j2ee" +
            "?useUnicode=true&characterEncoding=utf8";

    //用户名
    private final static String USERNAME = "root";
    //密码
    private final static String PASSWORD = "861910";

    private final static String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection(){
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);;
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void close(ResultSet rs, PreparedStatement ps, Connection conn) {
        try {
            ps.close();
            rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(ResultSet rs, PreparedStatement ps) {
        try {
            ps.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

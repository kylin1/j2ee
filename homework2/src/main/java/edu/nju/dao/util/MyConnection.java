package edu.nju.dao.util;

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

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return conn;
    }


    public static void close(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
        rs.close();
        ps.close();
        conn.close();
    }

    public static void close(ResultSet rs, PreparedStatement ps) throws SQLException {
        rs.close();
        ps.close();
    }
}

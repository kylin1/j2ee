package edu.nju.kylin.dao;

import edu.nju.kylin.dao.util.DaoHelper;
import edu.nju.kylin.dao.util.DaoHelperImpl;
import edu.nju.kylin.model.Course;

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
public class CourseDaoBean implements CourseDao{

    private static DaoHelper daoHelper=DaoHelperImpl.getBaseDaoInstance();

    public Course getCourse(int id){
        Course course = null;
        try {
            //获取数据
            Connection connection = daoHelper.getConnection();
            System.out.println("connection = "+connection==null);
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
            daoHelper.close(result, stmt, connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //返回数据
        return course;
    }

}

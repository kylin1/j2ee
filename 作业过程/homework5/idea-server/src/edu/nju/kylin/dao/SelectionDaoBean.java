package edu.nju.kylin.dao;

import edu.nju.kylin.dao.util.DaoHelper;
import edu.nju.kylin.dao.util.DaoHelperImpl;
import edu.nju.kylin.model.Selection;

import javax.ejb.Stateless;
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
@Stateless
public class SelectionDaoBean implements SelectionDao {

    private static DaoHelper daoHelper= DaoHelperImpl.getBaseDaoInstance();

    public List<Selection> getSelectionOfStudent(int studentId) {
        List<Selection> selections = new ArrayList<>();
        try {
            //获取数据
            Connection connection = daoHelper.getConnection();
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
                selection.setStudentid(stuId);
                selection.setCourseid(course);
                selection.setExamtaken(isTaken);
                selection.setScore(score);
                //添加结果
                selections.add(selection);
            }
            //关闭连接
            daoHelper.close(result, stmt, connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //返回数据
        return selections;
    }

}

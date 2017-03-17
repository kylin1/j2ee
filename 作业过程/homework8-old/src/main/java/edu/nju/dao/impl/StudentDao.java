package edu.nju.dao.impl;

import edu.nju.dao.BaseDao;
import edu.nju.dao.IStudentDao;
import edu.nju.model.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by kylin on 19/12/2016.
 * All rights reserved.
 */
@Repository
public class StudentDao implements IStudentDao {

    @Autowired
    private BaseDao baseDao;

    private static StudentDao dao = new StudentDao();

    public Student getStudent(String stuName) {
        Student student = null;

        try {
            Session session = this.baseDao.getNewSession();

            String hql = "from edu.nju.model.Student as se where se.name=?";
            Query query = session.createQuery(hql);
            query.setString(0, stuName);
            List<Student> list = query.list();

            if (list.size() == 0) {
                student = null;
            } else {
                student = list.get(0);
            }

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return student;
    }

}

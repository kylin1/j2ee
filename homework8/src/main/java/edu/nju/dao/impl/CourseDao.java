package edu.nju.dao.impl;

import edu.nju.dao.BaseDao;
import edu.nju.dao.ICourseDao;
import edu.nju.model.Course;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by kylin on 19/12/2016.
 * All rights reserved.
 */
@Repository
@Transactional
public class CourseDao implements ICourseDao {

    @Autowired
    private BaseDao baseDao;

    private static CourseDao courseDao = new CourseDao();

    public void save(Course course) {
        try {
            baseDao.save(course);
        } catch (Exception e) {

        }
    }

    public Course getCourse(int id) {
        Course course = null;

        try {
            Session session = this.baseDao.getNewSession();
            course = session.find(Course.class, id);
//            session.close();
            return course;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

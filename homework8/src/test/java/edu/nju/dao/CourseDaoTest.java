package edu.nju.dao;

import edu.nju.dao.impl.CourseDao;
import edu.nju.model.Course;
import org.junit.Test;

/**
 * Created by kylin on 21/02/2017.
 * All rights reserved.
 */
public class CourseDaoTest {

    private ICourseDao dao = new CourseDao();

    @Test
    public void test() {
        Course course = dao.getCourse(1);
        System.out.println(course.getId());
        System.out.println(course.getName());
    }
}

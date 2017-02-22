package edu.nju;

import edu.nju.dao.ICourseDao;
import edu.nju.model.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by kylin on 21/02/2017.
 * All rights reserved.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class CourseDaoTest {

    @Autowired
    private ICourseDao courseDao;

    @Test
    public void test() {
        Course course = courseDao.getCourse(2);
        System.out.println(course.getId());
        System.out.println(course.getName());
    }

    @Test
    public void save(){
        Course course = new Course();
        course.setId(222);
        course.setName("test2-22");

        courseDao.save(course);
    }
}

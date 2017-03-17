package edu.nju;

import edu.nju.dao.IStudentDao;
import edu.nju.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * Created by kylin on 10/12/2016.
 * All rights reserved.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class StudentDaoTest {

    @Autowired
    private IStudentDao dao;

    @Test
    public void test() throws IOException {
        Student student = dao.getStudent("kylin2");
        System.out.println(student.getId());
        System.out.println(student.getName());
    }

}

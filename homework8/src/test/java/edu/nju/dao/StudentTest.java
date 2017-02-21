package edu.nju.dao;

import edu.nju.dao.impl.StudentDao;
import edu.nju.model.Student;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by kylin on 10/12/2016.
 * All rights reserved.
 */
public class StudentTest {

    private IStudentDao dao = new StudentDao();

    @Test
    public void test() throws IOException {
        Student student = dao.getStudent("kylin2");
        System.out.println(student.getId());
        System.out.println(student.getName());
    }

}

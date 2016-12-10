package edu.nju.dao;

import edu.nju.dao.impl.StudentDaoImpl;
import edu.nju.model.Student;
import edu.nju.tools.CheckClass;
import org.junit.Test;

/**
 * Created by kylin on 10/12/2016.
 * All rights reserved.
 */
public class StudentTest {

    private StudentDao dao = new StudentDaoImpl();

    @Test
    public void test(){
        Student student = dao.getStudent("kylin");
        CheckClass.checkObject("Student",student);
    }

}

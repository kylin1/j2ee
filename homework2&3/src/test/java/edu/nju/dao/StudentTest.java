package edu.nju.dao;

import edu.nju.model.Student;
import org.junit.Test;

/**
 * Created by kylin on 10/12/2016.
 * All rights reserved.
 */
public class StudentTest {

    private Student dao = new Student();

    @Test
    public void test(){
        Student student = new Student();
        student.setName("kylin");
        student.setPassword("123123");

        boolean studentExists = student.checkStudent();

        System.out.println(studentExists);
    }

}

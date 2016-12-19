package edu.nju.dao;

import edu.nju.service.impl.StudentService;
import org.junit.Test;

/**
 * Created by kylin on 10/12/2016.
 * All rights reserved.
 */
public class StudentTest {

    private StudentService dao = new StudentService();

    @Test
    public void test(){
        boolean studentExists = dao.checkStudent("kylin");

        System.out.println(studentExists);
    }

}

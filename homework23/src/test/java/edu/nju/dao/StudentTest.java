package edu.nju.dao;

import edu.nju.service.impl.StudentService;
import edu.nju.tools.FileIOHelper;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by kylin on 10/12/2016.
 * All rights reserved.
 */
public class StudentTest {

    private StudentService dao = new StudentService();

    @Test
    public void test() throws IOException {
//        boolean studentExists = dao.checkStudent("kylin");
//
//        System.out.println(studentExists);

        String x = FileIOHelper.readTxtFile("web/data/counter.txt");
        System.out.println(x);
    }

}

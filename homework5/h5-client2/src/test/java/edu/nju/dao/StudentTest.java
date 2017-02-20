package edu.nju.dao;

import edu.nju.onlinestock.service.StudentService;
import edu.onlinestock.tools.FileIOHelper;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by kylin on 10/12/2016.
 * All rights reserved.
 */
public class StudentTest {

    private StudentService dao;

    @Test
    public void test() throws IOException {
//        boolean studentExists = dao.studentExists("kylin");
//
//        System.out.println(studentExists);

        String x = FileIOHelper.readTxtFile("web/data/counter.txt");
        System.out.println(x);
    }

}

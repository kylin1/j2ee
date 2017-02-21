package edu.nju.onlinestock.service;

import edu.nju.onlinestock.dao.StudentDao;
import edu.nju.onlinestock.factory.EJBFactory;
import edu.nju.onlinestock.model.Student;

import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by kylin on 19/12/2016.
 * All rights reserved.
 */
@Stateless
public class StudentServiceBean implements StudentService {

    private StudentDao dao;

    public StudentServiceBean() {
        this.dao = (StudentDao) EJBFactory
                .getEJB("ejb:/onlineStockJPAEJB/StudentDaoBean!edu.nju.onlinestock.dao.StudentDao");
    }

    public boolean studentExists(String name) {
        List studentlist = dao.getStudent(name);
        // not exists
        if (studentlist == null)
            return false;

        if (studentlist.size() < 1)
            return false;

        Student student = (Student) studentlist.get(0);
        if (student == null) {
            return false;
        } else {
            return true;
        }
    }

    public boolean login(String name, String password) {
        assert password != null : "未设置password";
        // not exists
        if (!this.studentExists(name)) {
            return false;
        } else {
            // get student
            List studentlist = dao.getStudent(name);
            Student student = (Student) studentlist.get(0);
            if (password.equals(student.getPassword())) {
                return true;
            } else {
                return false;
            }
        }

    }

}

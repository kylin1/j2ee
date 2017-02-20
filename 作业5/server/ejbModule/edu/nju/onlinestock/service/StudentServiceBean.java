package edu.nju.onlinestock.service;

import edu.nju.onlinestock.dao.StudentDao;
import edu.nju.onlinestock.factory.EJBFactory;
import edu.nju.onlinestock.model.Student;

import javax.ejb.Stateless;

/**
 * Created by kylin on 19/12/2016.
 * All rights reserved.
 */
@Stateless
public class StudentServiceBean implements StudentService{

    private StudentDao dao;

    public StudentServiceBean() {
        this.dao = (StudentDao) EJBFactory
                .getEJB("ejb:/onlineStockJPAEJB/StudentDaoBean!edu.nju.onlinestock.dao.StudentDao");
    }

    public boolean studentExists(String name) {
        Student dbStudent = dao.getStudent(name);
        if (dbStudent == null) {
            return false;
        } else {
            return true;
        }
    }

    public boolean login(String name,String password) {
        assert password != null : "未设置password";
        Student dbStudent = dao.getStudent(name);
        assert dbStudent != null : "学生不存在!";
        if (password.equals(dbStudent.getPassword())) {
            return true;
        } else {
            return false;
        }
    }

}

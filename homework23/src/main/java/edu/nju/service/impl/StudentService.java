package edu.nju.service.impl;

import edu.nju.dao.IStudentDao;
import edu.nju.factory.DaoFactory;
import edu.nju.model.Student;
import edu.nju.service.IStudentService;

/**
 * Created by kylin on 19/12/2016.
 * All rights reserved.
 */
public class StudentService implements IStudentService{

    private IStudentDao dao;

    private static IStudentService service = new StudentService();

    public StudentService() {
        this.dao = DaoFactory.getStudentDao();
    }

    public static IStudentService getInstance(){
        return service;
    }

    public boolean checkStudent(String name) {
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

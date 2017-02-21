package edu.nju.service.impl;

import edu.nju.dao.IStudentDao;
import edu.nju.model.Student;
import edu.nju.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kylin on 19/12/2016.
 * All rights reserved.
 */
@Service
public class StudentService implements IStudentService{

    @Autowired
    private IStudentDao dao;

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

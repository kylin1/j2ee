package edu.nju.dao;

import edu.nju.model.Student;

/**
 * Created by kylin on 19/12/2016.
 * All rights reserved.
 */
public interface IStudentDao {

    Student getStudent(String name);

}

package edu.nju.dao;

import edu.nju.model.Student;

/**
 * Created by kylin on 09/12/2016.
 * All rights reserved.
 */
public interface StudentDao {

    Student getStudent(String name);

}

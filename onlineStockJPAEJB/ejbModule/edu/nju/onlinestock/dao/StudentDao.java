package edu.nju.onlinestock.dao;

import edu.nju.onlinestock.model.Student;

import javax.ejb.Remote;

/**
 * Created by kylin on 19/12/2016.
 * All rights reserved.
 */
@Remote
public interface StudentDao {

    Student getStudent(String name);

}

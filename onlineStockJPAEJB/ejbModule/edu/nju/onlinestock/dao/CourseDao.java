package edu.nju.onlinestock.dao;

import edu.nju.onlinestock.model.Course;

import javax.ejb.Remote;

/**
 * Created by kylin on 19/12/2016.
 * All rights reserved.
 */
@Remote
public interface CourseDao {

    Course getCourse(int id);

}

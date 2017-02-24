package edu.nju.dao;

import edu.nju.model.Course;

/**
 * Created by kylin on 19/12/2016.
 * All rights reserved.
 */
public interface ICourseDao {

    Course getCourse(int id);

    void save(Course course);

}

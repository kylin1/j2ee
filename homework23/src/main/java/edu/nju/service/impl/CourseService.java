package edu.nju.service.impl;

import edu.nju.dao.ICourseDao;
import edu.nju.model.Course;
import edu.nju.service.ICourseService;

/**
 * Created by kylin on 19/12/2016.
 * All rights reserved.
 */
public class CourseService implements ICourseService {

    private ICourseDao dao;

    @Override
    public Course getCourse(int id) {
        return this.dao.getCourse(id);
    }
}

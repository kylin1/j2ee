package edu.nju.service.impl;

import edu.nju.dao.ICourseDao;
import edu.nju.model.Course;
import edu.nju.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kylin on 19/12/2016.
 * All rights reserved.
 */
@Service
public class CourseService implements ICourseService {

    @Autowired
    private ICourseDao dao;

    @Override
    public Course getCourse(int id) {
        return this.dao.getCourse(id);
    }

}

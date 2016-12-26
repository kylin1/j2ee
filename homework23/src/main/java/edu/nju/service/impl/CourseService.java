package edu.nju.service.impl;

import edu.nju.dao.ICourseDao;
import edu.nju.factory.DaoFactory;
import edu.nju.model.Course;
import edu.nju.service.ICourseService;

/**
 * Created by kylin on 19/12/2016.
 * All rights reserved.
 */
public class CourseService implements ICourseService {

    private ICourseDao dao;

    private static ICourseService service = new CourseService();

    public CourseService() {
        this.dao = DaoFactory.getCourseDao();
    }

    public static ICourseService getInstance(){
        return service;
    }

    @Override
    public Course getCourse(int id) {
        return this.dao.getCourse(id);
    }

}

package edu.nju.onlinestock.dao;

import edu.nju.onlinestock.model.Course;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by kylin on 19/12/2016.
 * All rights reserved.
 */
@Stateless
public class CourseDaoBean implements CourseDao {

    @PersistenceContext
    // Entities are managed by the entity manager.
    protected EntityManager em;

    public Course getCourse(int id) {
        //The EntityManager.find method is used to look up entities
        // in the data store by the entity’s primary key.
        Course course = em.find(Course.class, id);
        return course;
    }

}

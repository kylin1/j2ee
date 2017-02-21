package edu.nju.dao.impl;

import edu.nju.dao.ICourseDao;
import edu.nju.model.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by kylin on 19/12/2016.
 * All rights reserved.
 */
public class CourseDao implements ICourseDao {


    private static CourseDao courseDao = new CourseDao();


    public Course getCourse(int id) {
        Course course = null;

        try {
            Configuration config = new Configuration().configure();

            // add entity class
            config.addAnnotatedClass(Course.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
            SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
            Session session = sessionFactory.openSession();

            Transaction tx = session.beginTransaction();
            course = session.find(Course.class, id);
            tx.commit();

            session.close();
            sessionFactory.close();
            return course;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return course;
    }

    public static ICourseDao getInstance() {
        return courseDao;
    }
}

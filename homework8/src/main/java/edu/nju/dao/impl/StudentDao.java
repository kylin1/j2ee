package edu.nju.dao.impl;

import edu.nju.dao.IStudentDao;
import edu.nju.model.Course;
import edu.nju.model.Selection;
import edu.nju.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.util.List;


/**
 * Created by kylin on 19/12/2016.
 * All rights reserved.
 */
public class StudentDao implements IStudentDao {

    private static StudentDao dao = new StudentDao();

    public Student getStudent(String stuName) {
        Student student = null;

        try {
            Configuration config = new Configuration().configure();

            // add entity class
            config.addAnnotatedClass(Student.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
            SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
            Session session = sessionFactory.openSession();

            String hql = "from edu.nju.model.Student as se where se.name=?";
            Query query = session.createQuery(hql);
            query.setString(0, stuName);
            List<Student> list = query.list();

            if (list.size() == 0) {
                student = null;
            } else {
                student = list.get(0);
            }

            session.close();
            sessionFactory.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return student;
    }

    public static StudentDao getInstance() {
        return dao;
    }

}

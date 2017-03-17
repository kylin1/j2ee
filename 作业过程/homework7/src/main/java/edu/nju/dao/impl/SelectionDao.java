package edu.nju.dao.impl;

import edu.nju.dao.ISelectionDao;
import edu.nju.model.Course;
import edu.nju.model.Selection;
import edu.nju.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kylin on 19/12/2016.
 * All rights reserved.
 */
public class SelectionDao implements ISelectionDao {

    private static SelectionDao dao = new SelectionDao();

    public List<Selection> getSelectionOfStudent(int studentId) {
        List<Selection> selections = new ArrayList<>();

        try {
            Configuration config = new Configuration().configure();

            // add entity class
            config.addAnnotatedClass(Selection.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
            SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
            Session session = sessionFactory.openSession();

            String hql = "from edu.nju.model.Selection as se where se.studentId=" + studentId;
            Query query = session.createQuery(hql);
            selections = query.list();

            session.close();
            sessionFactory.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //返回数据
        return selections;
    }

    public static SelectionDao getInstance() {
        return dao;
    }

}

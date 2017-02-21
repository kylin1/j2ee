package edu.nju.dao.impl;

import edu.nju.dao.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by kylin on 21/02/2017.
 * All rights reserved.
 */
@Repository
public class BaseDaoImpl implements BaseDao {
    /**
     * Autowired 自动装配 相当于get() set()
     */
    @Autowired
    protected SessionFactory sessionFactory;

    public Session getNewSession() {
        return sessionFactory.openSession();
    }

    public void save(Object bean) {
        try {
            Session session = getNewSession();
            Transaction tx = session.beginTransaction();
            session.save(bean); //保存Entity到数据库中
            tx.commit();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

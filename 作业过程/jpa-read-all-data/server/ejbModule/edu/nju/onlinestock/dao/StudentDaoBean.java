package edu.nju.onlinestock.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by kylin on 19/12/2016.
 * All rights reserved.
 */
@Stateless
public class StudentDaoBean implements StudentDao {

    @PersistenceContext
    protected EntityManager em;

    public List getStudent(String name) {
        try {
            Query query = em.createQuery("from Student s where s.name=name");
            List list = query.getResultList();
            em.clear();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

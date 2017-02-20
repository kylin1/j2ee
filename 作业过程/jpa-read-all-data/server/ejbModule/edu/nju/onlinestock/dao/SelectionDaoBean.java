package edu.nju.onlinestock.dao;

import edu.nju.onlinestock.model.Selection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kylin on 19/12/2016.
 * All rights reserved.
 */
@Stateless
public class SelectionDaoBean implements SelectionDao {

    @PersistenceContext
    protected EntityManager em;

    public List getSelectionOfStudent(int studentid) {
        try {
            //test comment
            Query query = em.createQuery("from Selection s where s.studentid=studentid");
            List list = query.getResultList();
            em.clear();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

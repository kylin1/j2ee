package edu.nju.dao.impl;

import edu.nju.dao.BaseDao;
import edu.nju.dao.ISelectionDao;
import edu.nju.model.Selection;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kylin on 19/12/2016.
 * All rights reserved.
 */
@Repository
public class SelectionDao implements ISelectionDao {

    @Autowired
    private BaseDao baseDao;

    private static SelectionDao dao = new SelectionDao();

    public List<Selection> getSelectionOfStudent(int studentId) {
        List<Selection> selections = new ArrayList<>();

        try {
            Session session = this.baseDao.getNewSession();

            String hql = "from edu.nju.model.Selection as se where se.studentId=" + studentId;
            Query query = session.createQuery(hql);
            selections = query.list();

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //返回数据
        return selections;
    }

}

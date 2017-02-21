package edu.nju.onlinestock.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class StockDaoBean implements StockDao {

    @PersistenceContext
    protected EntityManager em;

    public List find() {

        return null;
    }


}

package edu.nju.dao;

import org.hibernate.Session;

/**
 * Created by kylin on 21/02/2017.
 * All rights reserved.
 */
public interface BaseDao {

    void save(Object bean);

    Session getNewSession();
}

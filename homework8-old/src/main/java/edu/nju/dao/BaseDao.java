package edu.nju.dao;

import org.hibernate.Session;

import java.util.List;

/**
 * Created by kylin on 21/02/2017.
 * All rights reserved.
 */


public interface BaseDao {

    public Session getSession();

    public Session getNewSession();

    public void flush();

    public void clear() ;

    public Object load(Class c, String id) ;


    public List getAllList(Class c) ;

    public Long getTotalCount(Class c) ;

    public void save(Object bean) ;

    public void update(Object bean) ;

    public void delete(Object bean) ;

    public void delete(Class c, String id) ;

    public void delete(Class c, String[] ids) ;
}

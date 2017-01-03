package edu.nju.onlinestock.dao;

import edu.nju.onlinestock.dao.util.MyConnection;
import edu.nju.onlinestock.model.Student;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by kylin on 19/12/2016.
 * All rights reserved.
 */
@Stateless
public class StudentDaoBean implements StudentDao {

    @PersistenceContext
    protected EntityManager em;

    public Student getStudent(String name) {
        try {
            Query query = em.createQuery("from Student s where s.name=name");
            Student student = (Student) query.getSingleResult();
            em.clear();
            return student;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

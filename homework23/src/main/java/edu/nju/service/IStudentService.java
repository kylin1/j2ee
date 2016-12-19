package edu.nju.service;

/**
 * Created by kylin on 19/12/2016.
 * All rights reserved.
 */
public interface IStudentService {

    boolean checkStudent(String name);

    boolean login(String name,String password);
}

package edu.nju.onlinestock.service;

import javax.ejb.Remote;

/**
 * Created by kylin on 19/12/2016.
 * All rights reserved.
 */
@Remote
public interface StudentService {

    boolean studentExists(String name);

    boolean login(String name,String password);
}

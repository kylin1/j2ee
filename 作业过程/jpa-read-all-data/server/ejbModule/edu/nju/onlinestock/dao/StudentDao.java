package edu.nju.onlinestock.dao;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by kylin on 19/12/2016.
 * All rights reserved.
 */
@Remote
public interface StudentDao {

    List getStudent(String name);

}

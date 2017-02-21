package edu.nju.kylin.service;

import javax.ejb.Remote;
import java.io.Serializable;

/**
 * Created by kylin on 19/12/2016.
 * All rights reserved.
 */
@Remote
public interface StudentService extends Serializable {

    boolean studentExists(String name);

    boolean login(String name, String password);
}

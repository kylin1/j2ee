package edu.nju.kylin.dao;

import javax.ejb.Remote;
import java.io.Serializable;
import java.util.List;

/**
 * Created by kylin on 19/12/2016.
 * All rights reserved.
 */
@Remote
public interface SelectionDao extends Serializable {

    List getSelectionOfStudent(int studentid);

}

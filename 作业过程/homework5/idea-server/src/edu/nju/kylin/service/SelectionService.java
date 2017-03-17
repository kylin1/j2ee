package edu.nju.kylin.service;


import edu.nju.kylin.model.Selection;

import javax.ejb.Remote;
import java.io.Serializable;
import java.util.List;

/**
 * Created by kylin on 19/12/2016.
 * All rights reserved.
 */
@Remote
public interface SelectionService extends Serializable {

    boolean isAllExamTaken(String studentName);

    List<Selection> getSelectionOfStudent(String studentName);
}

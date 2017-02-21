package edu.nju.onlinestock.service;

import edu.nju.onlinestock.model.Selection;

import java.util.List;
import javax.ejb.Remote;

/**
 * Created by kylin on 19/12/2016.
 * All rights reserved.
 */
@Remote
public interface SelectionService {

    boolean isAllExamTaken(String studentName);

    List getSelectionOfStudent(String studentName);
}

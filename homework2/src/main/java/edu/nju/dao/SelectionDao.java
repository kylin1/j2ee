package edu.nju.dao;

import edu.nju.model.Selection;

import java.util.List;

/**
 * Created by kylin on 09/12/2016.
 * All rights reserved.
 */
public interface SelectionDao {

    List<Selection> getSelectionOfStudent(int studentId);

}

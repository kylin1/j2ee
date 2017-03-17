package edu.nju.service;

import edu.nju.model.Selection;

import java.util.List;

/**
 * Created by kylin on 19/12/2016.
 * All rights reserved.
 */
public interface ISelectionService {

    boolean isAllExamTaken(String studentName);

    List<Selection> getSelectionOfStudent(String studentName);
}

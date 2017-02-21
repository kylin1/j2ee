package edu.nju.dao;

import edu.nju.model.Selection;
import edu.nju.tools.CheckClass;
import org.junit.Test;

import java.util.List;

/**
 * Created by kylin on 09/12/2016.
 * All rights reserved.
 */
public class SelectionDaoTest {

    private Selection dao = new Selection();

    @Test
    public void test() {
        Selection selection = new Selection();
        selection.setStudentId(2);
        boolean isNormal = selection.isAllExamTaken();
        System.out.println(isNormal);
    }

    @Test
    public void test2() {
        Selection selection = new Selection();
        List<Selection> selections = selection.getSelectionOfStudent(2);
        for (Selection selection2:selections){
            CheckClass.checkObject("Selection",selection2);
        }
    }
}

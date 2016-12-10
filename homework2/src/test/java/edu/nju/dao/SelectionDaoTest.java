package edu.nju.dao;

import edu.nju.model.Selection;
import org.junit.Test;

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
}

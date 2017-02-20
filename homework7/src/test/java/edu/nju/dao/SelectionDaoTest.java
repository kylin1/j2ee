package edu.nju.dao;

import edu.nju.model.Selection;
import edu.nju.service.impl.SelectionService;
import edu.nju.tools.CheckClass;
import org.junit.Test;

import java.util.List;

/**
 * Created by kylin on 09/12/2016.
 * All rights reserved.
 */
public class SelectionDaoTest {

    private SelectionService dao = new SelectionService();

    @Test
    public void test() {
        boolean isNormal = dao.isAllExamTaken("kylin2");
        System.out.println(isNormal);
    }

    @Test
    public void test2() {
        List<Selection> selections = dao.getSelectionOfStudent("kylin2");
        for (Selection selection2:selections){
            CheckClass.checkObject("Selection",selection2);
        }
    }
}

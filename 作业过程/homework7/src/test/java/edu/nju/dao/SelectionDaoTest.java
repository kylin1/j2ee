package edu.nju.dao;

import edu.nju.dao.impl.SelectionDao;
import edu.nju.model.Selection;
import edu.nju.tools.CheckClass;
import org.junit.Test;

import java.util.List;

/**
 * Created by kylin on 09/12/2016.
 * All rights reserved.
 */
public class SelectionDaoTest {

    private ISelectionDao dao = new SelectionDao();

    @Test
    public void test2() {
        List<Selection> selections = dao.getSelectionOfStudent(1);
        for (Selection selection2:selections){
            CheckClass.checkObject("Selection",selection2);
        }
    }
}

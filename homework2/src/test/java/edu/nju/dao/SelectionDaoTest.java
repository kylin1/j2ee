package edu.nju.dao;

import edu.nju.dao.impl.SelectionDaoImpl;
import edu.nju.model.Selection;
import org.junit.Test;

import java.util.List;

/**
 * Created by kylin on 09/12/2016.
 * All rights reserved.
 */
public class SelectionDaoTest {

    private SelectionDao dao = new SelectionDaoImpl();

    @Test
    public void test() {
        List<Selection> selections = dao.getSelectionOfStudent(1);
        System.out.println(selections.size());
    }
}

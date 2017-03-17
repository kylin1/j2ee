package edu.nju;

import edu.nju.dao.ISelectionDao;
import edu.nju.model.Selection;
import edu.nju.tools.CheckClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by kylin on 09/12/2016.
 * All rights reserved.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class SelectionDaoTest {

    @Autowired
    private ISelectionDao dao;

    @Test
    public void test2() {
        List<Selection> selections = dao.getSelectionOfStudent(1);
        for (Selection selection2:selections){
            CheckClass.checkObject("Selection",selection2);
        }
    }
}

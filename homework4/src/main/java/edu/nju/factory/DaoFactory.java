package edu.nju.factory;

import edu.nju.dao.ICourseDao;
import edu.nju.dao.ISelectionDao;
import edu.nju.dao.IStudentDao;
import edu.nju.dao.StockDao;
import edu.nju.dao.impl.CourseDao;
import edu.nju.dao.impl.SelectionDao;
import edu.nju.dao.impl.StockDaoImpl;
import edu.nju.dao.impl.StudentDao;

/**
 * Created by kylin on 26/12/2016.
 * All rights reserved.
 */
public class DaoFactory {

    private static StockDao stockDao;

    public static ICourseDao getCourseDao() {
        return CourseDao.getInstance();
    }

    public static ISelectionDao getSelectionDao() {
        return SelectionDao.getInstance();
    }

    public static IStudentDao getStudentDao() {
        return StudentDao.getInstance();
    }

    public static StockDao getStockDao() {
        return StockDaoImpl.getInstance();
    }
}

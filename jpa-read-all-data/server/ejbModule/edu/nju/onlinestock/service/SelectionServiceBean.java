package edu.nju.onlinestock.service;

import edu.nju.onlinestock.dao.SelectionDao;
import edu.nju.onlinestock.dao.StudentDao;
import edu.nju.onlinestock.factory.EJBFactory;
import edu.nju.onlinestock.model.Selection;
import edu.nju.onlinestock.model.Student;

import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by kylin on 19/12/2016.
 * All rights reserved.
 */
@Stateless
public class SelectionServiceBean implements SelectionService {

    private SelectionDao dao;

    private StudentDao studentDao;

    public SelectionServiceBean() {
        this.dao = (SelectionDao) EJBFactory
                .getEJB("ejb:/onlineStockJPAEJB/SelectionDaoBean!edu.nju.onlinestock.dao.SelectionDao");
        this.studentDao = (StudentDao) EJBFactory
                .getEJB("ejb:/onlineStockJPAEJB/StudentDaoBean!edu.nju.onlinestock.dao.StudentDao");
    }

    /**
     * 判断一个学生是否参加了所有的测验
     *
     * @return true(正常结果) false(有未参加的测验)
     */
    @Override
    public boolean isAllExamTaken(String studentName) {
        //得到学生的选课与测验情况
        List<Selection> selections = this.getSelectionOfStudent(studentName);

        for (Selection selection : selections) {
            //如果有没有参加的,则返回false
            if (selection.getExamtaken() == 0) {
                return false;
            }
        }
        //此学生参加了所有的测验
        return true;
    }

    @Override
    public List getSelectionOfStudent(String studentName) {
        List studentlist = studentDao.getStudent(studentName);
        assert studentlist.size() == 1 : "size is not one!!";
        Student student = (Student) studentlist.get(0);
        int id = student.getId();
        return this.dao.getSelectionOfStudent(id);
    }


}

package edu.nju.onlinestock.service;

import edu.nju.onlinestock.dao.SelectionDao;
import edu.nju.onlinestock.dao.StudentDao;
import edu.nju.onlinestock.factory.EJBFactory;
import edu.nju.onlinestock.model.Selection;
import edu.nju.onlinestock.model.Student;

import javax.ejb.Stateless;
import java.util.ArrayList;
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

    public static void main(String[] args) {
        SelectionService service = (SelectionService) EJBFactory.getEJB(
                "ejb:/onlineStockJPAEJB/SelectionServiceBean!edu.nju.onlinestock.service.SelectionService");
        boolean x = service.isAllExamTaken("kylin2");
        System.out.println(x);

        List<Selection> list = service.getSelectionOfStudent("kylin2");
        System.out.println(list.size());
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
        List<Student> studentlist = (List<Student>)studentDao.getStudent(studentName);
        // not exists
        if(studentlist == null || studentlist.size() == 0){
            return new ArrayList();
            // find one student
        }else {
            Student student = studentlist.get(0);
            int id = student.getId();
            return this.dao.getSelectionOfStudent(id);
        }

    }


}

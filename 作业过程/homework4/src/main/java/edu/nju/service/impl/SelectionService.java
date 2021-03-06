package edu.nju.service.impl;

import edu.nju.dao.ISelectionDao;
import edu.nju.dao.IStudentDao;
import edu.nju.factory.DaoFactory;
import edu.nju.model.Selection;
import edu.nju.model.Student;
import edu.nju.service.ISelectionService;

import java.util.List;

/**
 * Created by kylin on 19/12/2016.
 * All rights reserved.
 */
public class SelectionService implements ISelectionService {

    private ISelectionDao dao;

    private IStudentDao studentDao;

    private static ISelectionService service = new SelectionService();

    public SelectionService() {
        this.dao = DaoFactory.getSelectionDao();
        this.studentDao = DaoFactory.getStudentDao();
    }

    public static ISelectionService getInstance(){
        return service;
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
            if (selection.getExamTaken() == 0) {
                return false;
            }
        }
        //此学生参加了所有的测验
        return true;
    }

    @Override
    public List<Selection> getSelectionOfStudent(String studentName) {
        Student student = studentDao.getStudent(studentName);
        return this.dao.getSelectionOfStudent(student.getId());
    }


}

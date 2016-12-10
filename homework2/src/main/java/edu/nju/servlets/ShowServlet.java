package edu.nju.servlets;

import edu.nju.dao.SelectionDao;
import edu.nju.dao.StudentDao;
import edu.nju.dao.impl.SelectionDaoImpl;
import edu.nju.dao.impl.StudentDaoImpl;
import edu.nju.model.Selection;
import edu.nju.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by zhouxiaofan on 2016/12/8.
 */

@WebServlet("/show")
public class ShowServlet extends HttpServlet {

    private StudentDao studentDao = new StudentDaoImpl();
    private SelectionDao selectionDao = new SelectionDaoImpl();

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        processRequest(req, res);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse res) throws IOException {
        //获取参数
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        //登录并获取学生信息
        Student student = studentDao.getStudent(login);

        //未知的学生(账号不存在),错误界面
        if(student == null){

        }

        //验证密码,密码错误
        String dbPassword = student.getPassword();
        if(!password.equals(dbPassword)){

        }

        int id = student.getId();
        //根据学生是否参加所有测验返回不同界面
        boolean isNormal = this.isAllExamTaken(id);
        //标准界面
        if(isNormal){

            //警告界面
        }else{

        }

    }

    /**
     * 判断一个学生是否参加了所有的测验
     *
     * @param studentId 学生ID
     * @return true(正常结果) false(有未参加的测验)
     */
    private boolean isAllExamTaken(int studentId){
        //得到学生的选课与测验情况
        List<Selection> selections = selectionDao.getSelectionOfStudent(studentId);

        for (Selection selection:selections){
            //如果有没有参加的,则返回false
            if(selection.getExamTaken() == 0){
                return false;
            }
        }
        //此学生参加了所有的测验
        return true;
    }
}

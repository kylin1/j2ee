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
import java.io.PrintWriter;
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
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        Student student = studentDao.getStudent(login);

//        int id = student.getId();

        List<Selection> selections = selectionDao.getSelectionOfStudent(2);

        PrintWriter pw = res.getWriter();
        for (Selection selection:selections){
            pw.println(selection.getCourseId());
        }

    }
}

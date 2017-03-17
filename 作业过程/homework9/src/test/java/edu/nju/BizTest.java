package edu.nju;

import edu.nju.model.Course;
import edu.nju.model.Selection;
import edu.nju.service.ICourseService;
import edu.nju.service.ISelectionService;
import edu.nju.service.IStudentService;
import edu.nju.tools.CheckClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by kylin on 21/02/2017.
 * All rights reserved.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class BizTest {

    @Autowired
    private ICourseService courseService;

    @Autowired
    private ISelectionService selectionService;

    @Autowired
    private IStudentService studentService;

    @Test
    public void testCourse() {
        Course course = this.courseService.getCourse(1);
        System.out.println(course.getId());
        System.out.println(course.getName());
    }

    @Test
    public void testSelection() {
        List<Selection> selections = this.selectionService.getSelectionOfStudent("kylin2");
        for (Selection selection2:selections){
            CheckClass.checkObject("Selection",selection2);
        }
    }

    @Test
    public void testStudent() {
        boolean x = this.studentService.login("kylin2","123123");
        System.out.println(x);
    }
}

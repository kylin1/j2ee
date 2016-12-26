package edu.nju.factory;

import edu.nju.service.ICourseService;
import edu.nju.service.ISelectionService;
import edu.nju.service.IStudentService;
import edu.nju.service.impl.CourseService;
import edu.nju.service.impl.SelectionService;
import edu.nju.service.impl.StudentService;

/**
 * Created by kylin on 26/12/2016.
 * All rights reserved.
 */
public class ServiceFactory {

    public static IStudentService getStudentService() {
        return StudentService.getInstance();
    }

    public static ICourseService getCourseService() {
        return CourseService.getInstance();
    }

    public static ISelectionService getSelectionService() {
        return SelectionService.getInstance();
    }

}

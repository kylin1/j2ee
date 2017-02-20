package edu.nju.onlinestock.action;

import edu.nju.onlinestock.factory.EJBFactory;

/**
 * Created by kylin on 20/02/2017.
 * All rights reserved.
 */
public class Test {

    public static void main(String[] args) {
//
//        StudentDao dao3 = (StudentDao) EJBFactory.getEJB("ejb:/onlineStockJPAEJB/StudentDaoImpl!edu.nju.onlinestock.dao.StudentDao");
//        Student s = dao3.getStudent("kylin");
//        System.out.println(s.getId());
//        System.out.println(s.getPassword());

        HelloWorld hello = (HelloWorld) EJBFactory
                .getEJB("ejb:/HelloWorldEJB/HelloWorldBean!edu.nju.session.stateless.HelloWorld");
        if (hello != null)
            System.out
                    .println("Obtained a remote stateless session bean helloBean for invocation");
        System.out.println(hello.SayHello("Mary3333"));
    }
}

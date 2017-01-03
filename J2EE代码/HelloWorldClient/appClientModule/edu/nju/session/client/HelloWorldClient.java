package edu.nju.session.client;

import edu.nju.onlinestock.service.StudentService;
import edu.nju.session.factory.EJBFactory;
import edu.nju.session.stateless.HelloWorld;

public class HelloWorldClient {

	public static void main(String[] args) {
		// ejb:<app-name>/<module-name>/<distinct-name>/<bean-name>
		// !<fully-qualified-classname-of-the-remote-interface>
		
		//module-name name of the .jar


//		HelloWorld hello = (HelloWorld) EJBFactory
//				.getEJB("ejb:/HelloWorldEJB/HelloWorldBean!edu.nju.session.stateless.HelloWorld");
//		if (hello != null)
//			System.out
//					.println("Obtained a remote stateless session bean helloBean for invocation");
//		System.out.println(hello.SayHello("Mary3333"));

		// test my ejb components
		StudentService studentService = (StudentService) EJBFactory
	    			.getEJB("ejb:/onlineStockJPAEJB/StudentServiceBean!edu.nju.onlinestock.service.StudentService");
	    	
		boolean x = studentService.studentExists("kylin2");
		System.out.println(x);
	}

}

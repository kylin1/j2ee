package edu.nju.session.callbacks;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.interceptor.InvocationContext;


public class CountCallbacks {
	private int x=0,y=0; 

	@PostConstruct
	public void construct(InvocationContext ctx) {
		System.out.println("cb:construct()");
	}

	@PostActivate
	public void activate(InvocationContext ctx) {
		System.out.println("cb:activate()" + x++);
	}

	@PrePassivate
	public void passivate(InvocationContext ctx) {
		System.out.println("cb:passivate()" + y++);
	}

	@PreDestroy
	public void destroy(InvocationContext ctx) {
		System.out.println("cb:destroy()");
	}
}

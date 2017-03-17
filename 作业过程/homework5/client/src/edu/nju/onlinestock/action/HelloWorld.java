package edu.nju.onlinestock.action;

import javax.ejb.Remote;

@Remote
public interface HelloWorld {
	public String SayHello(String name);
}

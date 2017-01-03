package edu.nju.session.client;

import edu.nju.session.factory.EJBFactory;
import edu.nju.session.stateful.MyAccount;

public class MyAccountClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyAccount A=(MyAccount)EJBFactory.getEJB("ejb:/EJBExamples/MyAccountBean!edu.nju.session.stateful.MyAccount?stateful");
		System.out.println("调用A.Add()的结果是："+A.Add(1, 1));
		System.out.println("调用A.getResult()的结果是："+A.getResult());
		System.out.println("====================================");
		MyAccount B=(MyAccount)EJBFactory.getEJB("ejb:/EJBExamples/MyAccountBean!edu.nju.session.stateful.MyAccount?stateful");
		System.out.println("调用B.Add()的结果是："+B.Add(1, 1));
		System.out.println("调用B.getResult()的结果是："+B.getResult());


	}

}

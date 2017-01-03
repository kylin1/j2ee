package edu.nju.session.client;

import edu.nju.session.factory.EJBFactory;
import edu.nju.session.stateful.MyAccount;

public class MyAccountClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyAccount A=(MyAccount)EJBFactory.getEJB("ejb:/EJBExamples/MyAccountBean!edu.nju.session.stateful.MyAccount?stateful");
		System.out.println("����A.Add()�Ľ���ǣ�"+A.Add(1, 1));
		System.out.println("����A.getResult()�Ľ���ǣ�"+A.getResult());
		System.out.println("====================================");
		MyAccount B=(MyAccount)EJBFactory.getEJB("ejb:/EJBExamples/MyAccountBean!edu.nju.session.stateful.MyAccount?stateful");
		System.out.println("����B.Add()�Ľ���ǣ�"+B.Add(1, 1));
		System.out.println("����B.getResult()�Ľ���ǣ�"+B.getResult());


	}

}

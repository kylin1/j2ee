package edu.nju.session.stateful;

import javax.ejb.Stateful;

import edu.nju.session.stateful.MyAccount;

/**
 * Session Bean implementation class MyAccountBean
 */
@Stateful
public class MyAccountBean implements MyAccount {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public MyAccountBean() {
		// TODO Auto-generated constructor stub
	}

	private int total = 0;
	private int addresult = 0;

	public int Add(int a, int b) {
		addresult = a + b;
		return addresult;
	}

	public int getResult() {
		total += addresult;
		return total;
	}

}

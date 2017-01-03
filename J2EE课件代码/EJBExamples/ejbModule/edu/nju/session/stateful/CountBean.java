package edu.nju.session.stateful;


import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.interceptor.Interceptors;

import edu.nju.session.callbacks.CountCallbacks;
import edu.nju.session.stateful.Count;


/**
 * Session Bean implementation class Count
 */
@Stateful
@Interceptors({CountCallbacks.class})
public class CountBean implements Count {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int val; 
    /**
     * Default constructor. 
     */
    public CountBean() {
        // TODO Auto-generated constructor stub
    }

	public int count() {
		System.out.println("count()");
		return ++val;

	}

	@Remove
	public void remove() {
		System.out.println("remove()");
		
	}

	public void set(int val) {
		this.val=val;
		System.out.println("set()");
		
	}
	

}

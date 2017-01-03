package edu.nju.session.client;


import edu.nju.session.factory.EJBFactory;
import edu.nju.session.stateful.Count;




public class CountClient {
	public static final int noOfClients=3;

	/**
	 * @param args
	 * @throws NamingException 
	 */
	public static void main(String[] args)  {
		Count count[] = new Count[noOfClients];
		int countVal = 0;
		System.out.println("Instantiating Beans ...");
		for (int i = 0; i < noOfClients; i++) {
			count[i] = (Count) EJBFactory.getEJB("ejb:/EJBExamples/CountBean!edu.nju.session.stateful.Count?stateful");
			count[i].set(countVal);
			countVal = count[i].count();
			System.out.println(countVal);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Calling count() on Beans ...");
		for (int i = 0; i < noOfClients; i++) {
			countVal = count[i].count();
			System.out.println(countVal);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i < noOfClients; i++) {
			count[i].remove();
			// At the end of the life cycle, the client invokes a method
			// annotated @Remove, and the EJB container calls the method
			// annotated @PreDestroy. The bean¡¯s instance is then ready for
			// garbage collection.
		}

	}

}

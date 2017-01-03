package edu.nju.session.stateful;
import java.io.Serializable;

import javax.ejb.Remote;

@Remote
public interface MyAccount extends Serializable {
	public int Add(int a, int b);
	public int getResult();
	}

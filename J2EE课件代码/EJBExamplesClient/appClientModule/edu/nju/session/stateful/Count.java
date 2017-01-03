package edu.nju.session.stateful;
import java.io.Serializable;


import javax.ejb.Remote;

@Remote
public interface Count  extends Serializable{
	public int count();
	public void set(int val);
	public void remove();

}

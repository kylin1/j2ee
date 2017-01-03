package edu.nju.onlinestock.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "accounttbl")
public class Account implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private String accountid;
    private String name;
    private double balance;

    @Id
    public String getAccountid() {
        return accountid;
    }

    @Column(nullable = false, length = 50)
    public String getName() {
        return name;
    }

    @Column(nullable = false)
    public double getBalance() {
        return balance;
    }

    public void setAccountid(String accountid) {
        this.accountid = accountid;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}

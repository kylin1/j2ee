package edu.nju.onlinestock.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: Stock
 *
 */
@Entity
@Table(name="stock")
public class Stock implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public Stock() {
		super();
	}

	private int id;
	private String companyName;
	private String type;
	private double price;
	private Date date;
	
	private Set<User> users = new HashSet<User>();



	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(
			//The name of the join table.
			//Defaults to the concatenated names of the two associated primary entity tables, 
			// separated by an underscore.
			name="mystock",
			
			//joinColumns写的都是本表在中间表的外键名称
			joinColumns=
			@JoinColumn(name="stockid", referencedColumnName="id"),
			
			// inverseJoinColumns写的是另一个表在中间表的外键名称
			inverseJoinColumns=
			@JoinColumn(name="userid", referencedColumnName="id")
			)
	public Set<User> getUsers(){
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users=users;
		}
	
	@Id
	public int getId() {
		return id;
	}	
	public void setId(int string) {
		this.id = string;
	}

	public String getCompanyName() {
		return companyName;
	}	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public String getType() {
		return type;
	}	
	public void setType(String type) {
		this.type = type;
	}
	
	public double getPrice() {
		return price;
	}	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Date getDate() {
		return date;
	}	
	public void setDate(Date date) {
		this.date = date;
	}
}

package edu.nju.onlinestock.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	//不为持久字段和属性指定@Column注释，将假定到同名字段和属性的数据库列的默认映射
	private String userid;
	private String name;
	private String password;
	private Date birthday;
	private String phone;
	private String email;
	private String bankid;
	private double account;
	private Set<Stock> stocks = new HashSet<Stock>();

	@Id
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	// the non-owning side must use the mappedBy element of the ManyToMany annotation to 
	// specify the relationship field or property of the owning side.
	
	// mappedBy=The field that owns the relationship. 
	// Required unless the relationship is unidirectional. 单向的 
	@ManyToMany(mappedBy="users")
	public Set<Stock> getStocks(){
		return stocks;
	}
	public void setStocks(Set<Stock> stocks) {
		this.stocks=stocks;
	}

	public double getAccount() {
		return account;
	}
	public void setAccount(double account) {
		this.account = account;
	}
	public String getBankid() {
		return bankid;
	}
	public void setBankid(String bankid) {
		this.bankid = bankid;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
		System.out.println(userid+"  user model");
	}
	public void setIdByDate()
	{
		Calendar datetime=Calendar.getInstance();
		this.id=datetime.getTimeInMillis();
	}
}

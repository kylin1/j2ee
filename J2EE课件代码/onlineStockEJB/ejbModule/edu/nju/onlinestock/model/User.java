package edu.nju.onlinestock.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;

public class User implements Serializable
{
	private Long id;
	private String userid;
	private String name;
	private String passwordOne;
	private String passwordTwo;
	private Date birthday;
	private String phone;
	private String email;
	private String bankid;
	private double account;
	
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getPasswordOne() {
		return passwordOne;
	}
	public void setPasswordOne(String passwordOne) {
		this.passwordOne = passwordOne;
	}
	public String getPasswordTwo() {
		return passwordTwo;
	}
	public void setPasswordTwo(String passwordTwo) {
		this.passwordTwo = passwordTwo;
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

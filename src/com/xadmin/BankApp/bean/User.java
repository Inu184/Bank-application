package com.xadmin.BankApp.bean;

public class User {
	private String username;
	private String password;
	private String email;
	private int balance;
	private int ssn;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public User(String username, String password, String email, int balance, int ssn) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.balance = balance;
		this.ssn = ssn;
	}
	public User(String username, String password, String email, int balance) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.balance = balance;
	}
	
	
}

package com.domain;

import java.util.Map;

public class User {
	private String username;
	private int age;
	
	private Account account;
	
	private Map attrMap;	//{height=193,weight=160}
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, int age) {
		super();
		this.username = username;
		this.age = age;
	}

	
	public User(String username, int age, Account account) {
		super();
		this.username = username;
		this.age = age;
		this.account = account;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Map getAttrMap() {
		return attrMap;
	}

	public void setAttrMap(Map attrMap) {
		this.attrMap = attrMap;
	}
	
	
}

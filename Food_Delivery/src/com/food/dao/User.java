package com.food.dao;

import java.util.List;

public class User {

	private String userName;
	private String password;
	private int[] loc;
	public int[] getLoc() {
		return loc;
	}
	public void setLoc(int[] loc) {
		this.loc = loc;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String userName,String password,int[] loc){
		this.userName = userName;
		this.password = password;
		this.loc = loc;
	}
	
}

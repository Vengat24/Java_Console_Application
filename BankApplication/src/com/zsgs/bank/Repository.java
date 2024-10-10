package com.zsgs.bank;

import java.util.ArrayList;
import java.util.List;

public class Repository {

	static Repository repository;
	List<User> userList;
	private Repository() {
		userList = new ArrayList<>();
	}
	public static Repository getInstance() {
		if(repository == null) {
			repository = new Repository();
		}
		return repository;
	}
	public void addUser(User user) {
		userList.add(user);
	}
	
	String encrypt(String pass) {
		 char newPass[] = pass.toCharArray();
		 for(int i=0;i<pass.length();i++) {
			 newPass[i] = (char) (newPass[i]+1);
		 }
		 return new String(newPass);
	 }
	public List<User> getUserList() {
		return userList;
	}
}

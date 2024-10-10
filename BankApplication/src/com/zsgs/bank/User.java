package com.zsgs.bank;

import java.util.Scanner;

public class User {
	
	private String userName;
	private String password;
	
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
	User(){
		Repository repository = Repository.getInstance();
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter Your Name : ");
		userName = scanner.nextLine();
		System.out.print("Enter Password : ");
		password = repository.encrypt(scanner.next());
		System.out.print("Confirm Password : ");
		String confirmPassword = repository.encrypt(scanner.next());
		
		if(!password.equals(confirmPassword)) {
			System.out.println("Password is Miss Matched .. Try Again Later!");
		}else {
			repository.addUser(this);
		}	
	}
	 
	
}

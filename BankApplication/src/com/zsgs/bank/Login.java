package com.zsgs.bank;

import java.util.List;
import java.util.Scanner;

public class Login {
	
	private String userName;
	private String password;
	Login(){
		Repository repository = Repository.getInstance();
		List<User> userList = repository.getUserList();
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter Your Name : ");
		userName = scanner.nextLine();
		if(validateUserName(userList)) {
			System.out.print("Enter Your Password : ");
			password = repository.encrypt(scanner.next());
			if(validatePassword(userList)) {
				System.out.println("Welcome "+ userName);
				Account account = new Account();
			}else {
				System.out.println("Incorrect Password");
			}
		}else {
			System.out.println("Invalid User Name");
		}
		
		
		
	}
	private boolean validatePassword(List<User> userList) {
		for(User user : userList) {
			if(user.getUserName().equals(userName) && user.getPassword().equals(password)) {
				return true;
			}
		}
		
		return false;
	}
	private boolean validateUserName(List<User> userList) {
		
		
		for(User user : userList) {
			if(user.getUserName().equals(userName)) {
				return true;
			}
		}
		return false;
	}
}

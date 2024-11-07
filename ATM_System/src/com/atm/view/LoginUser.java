package com.atm.view;

import java.util.Scanner;

import com.atm.dto.AtmDto;
import com.atm.dto.Transaction;
import com.atm.dto.User;

public class LoginUser {
	int id;
	User loggedUser;
	String pin;
	AtmDto atm;
	LoginUser(AtmDto atm){
		this.atm = atm;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.print("Enter Your Id : ");
			id = scanner.nextInt();
			System.out.println("Enter Your Pin : ");
			pin = scanner.next();
			if(checkUser(id,pin)) {
				System.out.println("No User Found Try Again!");
			}else {
				System.out.println("User Logged in Successfully");
				break;
			}
		}while(true);
		
		
		int ch = 0;
		while(ch>=0) {
			System.out.println("1)Check Balance  2)Withdraw Money  3)Transfer Money  4)Mini Statement");
			System.out.print("Enter Your Choice : ");
			ch = scanner.nextInt();
			switch(ch) {
			case 4: 
				for(Transaction transaction :  loggedUser.getTransaction()) {
					if(transaction != null)
						System.out.println(transaction);
				}
			case 1: 
				System.out.println("Available Balance : "+ loggedUser.getBalance());
				break;
			case 2:
				loggedUser.withdrawMoney();
				break;
			case 3:
				loggedUser.transferMoney();
				break;
			
			default :
				System.out.println("User Logged Out!");
				ch = -1;
			}
		}
		
	}
	private boolean checkUser(int id, String pin){
		for(User user : atm.getUserList()) {
			if(user.getId() == id && user.getPin().equals(pin)) {
				loggedUser = user;
				return false;
			}
		}
		return true;
	}

}

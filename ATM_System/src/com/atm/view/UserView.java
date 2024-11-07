package com.atm.view;

import java.util.Scanner;

import com.atm.dto.AtmDto;
import com.atm.dto.User;

public class UserView {
	String name= "";
	String pin ="";
	int amount;
	AtmDto atm = AtmDto.getAtm();
	Scanner scanner = new Scanner(System.in);
	UserView(){
		System.out.print("Enter Your Name : ");
		name = scanner.next();
		while(pin.length() <8 || pin.length()>16) {
			System.out.print("Create New Pin : ");
			pin = scanner.next();
		}
		while(amount < 1000) {
			System.out.print("Deposit Money minimum 1000 : ");
			amount = scanner.nextInt();
		}
	}
	public User createUser() {
		User user = new User(name,pin,amount,this);
		System.out.println("New User Created! Your Id : "+ user.getId());
		return user;
	}
	public int getWithDrawMoney() {
		System.out.println("Enter Money to Withdraw : ");
		return scanner.nextInt();
	}
	public User getReciever() {
		int recId ;
		User rec = null;
		while(rec == null) {
			System.out.print("Enter Reciever Id to Transfer Money : ");
			recId = scanner.nextInt();
			rec = checkRec(recId);
		}
		return rec;
	}
	private User checkRec(int id) {
		for(User user : atm.getUserList()) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	public int getTransferMoney() {
		System.out.println("Enter Money to Transfer : ");
		return scanner.nextInt();
	}

}

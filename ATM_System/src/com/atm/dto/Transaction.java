package com.atm.dto;

public class Transaction {

	String type;
	int Amount;
	User user;
	
	public Transaction(String type, int amt) {
		this.type = type;
		this.Amount = amt;
	}

	public Transaction(String type, int amt, User user) {
		this.type = type;
		this.Amount = amt;
		this.user =  user; 
	}
	
	@Override
	public String toString() {
		return type+" "+Amount+" "+ (user!=null ? user.getName(): " ");
	}
}

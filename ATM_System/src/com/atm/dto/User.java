package com.atm.dto;

import com.atm.view.UserView;

public class User {
	private static int idGen=1;
	private String name;
	private String pin;
	private int id;
	private int balance;
	private Transaction[] transaction;
	private UserView userview;
	public User(String name, String pin, int balance,UserView userview) {
		super();
		this.id = idGen++;
		this.name = name;
		this.pin = pin;
		this.balance = balance;
		transaction = new Transaction[5];
		this.userview = userview;
	}
	@Override
	public String toString() {
		return id+" "+name+" "+pin+" "+balance;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance += balance;
	}
	public Transaction[] getTransaction() {
		return transaction;
	}
	public void setTransaction(Transaction[] transaction) {
		this.transaction = transaction;
	}
	public void withdrawMoney() {
		int withdrawamt;
		do {
			withdrawamt = userview.getWithDrawMoney();
		}while(balance < withdrawamt);
		if(AtmDto.checkBalance(withdrawamt)) {
			int note[] = AtmDto.debitMoney(withdrawamt);
			if( note == null) {
				System.out.println("Invlid Money Entered");
				return;
			}
			transaction[0] = new Transaction("WithDrawl",withdrawamt);
			balance -= withdrawamt;
			System.out.printf("Take Your Cash : Hundred : %d Five Hundred : %d Thousand : %d \n",note[0],note[1],note[2]);
			System.out.println("Withdrawl Successfull!");
		}else {
			System.out.println("Withdrawl Failed Due to Less Amount in Atm");
		}
			
	}
	public void transferMoney() {
		if(balance < 500) {
			System.out.println("Insufficient Balance");
			return;
		}
		User rec = userview.getReciever();
		int transferamt;
		do {
			transferamt = userview.getTransferMoney();
		}while(balance < transferamt);
		
		moveTransaction();
		transaction[0] = new Transaction("Debited",transferamt,rec);
		balance -= transferamt;
		
		rec.moveTransaction();
		rec.transaction[0] =  new Transaction("Credited",transferamt,rec);
		rec.setBalance(transferamt);
		
		System.out.println("Transaction Successfull");
	}
	private void moveTransaction() {
		for(int i=transaction.length-1;i>0;i--) {
			transaction[i] = transaction[i-1];
		}
	}
	
	
}

package com.zsgs.bus;

import java.util.Date;
import java.util.Scanner;

public class Passenger {
	private String passengerName;
	private int age;
	private long phoneNo;
	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	
	Passenger(){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Your Name : ");
		passengerName = scanner.nextLine();
		System.out.print("Enter Your Age : ");
		age  = scanner.nextInt();
		System.out.print("Enter Your Phone Number : ");
		phoneNo = scanner.nextLong();
		Repository.getInstance().getPassengerList().add(this);
	}
}

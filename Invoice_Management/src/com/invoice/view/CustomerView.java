package com.invoice.view;

import java.util.Scanner;

import com.invoice.dto.Customer;
import com.invoice.dto.Repository;

public class CustomerView {
	String name;
	String address;
	long mobileNo;
	int cusId;
	Scanner scanner = new Scanner(System.in);
	Repository repo = Repository.getInstance(); 
	CustomerView(){
		System.out.print("Enter Your Name : ");
		name = scanner.next();
		System.out.print("Enter Address : ");
		address = scanner.next();
		System.out.print("Enter Mobile No : ");
		mobileNo = scanner.nextLong();
		Customer customer = new Customer(name,address,mobileNo);
		repo.addCustomer(customer);
		cusId = customer.getCusId();
		System.out.println("Your Customer id is "+ cusId);
	}

}

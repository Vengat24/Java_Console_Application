package com.emp.view;

import java.util.Scanner;

import com.emp.viewmodel.AddEmpViewModel;

public class AddEmpView {
	public String name;
	public int age;
	public String des;
	public String dept;
	public String mgr;
	Scanner scanner = new Scanner(System.in);
	public AddEmpView() {
		System.out.print("Enter Your Name : ");
		name = scanner.next();
		System.out.print("Enter Your Age : ");
		age = scanner.nextInt();
		System.out.print("Enter Your Destination  ");
		des = scanner.next();
		System.out.print("Enter Your Department : ");
		dept = scanner.next();
		System.out.print("Enter Reporting Manager Name : ");
		mgr = scanner.next();
		AddEmpViewModel addEmp = new AddEmpViewModel(this);

	}

}

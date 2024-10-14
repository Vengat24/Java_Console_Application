package com.food.screen;

import java.util.Scanner;

import com.food.viewmodel.SignUpViewModel;

public class SignUpView {
	Scanner scanner = new Scanner(System.in);
	public void addUser(){
		System.out.println("User Type : 1)Admin  2)Customer  3)Delivery Agent");
		System.out.print("Enter your choice : ");
		int ch = scanner.nextInt();
		System.out.println("------------------------------------------");
		new SignUpViewModel().addUser(ch);
	}
}

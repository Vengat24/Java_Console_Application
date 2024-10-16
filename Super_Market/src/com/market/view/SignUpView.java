package com.market.view;

import java.io.IOException;
import java.util.Scanner;

import com.market.viewmodel.SignUpViewModel;

public class SignUpView {
	private String name;
	private String password;
	SignUpView() throws IOException{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Your Name : ");
		name = scanner.next();
		System.out.print("Enter Your Password : ");
		password = scanner.next();
		System.out.print("Seller(1) or Buyer(0) : ");
		int isSeller = scanner.nextInt();
		new SignUpViewModel(name,password,isSeller);
	}
}

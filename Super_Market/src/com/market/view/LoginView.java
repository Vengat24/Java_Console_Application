package com.market.view;

import java.io.IOException;
import java.util.Scanner;

import com.market.viewmodel.LoginViewModel;

public class LoginView {
	private String name;
	private String password;
	LoginView() throws IOException{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Your Name : ");
		name = scanner.next();
		System.out.print("Enter Your Password : ");
		password = scanner.next();
		new LoginViewModel(name,password);
	}
}

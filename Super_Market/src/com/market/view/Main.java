package com.market.view;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("1)SignUp  2)Login");
			int ch = scanner.nextInt();
			switch(ch) {
			case 1:
				new SignUpView();
				break;
			case 2:
				new LoginView();
				break;
			default : 
				System.out.println("Thnak You!");
				System.exit(0);
			}
		}
	}
}

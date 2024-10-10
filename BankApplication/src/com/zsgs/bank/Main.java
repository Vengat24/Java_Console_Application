package com.zsgs.bank;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int ch;
		while(true) {
			System.out.println("1.SignUp 2.Login ");
			ch = scanner.nextInt();
			switch(ch) {
			case 1:
				User user = new User();
				break;
			case 2:
				Login loggedUser = new Login();
				break;
			}
		}

	}

}

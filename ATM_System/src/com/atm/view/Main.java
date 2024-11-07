package com.atm.view;

import java.util.Scanner;

import com.atm.dto.AtmDto;
import com.atm.dto.User;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int ch;
		AtmDto atm = AtmDto.getAtm();
		while(true) {
			System.out.println("1)Feed Money  2)Display User  3)SignUp User  4)User Login");
			System.out.print("Enter Your Choice : ");
			ch = scanner.nextInt();
			switch(ch) {
				case 1:
					atm.loadMoney();
					break;
				case 2:
					for(User user : atm.getUserList()) {
						System.out.println(user);
					}
					break;
				case 3:
					UserView newUser = new UserView();
					atm.getUserList().add(newUser.createUser());
					break;
				case 4:
					LoginUser loggedUser = new LoginUser(atm);
					
					break;
				default:
					System.out.println("Thank You!");
					System.exit(0);
			}
		}
	}

}

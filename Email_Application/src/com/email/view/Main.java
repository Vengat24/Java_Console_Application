package com.email.view;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("1)Send Mail  2)Delete Mail  3)Edit Mail  4)Display Mail  5)Search Mail");
			System.out.print("Enter Your Choice : ");
			int ch = scanner.nextInt();
			switch(ch) {
			case 1:
				new MailView();
				break;
			case 2:
				 new DeleteMailView();
				 break;
			case 3:
				 new EditMailView();
				 break;
			case 4:
				 new PrintMailView();
				 break;
			case 5:
				 new SearchMail();
				 break;
			default : 
				System.out.println("Thank you!");
				System.exit(0);
			}
		}
		
	}
}
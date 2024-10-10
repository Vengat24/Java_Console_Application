package com.zsgs.taxi;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int ch;
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("Call Taxi Reservation ");
			System.out.println("----------------------");
			System.out.println(" 1)Book Taxi \n 2)Display Taxi \n 3)Exit");
			System.out.println("----------------------");
			System.out.print("Enter your Choice : ");
			ch = scanner.nextInt();
			
			switch(ch) {
			case 1:
				Booking book = new Booking();
				break;
			case 2:
				Repository.getInstance().displayTaxi();
				break;
			default :
				System.out.println("-----------------------------------------------------");
				System.out.println("Thank you visit Again...!");
				System.out.println("-----------------------------------------------------");
				System.exit(0);
			}
		}
		

	}

}

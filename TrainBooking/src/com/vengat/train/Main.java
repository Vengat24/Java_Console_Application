package com.vengat.train;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int ch = 0;
		while(true) {
			System.out.println("Train Booking System ");
			System.out.println("----------------------");
			System.out.println(" 1)Book Ticket\n 2)Cancel Ticket\n 3)Display Confirmed Tickets\n 4)Display RAC Tickets\n 5)Display Waiting List\n 6)Exit");
			System.out.println("----------------------");
			System.out.print("Enter Your Choice : ");
			ch = scanner.nextInt();
			System.out.println("----------------------");
			switch(ch) {
			case 1:
				BookTickets book = new BookTickets();
				break;
			case 2:
				CancelTickets cancel = new CancelTickets();
				break;
			case 3:
				Repository.getInstance().displayBookedTickets();
				break;
			case 4:
				Repository.getInstance().displayRacTickets();
				break;
			case 5:
				Repository.getInstance().displayWaitingList();
				break;
			default :
				System.out.println("Thank you Visit Again!");
				System.out.println("----------------------");
				System.exit(0);
			}
		}
		
	}

}

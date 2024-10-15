package com.flight.screen;

import java.util.Scanner;

import com.flight.viewmodel.FlightViewModel;

public class Main {

	public static void main(String[] args) {
		int ch = 0;
		Scanner scanner = new Scanner(System.in);
		FlightViewModel.loadFlight();
		while(true) {
			System.out.println("------------------------------------------------");
			System.out.println("Flight Reservation System");
			System.out.println("1)Book Flight  2)Display Flight  3)Cancel Flight");
			System.out.println("------------------------------------------------");
			System.out.print("Enter Your Choice : ");
			ch = scanner.nextInt();
			switch(ch) {
			case 1:
				BookingView book = new BookingView();
				break;
			case 2:
				FlightView.displayFlight();
				break;
			case 3:
				CancelView cancel = new CancelView();
				break;
			default :
				System.exit(0);
			}
		}
	}

}

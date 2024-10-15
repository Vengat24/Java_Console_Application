package com.flight.screen;

import java.util.Scanner;

import com.flight.viewmodel.CancelViewModel;

public class CancelView {
	private String name;
	private String flightName;
	public CancelView(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("------------------------------------------------");
		System.out.print("Enter Your Name : ");
		name = scanner.next();
		System.out.print("Enter Flight Name : ");
		flightName = scanner.next();
		new CancelViewModel(name,flightName);
	}
	public static void invalidPassenger(String name) {
		System.out.println("------------------------------------------------");
		System.out.println("Invalid Passenger Name "+ name);
		new CancelView();
	}
	public static void invalidFlightName(String flightName) {
		System.out.println("------------------------------------------------");
		System.out.println("Invalid Fligt Name "+ flightName + " Try Another Flight Name");
		new CancelView();
	}
	public static void cancelSuccess() {
		System.out.println("------------------------------------------------");
		System.out.println("Ticket Canceled Successfully!");
	}

}

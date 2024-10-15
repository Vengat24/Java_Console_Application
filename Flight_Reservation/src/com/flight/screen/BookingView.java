package com.flight.screen;

import java.util.Scanner;

import com.flight.viewmodel.BookingViewModel;

public class BookingView {
	private String name;
	private String flightName;
	private int noOfTickets;
	public BookingView(){
		System.out.println("------------------------------------------------");
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Your Name : ");
		name = scanner.next();
		FlightView.displayFlightName();
		System.out.print("Enter Flight Name : ");
		flightName = scanner.next();
		System.out.print("Enter No of Tickets : ");
		noOfTickets = scanner.nextInt();
		new BookingViewModel(name,flightName,noOfTickets);
	}
	public static void bookingSuccess() {
		System.out.println("------------------------------------------------");
		System.out.println("Ticket Booked Successfully!");	
	}
	public static void ticketFilled(String flightName) {
		System.out.println("------------------------------------------------");
		System.out.println("Sorry! Tickets are Filled in " +flightName + " Flight Try Another Flight");
		new BookingView();		
	}
	public static void invalidFlightName(String flightName) {
		System.out.println("------------------------------------------------");
		System.out.println("Invalid Fligt Name "+ flightName + " Try Another Flight Name");
		new BookingView();
	}


}

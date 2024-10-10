package com.zsgs.bus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Cancelation {
	
	private String passengerName;
	Date date;
	Cancelation(){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Your Name : ");
		passengerName = scanner.nextLine();
		
        if(checkPassenger()) {
        	System.out.print("Enter date (dd-mm-yyyy): ");
        	String dateInput = scanner.next();
        	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        	try {
        		date = formatter.parse(dateInput);
        	} catch (ParseException e) {
        		e.printStackTrace();
        	}
        	cancel();
        }else {
        	System.out.println("Sorry No Passenger is Found!");
        }
	}
	private void cancel() {
		List<Booking> bookedList = Repository.getInstance().getBookedList();
		for(Booking booked : bookedList) {
			if(booked.getDate().equals(date) && booked.getPassenger().getPassengerName().equals(passengerName)) {
				bookedList.remove(booked);
				System.out.println("Ticket Canceled Successfully!");
				return;
			}
		}
		System.out.println("No Booking is Found!");
		
	}
	private boolean checkPassenger() {
		List<Passenger> passengerList = Repository.getInstance().getPassengerList();
		for(Passenger passenger : passengerList) {
			if(passenger.getPassengerName().equals(passengerName)) {
				return true;
			}
		}
		return false;
	}
	
}

package com.zsgs.bus;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Bus bus1 = new Bus(1,true,2);
		Bus bus2 = new Bus(2,false,2);
		Bus bus3 = new Bus(3,true,2);
		Bus bus4 = new Bus(4,false,2);
		Repository.getInstance().getBusList().addAll(Arrays.asList(bus1, bus2, bus3, bus4));
		int ch = 0;
		Scanner scanner= new Scanner(System.in);
		while(true) {
			System.out.println("--------------------------------------------");
			System.out.println("Bus Ticket Reservation ");
			System.out.println("1.Book Tickets  2.Display Booking  3.Cancel Ticket  4.Exit");
			System.out.println("--------------------------------------------");
			System.out.print("Enter Your Choice : ");
			ch = scanner.nextInt();
			System.out.println("--------------------------------------------");
			switch(ch) {
			case 1:
				Booking book = new Booking();
				if(book.bookTicket()) {
					Repository.getInstance().getBookedList().add(book);
					System.out.println("Ticket Booked Successfully!");
				}else {
					System.out.println("Sorry Unable to Book Ticket!");
				}
				break;
			case 2:
				List<Booking> bookedList = Repository.getInstance().getBookedList();
				if(bookedList.size() == 0) {
					System.out.println("No data Found to display");
					System.out.println("--------------------------------------------");
					break;
				}
				for(Booking booked : bookedList) {
					Passenger passenger = booked.getPassenger();
					System.out.println("Passenger Name : "+ passenger.getPassengerName() +" \nPhone Number : "+passenger.getPhoneNo()+" \nBus Number : "+ booked.getBus().getBusNo() +" \nTravel Date : "+booked.getDate());
					System.out.println("--------------------------------------------");
				}
				break;
			case 3:
				new Cancelation();
				break;
			default:
				System.out.println("Thank you Visit Again!");
				System.out.println("--------------------------------------------");
				System.exit(ch);
				
			}
		}

	}

}

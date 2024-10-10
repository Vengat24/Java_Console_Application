package com.zsgs.bus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Booking {
	private Bus bus;
	private Date date;
	private Passenger passenger;

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}


	Booking() {
		passenger = new Passenger();
		Scanner scanner = new Scanner(System.in);
		System.out.println("--------------------------------------------");
		System.out.println("1.Chennai - Madurai \n2.Chennai - Salem \n3.Chennai - Theni \n4.Chennai - Erode");
		System.out.println("--------------------------------------------");
		while (true) {
			System.out.print("Enter BusNo : ");
			int busNo = scanner.nextInt();
			bus = Repository.getInstance().getBus(busNo);
			if (bus == null) {
				System.out.println("Invalid Bus No ");
			} else {
				break;
			}
		}

        System.out.print("Enter date (dd-mm-yyyy): ");
        String dateInput = scanner.next();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        try {
			date = formatter.parse(dateInput);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	boolean bookTicket() {
		List<Bus> busList = Repository.getInstance().getBusList();
		List<Booking> bookedList = Repository.getInstance().getBookedList();
		int capacity = 0;
		for (Bus buses : busList) {
			if (buses.equals(bus)) {
				capacity = buses.getCapacity();
			}
		}

		int booked = 0;
		for (Booking book : bookedList) {
			if (book.date.equals(date) && book.bus.getBusNo() == this.bus.getBusNo()) {
				booked++;
			}
		}
		return booked < capacity;

	}

}

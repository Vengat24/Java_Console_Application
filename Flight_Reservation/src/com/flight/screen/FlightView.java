package com.flight.screen;

import java.util.List;

import com.flight.dto.Flight;
import com.flight.dto.Passenger;
import com.flight.dto.Repository;

public class FlightView {
	static Repository repository = Repository.getInstance();
	public static void displayFlightName() {
		List<Flight> flightList = repository.getFlightList();
		for(Flight flight : flightList) {
			System.out.println(flight.getFlightName() +" "+ flight.getAvailableSeat());
		}
	}
	public static void displayFlight() {
		System.out.println("------------------------------------------------");
		List<Flight> flightList = repository.getFlightList();
		for(Flight flight : flightList) {
			System.out.println("------------------------");
			System.out.println(flight.getFlightName() +" "+ flight.getAvailableSeat()+" "+flight.getTotal());
			List<Passenger> passengerList = flight.getPassengerList();
			for(Passenger passenger : passengerList) {
				System.out.println(passenger.getName() +" "+ passenger.getNoOfTickets());
			}
		}
		
	}

}

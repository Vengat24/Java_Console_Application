package com.flight.viewmodel;

import java.util.List;

import com.flight.dto.Flight;
import com.flight.dto.Repository;

public class FlightViewModel {

	public static void loadFlight() {
		Repository repository = Repository.getInstance();
		List<Flight> flightList = repository.getFlightList();
		Flight flight1 = new Flight("Ganga");
		flightList.add(flight1);
		Flight flight2 = new Flight("Yamuna");
		flightList.add(flight2);
		Flight flight3 = new Flight("Kaveri");
		flightList.add(flight3);
	}

}

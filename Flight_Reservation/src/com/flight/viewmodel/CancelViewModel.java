package com.flight.viewmodel;

import java.util.List;

import com.flight.dto.Flight;
import com.flight.dto.Passenger;
import com.flight.dto.Repository;
import com.flight.screen.CancelView;

public class CancelViewModel {

	Repository repository = Repository.getInstance();
	public CancelViewModel(String name, String flightName) {
		List<Flight> flightList = repository.getFlightList();
		for(Flight flight : flightList) {
			if(flight.getFlightName().equals(flightName)) {
					List<Passenger> passengerList = flight.getPassengerList();
					for(Passenger passenger : passengerList) {
						if(passenger.getName().equals(name)) {
							flight.setAvailableSeat(flight.getAvailableSeat() + passenger.getNoOfTickets());
							flight.getPassengerList().remove(passenger);
							flight.setTotal(flight.getTotal() - passenger.getTicketPrice());
							flight.setTicketPrice(flight.getTicketPrice()-200);
							CancelView.cancelSuccess();
							return;
						}
					}
					CancelView.invalidPassenger(flightName);
					return;
					
				}
			}
		CancelView.invalidFlightName(flightName);
	}
}

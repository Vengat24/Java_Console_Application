package com.flight.viewmodel;

import java.util.List;

import com.flight.dto.Flight;
import com.flight.dto.Passenger;
import com.flight.dto.Repository;
import com.flight.screen.BookingView;

public class BookingViewModel {
	Repository repository = Repository.getInstance();
	public BookingViewModel(String name,String flightName,int noOfTickets){
		List<Flight> flightList = repository.getFlightList();
		for(Flight flight : flightList) {
			if(flight.getFlightName().equals(flightName)) {
				if(checkSeatAvailable(flight,noOfTickets)) {
					flight.getPassengerList().add(new Passenger(name,flight,noOfTickets,flight.getTicketPrice()*noOfTickets));
					flight.setTotal(flight.getTotal()+noOfTickets * flight.getTicketPrice());
					int updatedPrice = 200 + flight.getTicketPrice();
					flight.setTicketPrice(updatedPrice);
					BookingView.bookingSuccess();
				}else {
					BookingView.ticketFilled(flightName);
				}
				return;
			}
		}
		BookingView.invalidFlightName(flightName);
		
	}
	private boolean checkSeatAvailable(Flight flight,int noOfTickets) {
		if(noOfTickets > flight.getAvailableSeat())
			return false;
		flight.setAvailableSeat(flight.getAvailableSeat() - noOfTickets);
		return true;
	}
}

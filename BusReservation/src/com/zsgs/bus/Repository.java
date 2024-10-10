package com.zsgs.bus;

import java.util.ArrayList;
import java.util.List;

public class Repository {
	static Repository repository;
	
	List<Bus> busList;
	List<Passenger> passengerList;
	List<Booking> bookedList;
	
	private Repository(){
		busList = new ArrayList<>();
		passengerList = new ArrayList<>();
		bookedList = new ArrayList<>();
	}
	public static Repository getInstance() {
		if(repository == null)
			repository = new Repository();
		return repository;
	}
	public boolean getPassenger(String passengerName) {
		for(Passenger passenger : passengerList) {
			if(passenger.getPassengerName().equals(passengerName)) {
				return true;
			}
		}
		return false;
	}
	public Bus getBus(int busNo) {
		for(Bus bus : busList) {
			if(bus.getBusNo() == busNo) {
				return bus;
			}
		}
		return null;
	}
	public List<Bus> getBusList() {
		return busList;
	}
	public List<Passenger> getPassengerList() {
		return passengerList;
	}
	public List<Booking> getBookedList() {
		return bookedList;
	}
	

}

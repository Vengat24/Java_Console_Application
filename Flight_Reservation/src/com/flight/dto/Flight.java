package com.flight.dto;

import java.util.ArrayList;
import java.util.List;

public class Flight {
	private int availableSeat;
	private String flightName;
	private List<Passenger> passengerList;
	private int ticketPrice;
	private int total;
	
	public int getAvailableSeat() {
		return availableSeat;
	}
	public void setAvailableSeat(int availableSeat) {
		this.availableSeat = availableSeat;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public List<Passenger> getPassengerList() {
		return passengerList;
	}
	public void setPassengerList(List<Passenger> passengerList) {
		this.passengerList = passengerList;
	}
	public int getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Flight(String flightName){
		this.flightName = flightName;
		availableSeat = 50;
		ticketPrice = 5000;
		passengerList = new ArrayList<>();
	}
}

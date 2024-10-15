package com.flight.dto;

public class Passenger {
	private String name;
	private Flight flight;
	private int noOfTickets;
	private int ticketPrice;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public int getNoOfTickets() {
		return noOfTickets;
	}
	public void setNoOfTickets(int noOfTickets) {
		this.noOfTickets = noOfTickets;
	}
	public Passenger(String name, Flight flight, int noOfTickets,int ticketPrice) {
		super();
		this.name = name;
		this.flight = flight;
		this.noOfTickets = noOfTickets;
		this.ticketPrice = ticketPrice;
	}
	public int getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
	

}

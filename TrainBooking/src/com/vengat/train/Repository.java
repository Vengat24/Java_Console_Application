package com.vengat.train;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Repository {
	static Repository repository;
	//Train Seat List
	List<TrainTickets> bookedTickets;
	Queue<TrainTickets> racTickets;
	Queue<TrainTickets> waitingList;
	
	//Used to Initailize the Train Seat List only once
	private Repository() {
		bookedTickets = new ArrayList<>();
		racTickets = new PriorityQueue<>();
		waitingList = new PriorityQueue<>();
	}
	//Singleton Class Method
	public static Repository getInstance() {
		if(repository == null) {
			repository = new Repository();
		}
		return repository;
	}
	//Methods to add Passenger in the list
	public void addToBookedTickets(TrainTickets ticket) {
		bookedTickets.add(ticket);
	}
	public void addToracTickets(TrainTickets ticket) {
		racTickets.offer(ticket);
	}
	public void addToWaitingList(TrainTickets ticket) {
		waitingList.offer(ticket);
	}
	
	public List<TrainTickets> getBookedTicketList(){
		return bookedTickets;
	}
	public Queue<TrainTickets> getracTicketList(){
		return racTickets;
	}
	public Queue<TrainTickets> getWaitingList(){
		return waitingList;
	}
	
	//Display Methods
	public void displayBookedTickets() {
		display(bookedTickets);
	}
	public void displayRacTickets() {
		display(racTickets);
	}
	public void displayWaitingList() {
		display(waitingList);
	}
	private void display(List<TrainTickets> ticketList) {
		if(ticketList.size() == 0) {
			System.out.println("Sorry, There is no Tickets to Display");
			System.out.println("---------------------------------------");
		}
		for(TrainTickets ticket : ticketList) {
			System.out.println("Passenger Name : "+ ticket.getPassengerName());
			System.out.println("Passenger Ticket Id : "+ ticket.getTicketId());
			System.out.println("Passenger Age : "+ ticket.getPassengerAge());
			System.out.println("Passenger Seat No : "+ ticket.getSeatNo());
			System.out.println("Passenger Berth Name : "+ticket.getPerference());
			System.out.println("---------------------------");
		}
	}
	private void display(Queue<TrainTickets> ticketList) {
		if(ticketList.size() == 0) {
			System.out.println("Sorry, There is no Tickets to Display");
			System.out.println("---------------------------------------");
		}
		for(TrainTickets ticket : ticketList) {
			System.out.println("Passenger Name : "+ ticket.getPassengerName());
			System.out.println("Passenger Ticket Id : "+ ticket.getTicketId());
			System.out.println("Passenger Age : "+ ticket.getPassengerAge());
			System.out.println("Passenger Seat No : "+ ticket.getSeatNo());
			System.out.println("Passenger Berth Name : "+ticket.getPerference());
			System.out.println("-----------------------------");
		}
	}
	

}

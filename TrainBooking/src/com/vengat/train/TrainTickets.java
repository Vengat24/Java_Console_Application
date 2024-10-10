package com.vengat.train;
import java.util.Scanner;

public class TrainTickets implements Comparable{
	//Train Tickets Setting
	static int seat[] = new int[3];
	static int rac = 1;
	static int wait = 1;
	private static int ticketNo = 1;
	
	//Passenger Details
	private String passengerName;
	private int ticketId;
	private int passengerAge;
	private int seatNo;
	private char perference;
	
	Scanner scanner = new Scanner(System.in);
	TrainTickets(){
		System.out.print("Enter Your Name : ");
		passengerName = scanner.next();
		System.out.print("Enter your Age : ");
		passengerAge = scanner.nextInt();
		System.out.print("Enter Your Berth Preference : ");
		perference = scanner.next().toUpperCase().charAt(0);	
		System.out.println("----------------------");
		ticketId = ticketNo;
		ticketNo += 1;
		//seatNo;
	}

	//Getter & Setter
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	
	public int getPassengerAge() {
		return passengerAge;
	}
	public void setPassengerAge(int passengerAge) {
		this.passengerAge = passengerAge;
	}
	
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	
	public char getPerference() {
		return perference;
	}
	public void setPerference(char perference) {
		this.perference = perference;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}

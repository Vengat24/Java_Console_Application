package com.vengat.train;

import java.util.Scanner;

public class CancelTickets {
	int cancelTicketId;
	Scanner scanner = new Scanner(System.in);
	CancelTickets(){
		System.out.print("Enter Your Ticket No : ");
		cancelTicketId = scanner.nextInt();
		System.out.println("----------------------");
		if(cancel()) {
			System.out.println("Ticket Canceled Successfully");
		}else {
			System.out.println("Sorry No data Found");
		}
		System.out.println("---------------------------");
	}
	
	private boolean cancel() {
		for(TrainTickets ticket : Repository.getInstance().getBookedTicketList()) {
			if(ticket.getTicketId() == cancelTicketId) {
				Repository.getInstance().getBookedTicketList().remove(ticket);
				if(Repository.getInstance().getracTicketList().peek() != null) {
					Repository.getInstance().getracTicketList().peek().setSeatNo(ticket.getSeatNo());
					Repository.getInstance().getBookedTicketList().add(Repository.getInstance().getracTicketList().poll());
					if(Repository.getInstance().getWaitingList().peek() != null) {
						Repository.getInstance().getracTicketList().offer(Repository.getInstance().getWaitingList().poll());
					}else {
						TrainTickets.rac++;
					}
				}else {
					TrainTickets.seat[ticket.getSeatNo()-1] = 0;
					
				}
				return true;
			}
		}
		for(TrainTickets ticket : Repository.getInstance().getracTicketList()) {
			if(ticket.getTicketId() == cancelTicketId) {
				
				Repository.getInstance().getracTicketList().remove(ticket);
				if(Repository.getInstance().getWaitingList().peek() != null) {
					Repository.getInstance().getracTicketList().offer(Repository.getInstance().getWaitingList().poll());
				}else {
					TrainTickets.rac++;
				}
				return true;
			}
		}
		for(TrainTickets ticket : Repository.getInstance().getWaitingList()) {
			if(ticket.getTicketId() == cancelTicketId) {
				TrainTickets.wait++;
				Repository.getInstance().getWaitingList().remove(ticket);
				return true;
			}
		}
		
		return false;
	}
	
	
	

}

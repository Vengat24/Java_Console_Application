package com.vengat.train;

public class BookTickets {
	
	static TrainTickets curTicket ;
	BookTickets(){
		curTicket = new TrainTickets();
		checkSeatAvailable();
		
	}
	public static void checkSeatAvailable() {
		char preference = curTicket.getPerference();
		
		if(isSeatAvailable(preference)) {
			System.out.println("Ticket Booked Successfully!");
			Repository.getInstance().addToBookedTickets(curTicket);
		}else if(curTicket.rac != 0) {
			curTicket.rac--;
			System.out.println("Ticket added to RAC Successfully!");
			Repository.getInstance().addToracTickets(curTicket);
			
		}else if(curTicket.wait != 0) {
			curTicket.wait--;
			System.out.println("Ticket added to Waiting List Successfully!");
			Repository.getInstance().addToWaitingList(curTicket);
		}else {
			System.out.println("Sorry, Train Seats are Fiiled!");
		}
		System.out.println("-----------------------------------------");
		
		
		
	}
	private static boolean isSeatAvailable(char preference) {
		
		if(preference == 'L') {
			int seatNo = getSeatNo(0);
			if(seatNo !=-1) {
				curTicket.seat[seatNo] = 1;
				curTicket.setSeatNo(seatNo+1);
				curTicket.setPerference(preference);
				return true;
			}else {
				return isSeatAvailable('M');
			}
		}else if(preference == 'M') {
			int seatNo = getSeatNo(1);
			if(seatNo !=-1) {
				curTicket.seat[seatNo] = 2;
				curTicket.setSeatNo(seatNo+1);
				curTicket.setPerference(preference);
				return true;
			}else {
				return isSeatAvailable('U');
			}
			
		}else if(preference == 'U') {
			int seatNo = getSeatNo(2);
			if(seatNo !=-1) {
				curTicket.seat[seatNo] = 3;
				curTicket.setSeatNo(seatNo+1);
				curTicket.setPerference(preference);
				return true;
			}
			
		}
		return false;
	}
	private static int getSeatNo(int start) {
		int i = start;
		while(i<curTicket.seat.length) {
			if(curTicket.seat[i] == 0) {
				return i;
			}
			i+=3;
		}
		return -1;
	}
	
}

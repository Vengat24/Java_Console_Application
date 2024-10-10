package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		List<Taxi> taxies=new ArrayList<>();
		for(int i=0;i<4;i++) {
			taxies.add(new Taxi());
		}
		while(true) {
			System.out.println("Enter  1 to book taxi");
			System.out.println("Enter 2 to view the total booking of the taxi");
			int opt=sc.nextInt();
			switch(opt) {
			case 1:
				char from;
				char to;
				int time;
				System.out.println("Enter the pickup Point");
				from=sc.next().charAt(0);
				System.out.println("Enter the drop Point");
				to=sc.next().charAt(0);
				if(from<'A' || from>'F' || to<'A' || to>'F') {
					System.out.println("Invalid point enter from A to F");
					break;
				}
				System.out.println("Enter the time to pick up");
				time=sc.nextInt();
				Taxi freeTaxi=checkFreeTaxi(taxies,from,time);
				if(freeTaxi==null) {
					System.out.println("No Taxi Available Sorry......!");
					break;
				}
				bookTaxi(freeTaxi,from,to,time);
				System.out.println("Taxi"+" "+freeTaxi.id+" "+"is Booked");
				freeTaxi=null;
				break;
				
			case 2:
				for(Taxi taxi:taxies) {
					List<Details> data=taxi.details;
					System.out.println("TAXI ID"+" "+taxi.id);
					System.out.println("TAXI TOTAL EARNINGS"+" "+taxi.earnings);
			System.out.println("BookingId   CustomerId  From  To  Pickup  Drop  Amount");
					for(Details details:data) {
						System.out.println(details);
					}
				}
			}
		}
	}
	public static Taxi checkFreeTaxi(List<Taxi> taxies,char from,int time) {
		Taxi currentTaxi=null;
		for(Taxi taxi:taxies) {
			if(currentTaxi==null && taxi.freeTime<=time)currentTaxi=taxi;
			else if((taxi.freeTime+(Math.abs(taxi.currentpoint-from)))<=time) {
				if(Math.abs(currentTaxi.currentpoint-from)>Math.abs(taxi.currentpoint-from) ){
					currentTaxi=taxi;
				}
				else if(Math.abs(currentTaxi.currentpoint-from)==Math.abs(taxi.currentpoint-from)) {
					if(currentTaxi.earnings>taxi.earnings)currentTaxi=taxi;
				}
				
			}
		}
		return currentTaxi;
	}
	public static void bookTaxi(Taxi taxi,char from,char to,int time) {
		int total=Math.abs(from-to)*15;
		int earnings=100;
		total-=5;
		earnings+=total*10;
		taxi.earnings=taxi.earnings+earnings;
		int endTime=taxi.freeTime+(Math.abs(taxi.currentpoint-from)+Math.abs(from-to));
		taxi.booked(from, to, time, endTime, earnings);
		taxi.currentpoint=to;
		taxi.freeTime=endTime;
		System.out.println(taxi.freeTime+" "+taxi.id);

		
	}

}
package com.zsgs.taxi;

import java.util.ArrayList;
import java.util.List;

public class Taxi {
	List<TaxiEarning> earningList = new ArrayList<>();
	
	public int getEarning() {
		int earning = 0;
		for(TaxiEarning taxi : earningList) {
			earning += taxi.getEarning();
		}
		
		return earning;
	}

	public void displayTaxi() {
		if(earningList.size() == 0) {
			return;
		}
		System.out.println("-----------------------------------------------------");
		System.out.println("Total Earning : " +getEarning());
		System.out.println("BookingId  CustomerId  From  To  PickUpTime  DropTime  Amount");
		for(TaxiEarning taxi : earningList) {
			System.out.println("   " +taxi.getBookingId() + "          "+taxi.getCustomerId()+"          "+taxi.getPickUpPoint()+"   "+taxi.getDropPoint()+"       "+taxi.getPickUpTime()+"          " +taxi.getDropTime()+"        "+taxi.getEarning());
		}
		
	}
	
}

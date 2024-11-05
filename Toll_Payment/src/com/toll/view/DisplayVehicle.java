package com.toll.view;

import com.toll.dto.Repository;
import com.toll.dto.Toll;
import com.toll.dto.Vehicle;

public class DisplayVehicle {

	public DisplayVehicle(Repository repo) {
		for(Vehicle vehicle : repo.getVehicle()) {
			System.out.println("Vehicle Type : " + vehicle.getType());
			System.out.println("Journey Start : "+ vehicle.getStart());
			System.out.println("Journey Destination : "+ vehicle.getDestination());
			display(vehicle);
			System.out.println("Total Amount Paid : "+ vehicle.getTotal());
			System.out.println("------------------------------------------");
		}
	}
	private void display(Vehicle vehicle ) {
		String type = vehicle.getType();
		for(Toll toll : vehicle.getTollList()) {
			int cost = toll.getCost();
			if(type.equals("VIP")) cost = (cost*80)/100;
			System.out.println("Toll  Name : "+ toll.getTollName() +" "+ "Amount Paid : "+ cost);
		}
	}

}

package com.toll.view;

import com.toll.dto.Repository;
import com.toll.dto.Toll;
import com.toll.dto.Vehicle;

public class DisplayToll {

	public DisplayToll(Repository repo) {
		for(Toll toll : repo.getToll()) {
			System.out.println("Toll Name "+ toll.getTollName());
			display(toll);
			System.out.println("Total Amount : "+ toll.getTotal());
			System.out.println("------------------------");
		}
	}
	private void display(Toll toll) {
		for(Vehicle vehicle : toll.getVehicleList()) {
			int cost = toll.getCost();
			if(vehicle.getType().equals("VIP")) cost = (cost*80)/100;
			System.out.println(vehicle.getType() +" "+ cost );
		}
	}

}

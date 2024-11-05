package com.toll.view;

import java.util.Scanner;

import com.toll.dto.Repository;
import com.toll.dto.Toll;
import com.toll.dto.Vehicle;
import com.toll.viewmodel.VehicleViewModel;

public class VehicleView {
	
	VehicleView(Scanner scanner,Repository repo){
		Vehicle vehicle = new Vehicle();
		System.out.println("Available Vehicle Type : \n1)VIP   2)Normal");
		System.out.print("Enter Your Choice : ");
		vehicle.setType(scanner.nextInt()==1? "VIP" : "Normal");
		displayToll(repo);
		System.out.print("Enter Journey Start : ");
		vehicle.setStart(scanner.next());
		displayToll(repo);
		System.out.print("Enter Journey Destination : ");
		vehicle.setDestination(scanner.next());
		
		
		VehicleViewModel viewModel = new VehicleViewModel(vehicle,repo);
		repo.getVehicle().add(vehicle);
		
		System.out.println("Total No of Toll : " + vehicle.getTollList().size());
		System.out.println("Total Amount Paid : " + vehicle.getTotal());
	}
	private void displayToll(Repository repo) {
		System.out.println("------------------------------------------");
		System.out.println("Avaiable Location : ");
		for(Toll toll : repo.getToll()) {
			System.out.println(toll.getTollName());
		}
		System.out.println("------------------------------------------");
	}

}

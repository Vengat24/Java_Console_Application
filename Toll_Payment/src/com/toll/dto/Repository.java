package com.toll.dto;

import java.util.ArrayList;
import java.util.List;

public class Repository {
	
	static Repository repo;
	List<Vehicle> vehicleList;
	List<Toll> tollList;
	
	private Repository() {
		vehicleList = new ArrayList<>();
		tollList = new ArrayList<>();
	}
	public static Repository getInstance() {
		if(repo == null) repo = new Repository();
		return repo;
	}
	public void addToll(Toll toll) {
		tollList.add(toll);
		
	}
	public List<Toll> getToll(){
		return tollList;
	}
	public List<Vehicle> getVehicle() {
		
		return vehicleList;
	}

}

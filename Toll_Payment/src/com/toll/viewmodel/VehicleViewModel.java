package com.toll.viewmodel;

import java.util.ArrayList;
import java.util.List;

import com.toll.dto.Repository;
import com.toll.dto.Toll;
import com.toll.dto.Vehicle;

public class VehicleViewModel {

	public VehicleViewModel(Vehicle vehicle,Repository repo) {
		int startTollId = getTollId(vehicle.getStart(),repo);
		int desTollId = getTollId(vehicle.getDestination(),repo);
		List<Toll> tollList = new ArrayList<>();
		int total = 0;
		for(Toll toll : repo.getToll()) {
			if(toll.getId()>=startTollId && toll.getId()<=desTollId) {
				tollList.add(toll);
				toll.getVehicleList().add(vehicle);
				int curTotal = toll.getCost();
				if(vehicle.getType().equals("VIP"))  curTotal = ( curTotal *80)/100;
				toll.setTotal(curTotal);
				total +=   curTotal;
			}
		}
		vehicle.setTotal(total);
		vehicle.setTollList(tollList);
		
	}
	private int getTollId(String tollName,Repository repo) {
		for(Toll toll : repo.getToll()) {
			if(toll.getTollName().equals(tollName)) {
				return toll.getId();
			}
		}
		return -1;
	}

}

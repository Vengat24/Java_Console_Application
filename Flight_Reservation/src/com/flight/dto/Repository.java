package com.flight.dto;

import java.util.ArrayList;
import java.util.List;

public class Repository {
	static Repository repository;
	private List<Flight> flightList;
	Repository(){
		flightList = new ArrayList<>();
	}
	public static Repository getInstance() {
		if(repository == null)
			repository = new Repository();
		return repository;
	}

	public List<Flight> getFlightList() {
		return flightList;
	}

}

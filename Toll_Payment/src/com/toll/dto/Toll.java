package com.toll.dto;

import java.util.ArrayList;
import java.util.List;

public class Toll {
	private static int idGen = 1;
	private int id;
	
	private String tollName;
	private int cost;
	private int total;
	private List<Vehicle> vehicleList = new ArrayList<>();

	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total += total;
	}
	
	public List<Vehicle> getVehicleList() {
		return vehicleList;
	}
	public void setVehicleList(List<Vehicle> vehicleList) {
		this.vehicleList = vehicleList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTollName() {
		return tollName;
	}
	public void setTollName(String tollName) {
		this.tollName = tollName;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public Toll(String tollName, int cost) {
		super();
		id = idGen++;
		this.tollName = tollName;
		this.cost = cost;
		
	}
	

}

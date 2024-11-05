package com.toll.dto;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
	private String type;
	private String start;
	private String destination;
	private int total;
	private List<Toll> tollList = new ArrayList<>();
	
	public List<Toll> getTollList() {
		return tollList;
	}
	public void setTollList(List<Toll> tollList) {
		this.tollList = tollList;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	

}

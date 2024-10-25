package com.invoice.dto;

public class Customer {
	private static int genId = 0;
	private int cusId;
	private String name;
	private String address;
	private long phoneNo;
	public Customer(String name, String address, long phoneNo) {
		this.cusId = genId++;
		this.name = name;
		this.address = address;
		this.phoneNo = phoneNo;
	}
	
	public int getCusId() {
		return cusId;
	}
	public void setCusId(int cusId) {
		this.cusId = cusId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	

}

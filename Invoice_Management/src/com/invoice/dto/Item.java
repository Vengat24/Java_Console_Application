package com.invoice.dto;

public class Item {
	private static int genId = 1;
	private String itemName;
	private int price;
	private int id;
	public Item(String itemName, int price) {
		super();
		this.itemName = itemName;
		this.price = price;
		this.id = genId++;
	}
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

}

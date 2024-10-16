package com.market.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class User {
	private String name;
	private String password;
	private boolean isSeller;
	private List<Product> cart;
	public User(String name, String password,boolean isSeller) throws IOException {
		this.name = name;
		this.password = password;
		this.isSeller = isSeller;
		cart = new ArrayList<Product>();
		
	}
	public List<Product> getCart() {
		return cart;
	}

	public void setCart(List<Product> cart) {
		this.cart = cart;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isSeller() {
		return isSeller;
	}

	public void setSeller(boolean isSeller) {
		this.isSeller = isSeller;
	}

}

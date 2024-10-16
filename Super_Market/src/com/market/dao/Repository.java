package com.market.dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Repository {
	private List<User> userList;
	private List<User> buyerList;
	private List<User> sellerList;
	static Repository repository;
	private Repository() {
		userList = new ArrayList<>();
		buyerList = new ArrayList<>();
		sellerList = new ArrayList<>();
	}
	public static Repository getInstance() {
		if(repository == null) repository = new Repository();
		return repository;
	}
	public void addUser(User user,boolean isSeller) {
		userList.add(user);
		if(isSeller)
			sellerList.add(user);
		else
			buyerList.add(user);
	}
	public List<User> getUser() throws IOException{
		String src = "G:\\JavaConsole\\Super_Market\\src\\File.txt";
		FileInputStream input = new FileInputStream(src);
		InputStreamReader reader = new InputStreamReader(input);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line;
		userList = new ArrayList<>();
		while ((line = bufferedReader.readLine()) != null) {
			String arr[] = line.split(" ");
			boolean type = false;
			if(arr[2].equals("1")) type = true;
			userList.add(new User(arr[0],arr[1],type));
			userList.get(userList.size()-1).setCart(getCartList(userList.get(userList.size()-1)));
		}
		return userList;
	}
	public List<User> getBuyerList() throws IOException {
		String src = "G:\\JavaConsole\\Super_Market\\src\\File.txt";
		FileInputStream input = new FileInputStream(src);
		InputStreamReader reader = new InputStreamReader(input);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line;
		buyerList = new ArrayList<>();
		while ((line = bufferedReader.readLine()) != null) {
			String arr[] = line.split(" ");
			boolean type = false;
			if(arr[2].equals("1")) type = true;
			if(!type) {
				buyerList.add(new User(arr[0],arr[1],type));
				buyerList.get(buyerList.size()-1).setCart(getCartList(buyerList.get(buyerList.size()-1)));
			}
		}
		return buyerList;
	}
	public void setBuyerList(List<User> buyerList) {
		this.buyerList = buyerList;
	}
	public List<User> getSellerList() throws IOException {
		String src = "G:\\JavaConsole\\Super_Market\\src\\File.txt";
		FileInputStream input = new FileInputStream(src);
		InputStreamReader reader = new InputStreamReader(input);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line;
		sellerList = new ArrayList<>();
		while ((line = bufferedReader.readLine()) != null) {
			String arr[] = line.split(" ");
			boolean type = false;
			if(arr[2].equals("1")) type = true;
			if(type) {
				sellerList.add(new User(arr[0],arr[1],type));
				sellerList.get(sellerList.size()-1).setCart(getCartList(sellerList.get(sellerList.size()-1)));
			}
		}
		return sellerList;
	}
	
	
	public void setSellerList(List<User> sellerList) {
		this.sellerList = sellerList;
	}
	
	public List<Product> getCartList(User user) throws IOException {
		String src = "G:\\JavaConsole\\Super_Market\\src\\Cart.txt";
		FileInputStream input = new FileInputStream(src);
		InputStreamReader reader = new InputStreamReader(input);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line;
		List<Product> cart = new ArrayList<>();
		while ((line = bufferedReader.readLine()) != null) {
			String arr[] = line.split(" ");
			if(arr[0].equals(user.getName())) {
				cart.add(new Product(arr[1],Integer.parseInt(arr[2])));
			}
		}
		return cart;
	}
	public void addToCart(User loggedUser, String itemName, int price) throws IOException {
		String src = "G:\\JavaConsole\\Super_Market\\src\\Cart.txt";
		FileOutputStream output = new FileOutputStream(src, true); // 'true' enables append mode
		output.write((loggedUser.getName()+" ").getBytes());
		output.write((itemName+" ").getBytes());
		output.write((price+" ").getBytes());
		output.write("\n".getBytes());
		output.close();
		
	}

}

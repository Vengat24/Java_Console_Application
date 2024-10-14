package com.food.screen;

import java.util.List;
import java.util.Scanner;
import com.food.dao.RestaurantDao;
import com.food.dao.RestaurantDao.Menu;
import com.food.dao.User;
import com.food.viewmodel.RestaurantViewModel;

public class RestaurantView {
	Scanner scanner = new Scanner(System.in);
	private static int idGen = 1;
	RestaurantViewModel resViewModel;
	RestaurantView(){
		resViewModel = new RestaurantViewModel();
	}
	public void addRestaurant() {
		int id = idGen++;
		System.out.print("Enter Restaurant Name : ");
		String name = scanner.next();
		System.out.print("Enter Restaurant Location(x,y) : ");
		int loc[] = new int[2];
		loc[0] = scanner.nextInt();
		loc[1] = scanner.nextInt();
		
		resViewModel.addRestaurant(id, name, loc);
	}
	public void addRestaurant(String name,int loc[]) {
		int id = idGen++;
		resViewModel.addRestaurant(id, name, loc);
	}
	public void addMenu() {
		System.out.print("Enter Restaurant Id : ");
		int resId = scanner.nextInt();
		System.out.print("Enter Menu Name : ");
		String name = scanner.next();
		System.out.print("Enter Menu Price : ");
		float price = scanner.nextFloat();
		resViewModel.addMenu(resId, name, price);
	}
	public void addMenu(int resId,String name,float price) {
		resViewModel.addMenu(resId, name, price);
	}
	public void displayRestaurant(User user) {
		List<RestaurantDao> RestaurantList  = resViewModel.getSortedRestaurant(user);
		
		for(RestaurantDao restaurant : RestaurantList) {
			int loc[] = restaurant.getLocation();
			System.out.println(restaurant.getResId() +" "+ restaurant.getResName() +" ("+loc[0] + ","+loc[1] + ")" );
		}
	}
	
	public void displayRestaurant() {
		List<RestaurantDao> RestaurantList  = resViewModel.getRestaurantList();
		for(RestaurantDao restaurant : RestaurantList) {
			int loc[] = restaurant.getLocation();
			System.out.println(restaurant.getResId() +" "+ restaurant.getResName() +" ("+loc[0] + ","+loc[1] + ")" );
		}
	}
	
	public void displayMenu(int resId) {
		List<RestaurantDao> RestaurantList  = resViewModel.getRestaurantList();
		for(RestaurantDao restaurant : RestaurantList) {
			if(restaurant.getResId() == resId) {
				for(Menu menu : restaurant.getMenuList()) {
					System.out.println(menu.getMenuId() +" "+menu.getMenuName()+" "+menu.getPrice());
				}
				return;
			}
		}
	}
	
	

}

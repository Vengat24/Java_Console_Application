package com.food.viewmodel;

import java.util.Collections;
import java.util.List;

import com.food.dao.Repository;
import com.food.dao.RestaurantDao;
import com.food.dao.RestaurantDao.Menu;
import com.food.dao.User;

public class RestaurantViewModel {
	static Repository repository = Repository.getInstance();
	List<RestaurantDao> RestaurantList  = repository.getRestaurantList();
	public List<RestaurantDao> getRestaurantList() {
		return RestaurantList;
	}
	public void setRestaurantList(List<RestaurantDao> restaurantList) {
		RestaurantList = restaurantList;
	}
	public void addRestaurant(int id, String name,int location[]) {
		repository.addRestaurant(id, name, location);
	}
	public void addMenu(int resId,String menuName,float price) {
		for(RestaurantDao restaurant : RestaurantList) {
			if(restaurant.getResId() == resId) {
				restaurant.addMenu(menuName, price);
			}
		}
	}
	public Menu getMenu(int resId,int menuId) {
		for(RestaurantDao restaurant : RestaurantList) {
			if(restaurant.getResId() == resId) {
				List<Menu> menulist = restaurant.getMenuList();
				for(Menu menu : menulist) {
					if(menu.getMenuId() == menuId) {
						return menu;
					}
				}
				
			}
		}
		return null;
	}
	public List<RestaurantDao> getSortedRestaurant(User user) {
		List<RestaurantDao> RestaurantCopyList = RestaurantList;
		Collections.sort(RestaurantCopyList, (r1, r2) ->getLoc(r1.getLocation(),user.getLoc()).compareTo(getLoc(r2.getLocation(),user.getLoc())));
		return RestaurantCopyList;
	}
	
	private Float getLoc(int resloc[] , int userloc[]) {
		Float ans =(float) Math.sqrt((resloc[0]-userloc[0])*(resloc[0]-userloc[0]) + (resloc[1]-userloc[1])*(resloc[1]-userloc[1]));
		return ans;
	}
}

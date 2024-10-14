package com.food.dao;

import java.util.ArrayList;
import java.util.List;

public class RestaurantDao {
	private int idGen = 1; 
	private int resId;
	private String resName;
	private int location[] = new int[2];
	List<Menu> menuList = new ArrayList<>();

	public int getResId() {
		return resId;
	}
	public void setResId(int resId) {
		this.resId = resId;
	}
	public String getResName() {
		return resName;
	}
	public void setResName(String resName) {
		this.resName = resName;
	}
	public int[] getLocation() {
		return location;
	}
	public void setLocation(int[] location) {
		this.location = location;
	}
	public List<Menu> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}
	public class Menu{
		private int menuId;
		private String menuName;
		private float price;
		public int getMenuId() {
			return menuId;
		}
		public void setMenuId(int menuId) {
			this.menuId = menuId;
		}
		public String getMenuName() {
			return menuName;
		}
		public void setMenuName(String menuName) {
			this.menuName = menuName;
		}
		public float getPrice() {
			return price;
		}
		public void setPrice(float price) {
			this.price = price;
		}
		Menu(String menuName,float price){
			this.menuId = idGen++;
			this.menuName = menuName;
			this.price = price;
		}
	}
	RestaurantDao(int id, String name,int location[]) {
		this.resId = id;
		this.resName = name;
		this.location = location;
	}
	public void addMenu(String menuName,float price) {
		menuList.add(new Menu(menuName,price));
	}
	
}

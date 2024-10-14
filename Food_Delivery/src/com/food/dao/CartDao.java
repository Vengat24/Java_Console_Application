package com.food.dao;

import java.util.ArrayList;
import java.util.List;

import com.food.dao.RestaurantDao.Menu;

public class CartDao {
	private User user;
	private int resId;
	private List<Menu> menulist ;
	private boolean status;
	private float total = 0;
	public CartDao(User user, int resId, Menu menu, boolean status) {
		this.user = user;
		this.resId = resId;
		menulist = new ArrayList<>();
		menulist.add(menu);
		this.status = status;
		this.total += menu.getPrice();
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getResId() {
		return resId;
	}
	public void setResId(int resId) {
		this.resId = resId;
	}
	public List<Menu> getMenulist() {
		return menulist;
	}
	public void setMenulist(List<Menu> menulist) {
		this.menulist = menulist;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public void addMenu(Menu menu) {
		menulist.add(menu);
		total += menu.getPrice();
	}
	

}

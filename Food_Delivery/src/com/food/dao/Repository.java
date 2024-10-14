package com.food.dao;

import java.util.ArrayList;
import java.util.List;

import com.food.screen.Admin;

public class Repository {
	static Repository repository;
	List<RestaurantDao> RestaurantList;
	List<AgentDao> AgentList;
	List<Admin> AdminList;
	List<User> CusList;

	private Repository() {
		RestaurantList = new ArrayList<>();
		AgentList = new ArrayList<>();
		AdminList = new ArrayList<>();
		CusList = new ArrayList<>();
	}

	public static Repository getInstance() {
		if (repository == null)
			repository = new Repository();
		return repository;
	}

	public List<RestaurantDao> getRestaurantList() {
		return RestaurantList;
	}

	public void addRestaurant(int id, String name, int location[]) {
		RestaurantList.add(new RestaurantDao(id, name, location));
	}

	public List<AgentDao> getAgentList() {
		return AgentList;
	}

	public void addAgent(String name, String password, int location[], boolean status) {
		AgentList.add(new AgentDao(name, password, location, status));
	}

	public void addAdmin(Admin admin) {
		AdminList.add(admin);
	}

	public void addCus(User user) {
		CusList.add(user);
	}

	public List<Admin> getAdminList() {
		return AdminList;
	}

	public List<User> getCusList() {
		return CusList;
	}

}

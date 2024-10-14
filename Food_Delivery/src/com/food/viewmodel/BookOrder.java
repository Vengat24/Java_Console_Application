package com.food.viewmodel;

import java.util.List;

import com.food.dao.AgentDao;
import com.food.dao.CartDao;
import com.food.dao.Repository;
import com.food.dao.RestaurantDao;
import com.food.dao.User;

public class BookOrder {

	User user;
	CartDao cart;
	RestaurantDao restaurant;
	public BookOrder(User user, CartDao cart, RestaurantDao restaurant) {
		this.user = user;
		this.cart = cart;
		this.restaurant = restaurant;
	}
	public AgentDao getAgent() {
		Repository repository = Repository.getInstance();
		List<AgentDao> agentList =  repository.getAgentList();
		float minDistance = Float.MAX_VALUE;
		AgentDao deliveryagent = null;
		for(AgentDao agent : agentList) {
			if(agent.getStatus()) {
				int agentloc[] = agent.getLoc();
				int resloc[] = restaurant.getLocation();
				float distance = (float) Math.sqrt(((resloc[0]-agentloc[0])*(resloc[0]-agentloc[0]) + (resloc[1]-agentloc[1])*(resloc[1]-agentloc[1])));
				if(distance < minDistance) {
					minDistance = distance;
					deliveryagent = agent;
				}
			}
		}
		if(deliveryagent != null) {
			deliveryagent.setStatus(false);
			deliveryagent.setLoc(user.getLoc());
		}
		return deliveryagent;
		
	}
}

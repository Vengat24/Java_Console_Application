package com.food.viewmodel;

import java.util.ArrayList;
import java.util.List;

import com.food.dao.AgentDao;
import com.food.dao.Repository;
import com.food.dao.User;
import com.food.screen.Admin;

public class LoginViewModel {
	static Repository repository = Repository.getInstance();
	public User checkUser(int ch,String username,String password) {
		List<User> userlist = null;
		switch(ch) {
		case 1:
			userlist = new ArrayList<>();
			for (Admin admin : repository.getAdminList()) {
		        userlist.add((User) admin);  
		    }  
			break;
		case 2:
			userlist = repository.getCusList();
			break;
		case 3:
			userlist = new ArrayList<>();
			for (AgentDao agent : repository.getAgentList()) {
		        userlist.add((User) agent);  
		    }
			break;
		}
		for(User user : userlist) {
			if(user.getUserName().equals(username) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}
	public AgentDao getAgent(User user) {
		List<AgentDao> agentList = repository.getAgentList();
		for(AgentDao agent : agentList) {
			if(agent.getUserName().equals(user.getUserName()) && agent.getPassword().equals(user.getPassword())) {
				return agent;
			}
		}
		return null;
	}
	public Admin getAdmin(User user) {
		List<Admin> adminList = repository.getAdminList();
		for(Admin admin : adminList) {
			if(admin.getUserName().equals(user.getUserName()) && admin.getPassword().equals(user.getPassword())) {
				return admin;
			}
		}
		return null;
	}

}

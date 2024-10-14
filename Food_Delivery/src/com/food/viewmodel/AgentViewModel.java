package com.food.viewmodel;

import java.util.List;

import com.food.dao.AgentDao;
import com.food.dao.Repository;
public class AgentViewModel {
	List<AgentDao> AgentList  = repository.getAgentList();
	public List<AgentDao> getAgentList() {
		return AgentList;
	}
	public void setAgentList(List<AgentDao> AgentList) {
		this.AgentList = AgentList;
	}
	static Repository repository = Repository.getInstance();
	
	public void addAgent(String name,String password,int location[],boolean status) {
		repository.addAgent(name,password, location,status);
	}
}

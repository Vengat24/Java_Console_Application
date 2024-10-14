package com.food.dao;


public class AgentDao extends User {
	private static int idGen=1;
	private int agentId;
	private boolean status;
	public int getAgentId() {
		return agentId;
	}
	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public boolean getStatus() {
		return status;
	}
	public AgentDao(String agentName, String password,int[] curLocation, boolean status) {
		super(agentName,password,curLocation);
		agentId = idGen++;
		this.status = status;
	}
	
	
}

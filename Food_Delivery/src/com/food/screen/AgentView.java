package com.food.screen;

import java.util.List;
import java.util.Scanner;

import com.food.dao.AgentDao;
import com.food.viewmodel.AgentViewModel;

public class AgentView {
	Scanner scanner = new Scanner(System.in);
	AgentViewModel agViewModel;
	public AgentView(){
		agViewModel = new AgentViewModel();
	}
	public void addAgent() {
		System.out.print("Enter Agent Name : ");
		String name = scanner.next();
		System.out.print("Enter Password : ");
		String password = scanner.next();
		System.out.print("Enter Agent Location(x,y) : ");
		int loc[] = new int[2];
		loc[0] = scanner.nextInt();
		loc[1] = scanner.nextInt();
		System.out.print("Enter Agent Status(1/0) : ");
		boolean status = false;
		if(scanner.nextInt() == 1) {
			status = true;
		}
		System.out.println("------------------------------------------");
		agViewModel.addAgent(name,password,loc,status);
	}
	public void addAgent(String name,String password,int[] loc,boolean status) {
		agViewModel.addAgent(name,password, loc,status);
	}
	public void displayAgentnt() {
		List<AgentDao> AgentList  = agViewModel.getAgentList();
		for(AgentDao Agent : AgentList) {
			int loc[] = Agent.getLoc();
			System.out.println(Agent.getAgentId() +" "+ Agent.getUserName() +" ("+loc[0] + ","+loc[1] + ")" +" "+Agent.getStatus());
		}
	}

}

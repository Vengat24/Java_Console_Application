package com.food.screen;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		RestaurantView resView = new RestaurantView();
		AgentView agView = new AgentView();
		SignUpView signView = new SignUpView();
		LoginView loginView = new LoginView();
		preLoad(resView,agView);
		int ch = 0;
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("------------------------------------------");
			System.out.println("Welcome to Zomato : ");
			System.out.println("1)SignUp \n2)Login");
			System.out.println("------------------------------------------");
			System.out.print("Enter Your Choice : ");
			ch = scanner.nextInt();
			System.out.println("------------------------------------------");
			switch(ch) {
			case 1:
				signView.addUser();
				break;
			case 2:
				loginView.login();
				break;
			default:
				System.exit(0);
			}
		}
	}
	private static void preLoad(RestaurantView resView, AgentView agView) {
		resView.addRestaurant("A2B", new int[] {1,10});
		resView.addMenu(1,"Idly",40);
		resView.addMenu(1,"Dosa",80);
		resView.addMenu(1,"Puri",70);
		resView.addRestaurant("Sangeetha", new int[] {-10,5});
		resView.addMenu(2,"Mini Idly",30);
		resView.addMenu(2,"Pongal",50);
		resView.addMenu(2,"Vada",20);
		resView.addRestaurant("Buhari", new int[] {-6,-10});
		resView.addMenu(3,"Fired Rice",150);
		resView.addMenu(3,"Biriyani",300);
		resView.addMenu(3,"Noodles",180);
		
		agView.addAgent("Kumar","12345", new int[] {5,6},true);
		agView.addAgent("Praveen","12345", new int[] {1,-8},false);
		agView.addAgent("Sathish","12345", new int[] {-5,-5},true);
		
	}
	
}

package com.food.screen;

import java.util.Scanner;

import com.food.dao.User;

public class Admin extends User{

	public Admin(String userName, String password, int[] loc) {
		super(userName, password, loc);
	}

	public void main() {
		RestaurantView resView = new RestaurantView();
		AgentView agView = new AgentView();
		LoginView loginView = new LoginView();
		
		int ch = 0;
		Scanner scanner = new Scanner(System.in);
		outer : while(true) {
			System.out.println("------------------------------------------");
			System.out.println("1)Add Restaurant \n2)Add Menu \n3)Display Restaurant \n4)Add Agent \n5)Display Agent \n6)Display User \n7)Logout");
			System.out.print("Enter Your Choice : ");
			ch = scanner.nextInt();
			switch(ch) {
			case 1:
				System.out.println("------------------------------------------");
				resView.addRestaurant();
				break;
			case 2:
				System.out.println("------------------------------------------");
				resView.addMenu();
				break;
			case 3:
				System.out.println("------------------------------------------");
				resView.displayRestaurant();
				break;
			case 4:
				System.out.println("------------------------------------------");
				agView.addAgent();
				break;
			case 5:
				System.out.println("------------------------------------------");
				agView.displayAgentnt();
				break;
			case 6:
				System.out.println("------------------------------------------");
				loginView.displayUser();
				break;
			case 7:
				System.out.println("------------------------------------------");
				System.out.println("Thank You!");
				break outer;
			default:
				System.exit(0);
			}
		}

	
	}
}
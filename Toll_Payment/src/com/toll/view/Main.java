package com.toll.view;

import java.util.Scanner;

import com.toll.dto.Repository;
import com.toll.dto.Toll;

public class Main {

	static Repository repo = Repository.getInstance();
	public static void main(String[] args) {
		loadToll();
		int ch;
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("------------------------------------------");
			System.out.println("1)Start Journey   2)Display Toll Details   3)Display Vehicle Details");
			ch = scanner.nextInt();
			switch(ch) {
			case 1:
				VehicleView vehicle = new VehicleView(scanner,repo);
				break;
			case 2:
				DisplayToll tollDisplay = new DisplayToll(repo);
				break;
			case 3:
				DisplayVehicle vehicleDisplay = new DisplayVehicle(repo);
				break;
			default : 
				System.out.println("Thank You!");
				System.exit(ch);
			}
			System.out.println("------------------------------------------");
		}
		

	}
	public static void loadToll() {
		repo.addToll(new Toll("Thiruvanmuyir",50));
		repo.addToll(new Toll("Kotivakkam",60));
		repo.addToll(new Toll("Palavakkam",40));
		repo.addToll(new Toll("Neelagarai",70));
		repo.addToll(new Toll("Vettuvankani",80));
		repo.addToll(new Toll("Injambakkam",50));
		repo.addToll(new Toll("Akarai",70));
		repo.addToll(new Toll("Uthandi",90));
		repo.addToll(new Toll("Mudukadu",20));
		repo.addToll(new Toll("Kovalam",80));
	}

}

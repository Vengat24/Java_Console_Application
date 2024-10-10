package com.lift.screen;

import java.util.Scanner;

import com.list.viewmodel.MainViewModel;

public class MainScreen {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MainViewModel viewModel = new MainViewModel();
		int ch;
		while(true) {
			System.out.print("Enter Your Choice : ");
			ch = scanner.nextInt();
			int lift[] = viewModel.getLift();
			switch(ch) {
			//module 1
			case 1: 
				for(int i=0;i<lift.length;i++) {
					System.out.print("L" + (i+1)+" ");
				}
				System.out.println();
				for(int i=0;i<lift.length;i++) {
					System.out.print(" "+lift[i]+ " ");
				}
				System.out.println();
				break;
				
			case 2:
				int start = scanner.nextInt();
				int end = scanner.nextInt();
				//module 2
				System.out.println("L" + viewModel.assignLift(start, end)+ " is assigned");
				break;
			case 3:
				int ind = scanner.nextInt();
				//module 8
				lift[ind] = -1;
				break;
			default :
				System.out.println("Thank you!");
				System.exit(0);
			}
		}
	}

}

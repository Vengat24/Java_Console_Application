package com.zsgs.bank;

import java.util.Scanner;

public class Account {
	
	Account(){
		Scanner scanner = new Scanner(System.in);
		int ch ;
		outer : while(true) {
			System.out.println("1.Create Gift Card \n2.TopUp \n3.Transaction History \n4.Block \n5.Logout");
			ch = scanner.nextInt();
			switch(ch) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			default : 
				break outer;
			}
		}
	}
}

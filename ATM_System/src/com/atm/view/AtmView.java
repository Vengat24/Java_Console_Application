package com.atm.view;

import java.util.Scanner;

import com.atm.dto.AtmDto;

public class AtmView {
	
	float amt;
	public AtmView(){
		Scanner scanner = new Scanner(System.in);
		while(amt < 100000) {
			System.out.print("Enter Amount More than 100000 : ");
			amt = scanner.nextFloat() * 100000;			
		}
	}
	public int getAmt() {
		return (int)amt;
	}

}

package com.game;

import java.util.Scanner;

public class Main {

	static int col;
	static int row;
	static int playerCount = 2;
	static char coin[] = {'X','O'};
	static int count = 0;
	static Repository repository = Repository.getInstance();
	static int len  = repository.getBoxSize();
	static Scanner scanner = new Scanner(System.in);
	static char box[][] = repository.getBox();
	public static void main(String[] args) {
		while(true) {
			for(int i=1;i<=playerCount;i++) {
				boolean flag = true;
			  while(flag) {
				  System.out.println("Player "+i +"("+ coin[i-1]+"), enter your move (row and column): ");
					row = scanner.nextInt();
					col = scanner.nextInt();
					
					
					if(row>=len || col >= len || box[row][col] != '-') {
						System.out.println("Invalid Move");
						flag = true;
					}else {					
						box[row][col] = coin[i-1];
						flag = false;
					}
			   }
			  	if(checkWin()){
			  		System.exit(0);
			  	}
				
			  	repository.displayBox();
				count++;
				if(count == 9) {
					if(!checkWin()){
				  		System.out.println("Draw");
				  	}
					System.exit(0);
				}
			}		
		}

	}
	private static boolean checkWin() {
		for(int i=0;i<len;i++) {
			int xCount = 0;
			int oCount = 0;
			for(int j=0;j<len;j++) {
				if(box[i][j] == 'X') xCount++;
				else if(box[i][j] == 'O') oCount++;
			}
			if(xCount == 3) {
				System.out.println("Player 1 wins");
				return true;
			}else if(oCount == 3) {
				System.out.println("Player 2 Wins");
				return true;
			}
		}
		
		for(int j=0;j<len;j++) {
			int xCount = 0;
			int oCount = 0;
			for(int i=0;i<len;i++) {
				if(box[i][j] == 'X') xCount++;
				else if(box[i][j] == 'O') oCount++;
			}
			if(xCount == 3) {
				System.out.println("Player 1 wins");
				return true;
			}else if(oCount == 3) {
				System.out.println("Player 2 Wins");
				return true;
			}
		}
		
		int xCount = 0;
		int oCount = 0;
		for(int j=0;j<len;j++) {
			for(int i=0;i<len;i++) {
				if(i != j) continue;
				if(box[i][j] == 'X') xCount++;
				else if(box[i][j] == 'O') oCount++;
			}
			if(xCount == 3) {
				System.out.println("Player 1 wins");
				return true;
			}else if(oCount == 3) {
				System.out.println("Player 2 Wins");
				return true;
			}
		}
		
		xCount = 0;
		oCount = 0;
		for(int j=0;j<len;j++) {
			for(int i=0;i<len;i++) {
				if(i+j != len-1) continue;
				if(box[i][j] == 'X') xCount++;
				else if(box[i][j] == 'O') oCount++;
			}
			if(xCount == 3) {
				System.out.println("Player 1 wins");
				return true;
			}else if(oCount == 3) {
				System.out.println("Player 2 Wins");
				return true;
			}
		}
		
		return false;
	}
	

}

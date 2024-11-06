package com.brick;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int board_row = 10;
	static int board_col = board_row -2;
	static char board[][] = new char[board_row][board_col];
	public static void main(String[] args) {
		char move;
		Scanner scanner = new Scanner(System.in);
		for(int i=0;i<2;i++) Arrays.fill(board[i], '-');
		int i = board_row - 1;
		int j = board_col/2;
		board[i][j] = 'O';
		int moved = 1;
		while(true) {
			displayBoard();
			gameOver();
			System.out.print("Enter Move(L/R/S) : ");
			move = scanner.next().charAt(0);
			clearBoard();
			if(moved%4 == 0) moveBoard();
			moved++;
			
			board[i][j] = '\u0000';
			if(move == 'L') {
				while(i>0 && j>0) {
					if(board[i][j] == '-') {
						board[i][j] = '+';
						break;
					}
					else {
						board[i][j] = '+';
						--i;--j;
					}
				}
				while(i>0 && j< board_col-1) {
					if(board[i][j] == '-') {
						board[i][j] = '+';
						break;
					}
					else {
						board[i][j] = '+';
						--i;++j;
					}
				}
				while(i<board_row-1 && j<board_col-1) {
						board[i][j] = '+';
						++i;++j;
					
				}
				while(i<board_row-1 && j>0) {
					
						board[i][j] = '+';
						++i;--j;
					
				}
				while(i<board_row-1 && j<board_col-1) {
						board[i][j] = '+';
						++i;++j;
					
				}
			}else if(move == 'R') {
				while(i>0 && j<board_col-1) {
						board[i][j] = '+';
						--i;++j;
					
				}
				boolean wall = false;
				while(i>0 && j>0) {
					if(board[i][j] == '-') {
						board[i][j] = '+';
						wall = true;
						break;
					}
					else {
						board[i][j] = '+';
						--i;--j;
					}
				}
				if(!wall && i!= 0) {
					while(i>0 && j<board_col){
							board[i][j] = '+';
							--i;++j;
						
					}
					while(i<board_row-1 && j<board_col-1){
							board[i][j] = '+';
							++i;++j;
						
					}
					while(i<board_row-1 && j>0){
							board[i][j] = '+';
							++i;--j;
						
					}
				}else {
					while(i<board_row-1 && j>0){
							board[i][j] = '+';
							++i;--j;
						
					}
					while(i<board_row-1 && j<board_col-1) {
							board[i][j] = '+';
							++i;++j;
					}
					while(i<board_row-1 && j>0) {
						board[i][j] = '+';
						++i;--j;
					}
				}
				
				
				
			}else {
				while(i>0) {
					if(board[i][j] == '-') 
					break;
					board[i][j] = '+';
					--i;
				}
				while(i<board_row-1){
					board[i][j] = '+';
					++i;
				}
			}
			board[i][j] = 'O';
		}
	}
	private static void displayBoard() {
		System.out.println("_________________");
		for(int i=0;i<board_row;i++) {
			System.out.print("|");
			for(int j=0;j<board_col;j++) {
				System.out.print(board[i][j] +" ");
			}
			System.out.println("|");
		}
		System.out.print("|");
		System.out.print("________________");
		System.out.print("|");
		System.out.println();
	}
	private static void clearBoard() {
		for(int i=0;i<board_row;i++) {
			for(int j=0;j<board_col;j++) {
				if(board[i][j] != '-') {
					board[i][j] = '\u0000';
				}
			}
		}
	}
	private static void moveBoard() {
		for(int i=board_row-1;i>0;i--) {
			for(int j=board_col-1;j>=0;j--) {
				board[i][j] = board[i-1][j];
			}
		}
		for(int j= 0;j<board_col;j++) {
			board[0][j] = '\u0000';
		}
	}
	private static void gameOver() {
		for(int j= 0;j<board_col;j++) {
			if(board[board_row-1][j] == '-') {
				System.out.println("You Lost");
				System.exit(0);
			}
		}
		
		for(int i=0;i<board_row;i++) {
			for(int j=0;j<board_col;j++) {
				if(board[i][j] == '-') {
					return;
				}
			}
		}
		System.out.println("You Won");
		System.exit(0);
	}
}

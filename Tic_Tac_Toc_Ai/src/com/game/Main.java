package com.game;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

	static int col;
	static int row;
	static int playerCount = 2;
	static char coin[] = { 'X', 'O' };
	static int count = 0;
	static Repository repository = Repository.getInstance();
	static int len = repository.getBoxSize();
	static Scanner scanner = new Scanner(System.in);
	static char box[][] = repository.getBox();

	public static void main(String[] args) {
		while (true) {
			for (int i = 1; i <= playerCount; i++) {
				boolean flag = true;
				while (flag) {
					if (i == 1) {
						System.out.println("Player turn, enter your move (row and column): ");
						row = scanner.nextInt();
						col = scanner.nextInt();
					} else {
						int move[] = computerMove();
						if (move == null) {
							System.out.println("Player Wins");
							return;
						} else {
							System.out.println(Arrays.toString(move));
						}
						row = move[0];
						col = move[1];
					}

					if (row >= len || col >= len || box[row][col] != '-') {
						System.out.println("Invalid Move");
						flag = true;
					} else {
						box[row][col] = coin[i - 1];
						flag = false;
					}
				}
				repository.displayBox();
				if (checkWin()) {
					System.exit(0);
				}

				count++;
				if (count == 9) {
					if (!checkWin()) {
						System.out.println("Draw");
					}
					System.exit(0);
				}
			}
		}

	}

	private static int[] computerMove() {
		Random random = new Random();
		while (true) {
			int genRow = random.nextInt(3);
			int genCol = random.nextInt(3);
			if (box[genRow][genCol] != '-') {
				continue;
			} else {
				return new int[] { genRow, genCol };
			}
		}
	}

	private static boolean checkWin() {
		for (int i = 0; i < len; i++) {
			int xCount = 0;
			int oCount = 0;
			for (int j = 0; j < len; j++) {
				if (box[i][j] == 'X')
					xCount++;
				else if (box[i][j] == 'O')
					oCount++;
			}
			if (xCount == 3) {
				System.out.println("Player wins");
				return true;
			} else if (oCount == 3) {
				System.out.println("Computer Wins");
				return true;
			}
		}

		for (int j = 0; j < len; j++) {
			int xCount = 0;
			int oCount = 0;
			for (int i = 0; i < len; i++) {
				if (box[i][j] == 'X')
					xCount++;
				else if (box[i][j] == 'O')
					oCount++;
			}
			if (xCount == 3) {
				System.out.println("Player wins");
				return true;
			} else if (oCount == 3) {
				System.out.println("Computer Wins");
				return true;
			}
		}

		int xCount = 0;
		int oCount = 0;
		for (int j = 0; j < len; j++) {
			for (int i = 0; i < len; i++) {
				if (i != j)
					continue;
				if (box[i][j] == 'X')
					xCount++;
				else if (box[i][j] == 'O')
					oCount++;
			}
			if (xCount == 3) {
				System.out.println("Player wins");
				return true;
			} else if (oCount == 3) {
				System.out.println("Computer Wins");
				return true;
			}
		}

		xCount = 0;
		oCount = 0;
		for (int j = 0; j < len; j++) {
			for (int i = 0; i < len; i++) {
				if (i + j != len - 1)
					continue;
				if (box[i][j] == 'X')
					xCount++;
				else if (box[i][j] == 'O')
					oCount++;
			}
			if (xCount == 3) {
				System.out.println("Player wins");
				return true;
			} else if (oCount == 3) {
				System.out.println("Computer Wins");
				return true;
			}
		}

		return false;
	}

}

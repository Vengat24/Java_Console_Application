package Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Dimensions of the dungean(Row X Col) : ");
		int row = scanner.nextInt();
		int col = scanner.nextInt();
		char box[][] = new char[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				box[i][j] = '.';
			}
		}

		System.out.print("Position of Adventurer : ");
		int ar = scanner.nextInt();
		int ac = scanner.nextInt();
		System.out.print("Position of Monster : ");
		int mr = scanner.nextInt();
		int mc = scanner.nextInt();
		System.out.print("Position of Trigger : ");
		int tr = scanner.nextInt();
		int tc = scanner.nextInt();
		System.out.print("Position of Gold : ");
		int gr = scanner.nextInt();
		int gc = scanner.nextInt();
		System.out.print("Enter number of pits : ");
		int pits = scanner.nextInt();

		for (int i = 1; i <= pits; i++) {
			System.out.print("Position of pit" + i + " : ");
			int pr = scanner.nextInt();
			int pc = scanner.nextInt();
			box[pr - 1][pc - 1] = 'P';
		}

		box[ar - 1][ac - 1] = 'A';
		box[gr - 1][gc - 1] = 'G';

		List<String> list1 = new ArrayList<String>();
		findPath(ar - 1, ac - 1, list1, "", box, 'G', false);
		if (list1.size() == 0) {
			System.out.println("No Possible Solution");
			return;
		}
		String adventPath = min(list1);

		box[mr - 1][mc - 1] = 'M';
		List<String> list2 = new ArrayList<String>();
		findPath(mr - 1, mc - 1, list2, "", box, 'G', true);
		String monsterPath = min(list2);

		if (monsterPath.length() < adventPath.length()) {
			List<String> list3 = new ArrayList<String>();
			box[tr - 1][tc - 1] = 'T';
			findPath(ar - 1, ac - 1, list3, "", box, 'T', false);
			String triggerPath = min(list3);
			List<String> list4 = new ArrayList<String>();

			findPath(tr - 1, tc - 1, list4, "", box, 'G', false);
			adventPath = min(list4);
			System.out.println("Minimum number of steps : " + (adventPath.length() + triggerPath.length()));
			System.out.println(triggerPath + adventPath);
		} else {
			System.out.println("Minimum number of steps : " + adventPath.length());
		}
	}

	private static String min(List<String> list) {
		String str = "";
		int len = Integer.MAX_VALUE;

		for (String string : list) {
			if (string.length() < len) {
				len = string.length();
				str = string;
			}
		}
		return str;
	}

	private static void findPath(int row, int col, List<String> list, String path, char[][] box, char target,boolean isMonster) {
		if (row >= box.length || row < 0 || col >= box[0].length || col < 0) {
			return;
		}
		if (box[row][col] == target) {
			list.add(path);
			return;
		}
		if (box[row][col] == '.' || box[row][col] == 'A' || box[row][col] == 'M' || box[row][col] == 'T'|| (box[row][col] == 'P' && isMonster)) {
			char temp = box[row][col];
			box[row][col] = ' ';
			findPath(row + 1, col, list, path + 'D', box, target, isMonster);
			findPath(row, col + 1, list, path + 'R', box, target, isMonster);
			findPath(row - 1, col, list, path + 'U', box, target, isMonster);
			findPath(row, col - 1, list, path + 'L', box, target, isMonster);
			box[row][col] = temp;
		} else {
			return;
		}

	}
}

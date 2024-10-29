package com.emp.view;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int ch ;
		while(true) {
			System.out.println("1)Add EMP  2)Display All EMP  3)Search EMP  4)EMP Under MGR  5)Reporting Tree");
			ch = scanner.nextInt();
			switch(ch) {
			case 1:
				AddEmpView add = new AddEmpView();
				break;
			case 2:
				PrintEmpView print = new PrintEmpView();
				break;
			case 3:
				SearchEmpView search = new SearchEmpView();
				break;
			case 4:
				UnderMgrView under = new UnderMgrView();
				break;
			case 5:
				ReportTreeView tree = new ReportTreeView();
				PrintEmpView.printEmp(tree.getEmpMgr());
				break;
			default:
				System.out.println("Thank You!");
				System.exit(0);
			}
		}
	}

}

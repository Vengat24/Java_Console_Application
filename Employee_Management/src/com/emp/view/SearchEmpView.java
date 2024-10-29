package com.emp.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.emp.data.Emp;
import com.emp.viewmodel.SearchEmpViewModel;

public class SearchEmpView {
	String name;
	SearchEmpView(){
		Scanner scanner = new Scanner(System.in);
		SearchEmpViewModel search = new SearchEmpViewModel();
		while(true) {
			System.out.println("Enter Emp Name : ");
			name = scanner.next();
			List<Emp> empList = search.getEmp(name);
			if(empList.size() != 0) {
				PrintEmpView.printEmp(empList);
				break;
			}else {
				System.out.println("Invalid Employee Name !");
			}
		}
		
		
	}

}

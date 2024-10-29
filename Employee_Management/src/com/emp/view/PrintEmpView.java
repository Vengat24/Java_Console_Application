package com.emp.view;

import java.util.List;

import com.emp.data.Emp;
import com.emp.data.Repository;

public class PrintEmpView {
	Repository repo;
	PrintEmpView(){
		repo = Repository.getInstance();
		List<Emp> empList = repo.getEmpList();
		printEmp(empList);
	}
	public static void printEmp(List<Emp> empList) {
		if(empList.size() == 0) {
			System.out.println("No Emp Data Found!");
		}else {
			System.out.printf("%-15s %-4s %-12s %-12s %-15s \n","Name","Age","Destination","Department","Report Manager");
			for(Emp emp : empList) {
				System.out.printf("%-15s %-4s %-12s %-12s %-15s \n",emp.getName(),emp.getAge(),emp.getDes(),emp.getDept(),emp.getMgr());
			}
		}
		
	}

}

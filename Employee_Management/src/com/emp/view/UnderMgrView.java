package com.emp.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.emp.data.Emp;
import com.emp.viewmodel.UnderMgrViewModel;

public class UnderMgrView {
	String mgr;
	UnderMgrView(){
		UnderMgrViewModel undermgr = new UnderMgrViewModel();
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("Enter Manager Name : ");
			mgr = scanner.next();
			List<Emp> empList = undermgr.getEmp(mgr);
			if(empList.size() != 0) {
				PrintEmpView.printEmp(empList);
				break;
			}else {
				System.out.println("Invalid Employee Name !");
			}
		}
	}

}

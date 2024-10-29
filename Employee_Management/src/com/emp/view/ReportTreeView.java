package com.emp.view;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import com.emp.data.Emp;
import com.emp.viewmodel.ReportTreeViewModel;

public class ReportTreeView {
	String name;
	ReportTreeView(){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Emp Name : ");
		name = scanner.next();
	}
	public List<Emp> getEmpMgr(){
		ReportTreeViewModel report = new ReportTreeViewModel();
		Queue<Emp> queue = new LinkedList<>();
		List<Emp> rtList = new ArrayList<>();
		for(Emp emp : report.getEmp(name)){
			rtList.add(emp);
			queue.add(emp);
		}
		while(!queue.isEmpty()){
			for(Emp emp : report.getEmp(queue.poll().getName())){
				rtList.add(emp);
				queue.add(emp);
			}
		}
		return rtList;
	}

}

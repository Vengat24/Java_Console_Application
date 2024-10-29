package com.emp.viewmodel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.emp.data.Emp;
import com.emp.data.Repository;

public class ReportTreeViewModel {
	Repository repo;
	List<Emp> empList;
	public ReportTreeViewModel(){
		repo = Repository.getInstance();
		empList = repo.getEmpList();
	}

	public List<Emp> getEmp(String name) {
		List<Emp> emplist = new ArrayList<>();
		for(Emp emp : empList) {
			if(emp.getMgr().equals(name)) {
				emplist.add(emp);
			}
		}
		return emplist;
	}

}

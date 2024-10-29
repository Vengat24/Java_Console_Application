package com.emp.viewmodel;

import java.util.ArrayList;
import java.util.List;

import com.emp.data.Emp;
import com.emp.data.Repository;

public class SearchEmpViewModel {
	
	Repository repo;
	List<Emp> empList;
	public SearchEmpViewModel() {
		repo = Repository.getInstance();
		empList = repo.getEmpList();
	}
	public List<Emp> getEmp(String name) {
		List<Emp> emplist = new ArrayList<>();
		for(Emp emp : empList) {
			if(emp.getName().equals(name)) {
				emplist.add(emp);
			}
		}
		return emplist;
		
	}

}

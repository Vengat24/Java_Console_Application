package com.emp.viewmodel;

import java.util.ArrayList;
import java.util.List;

import com.emp.data.Emp;
import com.emp.data.Repository;

public class UnderMgrViewModel {
	
	Repository repo;
	List<Emp> empList;
	public UnderMgrViewModel() {
		repo = Repository.getInstance();
		empList = repo.getEmpList();
	}

	public List<Emp> getEmp(String mgr) {
		List<Emp> emplist = new ArrayList<>();
		for(Emp emp : empList) {
			if(emp.getMgr().equals(mgr)) {
				emplist.add(emp);
			}
		}
		return emplist;
		
	}

}

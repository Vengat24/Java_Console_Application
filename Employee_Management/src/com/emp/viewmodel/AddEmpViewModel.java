package com.emp.viewmodel;

import com.emp.data.Emp;
import com.emp.data.Repository;
import com.emp.view.AddEmpView;

public class AddEmpViewModel {
	Repository repo = Repository.getInstance();
	public AddEmpViewModel(AddEmpView addEmp) {
		Emp emp = new Emp(addEmp.name,addEmp.age,addEmp.des,addEmp.dept,addEmp.mgr);
		repo.addEmp(emp);
	}

}

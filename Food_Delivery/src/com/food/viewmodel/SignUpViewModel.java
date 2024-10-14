package com.food.viewmodel;

import com.food.screen.UserView;
import com.food.dao.Repository;
import com.food.screen.AgentView;

public class SignUpViewModel {
	static Repository repository = Repository.getInstance();
	public void addUser(int ch) {
		if(ch == 3) {
			new AgentView().addAgent();
		}else {
			new UserView(ch);
		}
		
	}
}

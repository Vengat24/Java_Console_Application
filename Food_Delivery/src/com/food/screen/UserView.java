package com.food.screen;

import java.util.Scanner;
import com.food.dao.Repository;
import com.food.dao.User;

public class UserView {
	static Repository repository = Repository.getInstance();
	public UserView(int ch){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your name :");
		String name = scanner.next();
		System.out.print("Enter Password : ");
		String password = scanner.next();
		System.out.print("Enter User Location(x,y) : ");
		int loc[] = new int[2];
		loc[0] = scanner.nextInt();
		loc[1] = scanner.nextInt();
		System.out.println("------------------------------------------");
		if(ch == 1) {
			repository.addAdmin(new Admin(name,password,loc));
		}else {
			repository.addCus(new User(name,password,loc));
		}
	}

}

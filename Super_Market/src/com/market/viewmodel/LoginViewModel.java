package com.market.viewmodel;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.market.dao.Repository;
import com.market.dao.User;
import com.market.view.BuyerView;
import com.market.view.SellerView;


public class LoginViewModel {
	Repository repository = Repository.getInstance();
	public LoginViewModel(String name, String password) throws IOException {
		String src = "G:\\JavaConsole\\Super_Market\\src\\File.txt";
		FileInputStream input = new FileInputStream(src);
		InputStreamReader reader = new InputStreamReader(input);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			String arr[] = line.split(" ");
			arr[1] = decryptPassword(arr[1]);
			if(name.equals(arr[0])) {
				if(password.equals(arr[1])) {
					System.out.println("Logged in");
					List<User> userList = repository.getUser();
					User loggedUser = getUser(name,password,userList);
					if(loggedUser.isSeller()) {
						new SellerView(loggedUser);
						return;
					}else {
						loggedUser.setCart(new ArrayList<>());
						new BuyerView(loggedUser);
						return;
						
					}
				}
			}
		}
		bufferedReader.close();
		
	}

	private User getUser(String name, String password,List<User> userList) {
		for(User user : userList) {
			if(user.getName().equals(name) && decryptPassword(user.getPassword()).equals(password)) {
				return user;
			}
		}
		return null;
	}

	private String decryptPassword(String password) {
		char pass[] = password.toCharArray();
		for(int i =0;i<pass.length;i++) {
			pass[i] = (char)((pass[i] - 3));
		}
		return new String(pass);
	}

}

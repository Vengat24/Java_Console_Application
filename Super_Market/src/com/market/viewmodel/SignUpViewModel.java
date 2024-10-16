package com.market.viewmodel;

import java.io.FileOutputStream;
import java.io.IOException;

import com.market.dao.User;
import com.market.dao.Repository;

public class SignUpViewModel {

	Repository repository = Repository.getInstance();
	public SignUpViewModel(String name, String password,int isSeller) throws IOException {
		password = encryptPassword(password);
		User signup = new User(name,password,isSeller(isSeller));
		repository.addUser(signup,isSeller(isSeller));
		name += " ";
		password += " ";
		String src = "G:\\JavaConsole\\Super_Market\\src\\File.txt";
		FileOutputStream output = new FileOutputStream(src, true); // 'true' enables append mode
		output.write(name.getBytes());
		output.write(password.getBytes());
		output.write((isSeller+"").getBytes());
		output.write("\n".getBytes());
		output.close();
	}

	private boolean isSeller(int isSeller) {
		if(isSeller == 1) return true;
		return false;
	}

	private String encryptPassword(String password) {
		char pass[] = password.toCharArray();
		for(int i =0;i<pass.length;i++) {
			pass[i] = (char)((pass[i] + 3));
		}
		return new String(pass);
	}

}

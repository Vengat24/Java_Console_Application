package com.email.view;

import java.io.IOException;
import java.util.Scanner;

import com.email.viewmodel.DeleteMailViewModel;
public class DeleteMailView {
	
	String fromMail;
	String toMail;
	String content;
	DeleteMailView() throws IOException{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter From Mail-Id : ");
		fromMail = scanner.next();
		System.out.print("Enter To Mail-Id : ");
		toMail = scanner.next();
		System.out.print("Enter Your Content : ");
		scanner.nextLine();
		content = scanner.nextLine();
		new DeleteMailViewModel().deleteMail(fromMail, toMail, content);
		
	}

}

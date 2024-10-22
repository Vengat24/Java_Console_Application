package com.email.view;

import java.io.IOException;
import java.util.Scanner;

import com.email.viewmodel.MailViewModel;
import com.email.viewmodel.TagNameViewModel;

public class MailView {

	String fromMail;
	String toMail;
	String content;
	String tagName;
	MailView() throws IOException{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter From Mail-Id : ");
		fromMail = scanner.next();
		System.out.print("Enter To Mail-Id : ");
		toMail = scanner.next();
		System.out.print("Enter Your Content : ");
		scanner.nextLine();
		content = scanner.nextLine();
		System.out.println("Available Tags : ");
		TagNameViewModel tagNameViewModel = new TagNameViewModel();
		for(String str : tagNameViewModel.getTagName()) {
			System.out.println(str);
		}
		System.out.print("Enter Tag Name :");
		tagName = scanner.next();
		tagNameViewModel.checkTagName(tagName);
		new MailViewModel(fromMail, toMail, content,tagName);
		
	}
	
	public static void invalidMailId() {
		System.out.println("Sorry! Invalid Mail Id is Used!");
	}

}

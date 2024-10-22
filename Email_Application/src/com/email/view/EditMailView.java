 package com.email.view;

 import java.io.IOException;
 import java.util.Scanner;
 import com.email.viewmodel.EditMailViewModel;

 public class EditMailView {
	
 	String fromMail;
 	String toMail;
 	String content;
 	String oldContent;
 	String newContent;
 	EditMailView() throws IOException{
 		Scanner scanner = new Scanner(System.in);
 		System.out.print("Enter From Mail-Id : ");
 		fromMail = scanner.next();
 		System.out.print("Enter To Mail-Id : ");
 		toMail = scanner.next();
 		System.out.print("Enter Your Content : ");
 		scanner.next();
 		content = scanner.nextLine();
 		System.out.print("Enter Content To be Changed : ");
 		scanner.next();
 		oldContent = scanner.nextLine();
 		System.out.print("Enter Your new Content : ");
 		scanner.next();
 		newContent = scanner.nextLine();
 		new EditMailViewModel().editMail(fromMail+" ", toMail+" ", content,oldContent,newContent);
		
 	}
 }

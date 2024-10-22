package com.email.dto;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.email.view.MailView;

public class Repository {
	
	static Repository repository;
	public static String src;
	public static String tagname;
	public static List<MailView> impMail ;
	private Repository() {
		impMail = new ArrayList<>();
		src = "G:\\JavaConsole\\Email_Application\\src\\com\\email\\dto\\source.txt";
		tagname = "G:\\JavaConsole\\Email_Application\\src\\com\\email\\dto\\TagName.txt";
	}
	public static Repository getInstance() {
		if(repository == null) repository = new Repository();
		return repository;
	}
	public void addMail(String from,String to,String content,String tagName) throws IOException {
		FileOutputStream output = new FileOutputStream(src,true);
		output.write(from.getBytes());
		output.write(to.getBytes());
		output.write(content.getBytes());
		output.write(tagName.getBytes());
		output.write("\n".getBytes());
	}

}

package com.email.viewmodel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.email.dto.Repository;

public class TagNameViewModel {
	String src = Repository.getInstance().tagname;
	public List<String> getTagName() throws IOException {
		FileInputStream input = new FileInputStream(src);
		InputStreamReader reader= new InputStreamReader(input);
		BufferedReader read = new BufferedReader(reader);
		
		String current;
		List<String> list = new ArrayList<>();
		while((current=read.readLine()) != null) {
			list.add(current);
		}
		return list;
	}
	private void addTagName(String tagName) throws IOException {
		FileOutputStream output = new FileOutputStream(src,true);
		output.write(tagName.getBytes());
		output.write("\n".getBytes());
	}
	public void checkTagName(String tagName) throws IOException {
		FileInputStream input = new FileInputStream(src);
		InputStreamReader reader= new InputStreamReader(input);
		BufferedReader read = new BufferedReader(reader);
		
		String current;
		boolean isPresent = false;
		while((current=read.readLine()) != null) {
			if(current.equals(tagName)) {
				isPresent = true;
			}
		}
		if(!isPresent) {
			addTagName(tagName);
		}
		
	}
	
}

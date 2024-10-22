 package com.email.viewmodel;
 import java.io.BufferedReader;
 import java.io.BufferedWriter;
 import java.io.File;
 import java.io.FileInputStream;
 import java.io.FileNotFoundException;
 import java.io.FileWriter;
 import java.io.IOException;
 import java.io.InputStreamReader;

 import com.email.dto.Repository;


 public class EditMailViewModel {

 	public void editMail(String fromMail, String toMail, String content, String oldContent, String newContent) throws FileNotFoundException, IOException {
 		String src = Repository.getInstance().src;
        String temp = "G:\\JavaConsole\\Email_Application\\src\\com\\email\\dto\\temp.txt";
       
        try(
    		FileInputStream input = new FileInputStream(src);
    		InputStreamReader isr = new InputStreamReader(input);
    		BufferedReader read = new BufferedReader(isr);
    		BufferedWriter write = new BufferedWriter(new FileWriter(temp));
       		){
        	String current;
        	while((current=read.readLine()) != null) {
                String trimmed[] = current.split(" ");

                if (!(trimmed[0].equals(fromMail) && trimmed[1].equals(toMail) && trimmed[2].equals(content))) {
        			current = current.replace(oldContent, newContent);
        		}
        		write.write(current+ System.lineSeparator());
        	}
       	
        }
        File inputFile = new File(src);
        File tempFile = new File(temp);
        String filePath = "G:\\JavaConsole\\Email_Application\\src\\com\\email\\dto\\temp.txt";
       File file = new File(filePath);
        if (!inputFile.delete()) {
            System.out.println("Could not delete original file.");
        } else if (!tempFile.renameTo(inputFile)) {
            System.out.println("Could not rename temp file to original file.");
        } else {
            file.createNewFile();
            System.out.println("Mail deleted successfully and temp file renamed.");
        }
		
 	}

 }

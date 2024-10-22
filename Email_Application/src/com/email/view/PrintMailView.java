package com.email.view;
import java.util.Scanner;
import java.util.Collections;
import java.util.List;

import com.email.dto.Repository;
import com.email.viewmodel.PrintMailViewModel;
import java.io.IOException;
public class PrintMailView{
    String emailid;
    public PrintMailView() throws IOException{
      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter Your Mail-Id : ");
      emailid = scanner.next();
      printMail();
    }

    public void printMail() throws IOException{
      List<String> list  =  new PrintMailViewModel(emailid).printMailContent();

      for(String str : list){
        System.out.println(str);
      }
    }
  
}
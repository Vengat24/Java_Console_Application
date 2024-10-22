package com.email.view;
import java.util.Scanner;
import java.util.Collections;
import java.util.List;

import com.email.viewmodel.SearchMailViewModel;
import java.io.IOException;
public class SearchMail{
    String word;
    public SearchMail() throws IOException{
      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter Word to Search: ");
      word = scanner.next();
      printMail();
    }

    public void printMail() throws IOException{
      List<String> list  =  new SearchMailViewModel(word).searchMailContent();
      Collections.sort(list, (String x, String y) -> {
          // Check if x contains "Important"
          if (x.contains("Important") && !y.contains("Important")) {
              return -1; // x goes after y
          } else if (!x.contains("Important") && y.contains("Important")) {
              return 1; // x goes before y
          } else {
              return x.compareTo(y); // Regular alphabetical order
          }
      });

      
      for(String str : list){
        System.out.println(str);
      }
    }
  
}
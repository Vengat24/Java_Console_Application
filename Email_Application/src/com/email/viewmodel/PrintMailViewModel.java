package com.email.viewmodel;
 import java.io.BufferedReader;
 import java.io.FileInputStream;
 import java.io.InputStreamReader;
 import java.util.List;

 import com.email.dto.Repository;
import java.io.IOException;
import java.util.ArrayList;
public class PrintMailViewModel{
  String email ;
  public PrintMailViewModel(String email){
    this.email = email;
  } 

 public List<String> printMailContent() throws IOException{
  String src = Repository.getInstance().src;
  FileInputStream input = new FileInputStream(src);
  InputStreamReader reader = new InputStreamReader(input);
  BufferedReader bufferedReader = new BufferedReader(reader);
  String current;
  List<String> list = new ArrayList<>();
  while ((current = bufferedReader.readLine()) != null) {
      String arr[] = current.split(" ");
      if(arr[0].equals(email)){
        list.add(current);
      }
  }
  return list; 
 } 
}
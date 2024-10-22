package com.email.viewmodel;
 import java.io.BufferedReader;
 import java.io.FileInputStream;
 import java.io.InputStreamReader;
 import java.util.List;

 import com.email.dto.Repository;
import java.io.IOException;
import java.util.ArrayList;
public class SearchMailViewModel{
  String word ;
  public SearchMailViewModel(String word){
    this.word = word;
  } 

 public List<String> searchMailContent() throws IOException{
  String src = Repository.getInstance().src;
  FileInputStream input = new FileInputStream(src);
  InputStreamReader reader = new InputStreamReader(input);
  BufferedReader bufferedReader = new BufferedReader(reader);
  String current;
  List<String> list = new ArrayList<>();
  while ((current = bufferedReader.readLine()) != null) {
      if(current.contains(word) || searchOnRegular(current.split(" ")[0])){
        list.add(current);
      }
  }
  return list; 
 }

 private boolean searchOnRegular(String string) {
	    int i = 0;
	    int j = 0;

	    while (i < string.length() && j < word.length()) {
	        if (word.charAt(j) == '*') {
	            j++;
	            if (j == word.length()) return true;
	            while (i < string.length() && string.charAt(i) != word.charAt(j)) {
	                i++;
	            }
	        } else if (word.charAt(j) == '+') {
	            j++;
	            if (j == word.length()) return true;
	            if (i >= string.length()) return false;
	            i++;
	            while (i < string.length() && string.charAt(i) != word.charAt(j)) {
	                i++;
	            }
	        } else {
	            if (string.charAt(i) == word.charAt(j)) {
	                i++;
	                j++;
	            } else {
	                return false;
	            }
	        }
	    }

	    return i == string.length() && j == word.length();
	}


}
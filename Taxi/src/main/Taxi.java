package main;


import java.util.ArrayList;
import java.util.List;

public class Taxi {
	  int id;
      char currentpoint='A';
      int freeTime=9;
      int earnings=0;
      List<Details> details;
      static int totalTaxi=1;
      Taxi(){
    	  details=new ArrayList<>();
    	  this.id=totalTaxi;
    	  totalTaxi++;
      }
      public void booked(char from,char to,int start,int end,int amount) {
    	  int id=this.details.size()+1;
    	  Details data=new Details(id,id,from,to,start,end,amount);
    	  details.add(data);
      }
}
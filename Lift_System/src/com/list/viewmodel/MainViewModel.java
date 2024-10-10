package com.list.viewmodel;

import com.lift.dao.Repository;

public class MainViewModel {
	Repository repository ;
	public MainViewModel(){
		repository = Repository.getInstance();
	}
	//module 1
	public int[] getLift() {
		return repository.getLift();
	}
	
	public int assignLift(int start, int end) {
		int lift[] = repository.getLift();
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		int minStops = Integer.MAX_VALUE;
		for(int i =0;i<lift.length;i++) {
			//module 5
			int val = Math.abs(start - lift[i]);
			//module 8
			if(lift[i] == -1 || !checkLift(i+1,start,end)) {
				continue;
			}
			//module 6
			int noOfStops = generateStops(i+1,start,end,lift);
			//module 4
			if(val == min && minStops > noOfStops) {
				if((lift[i] > start && lift[i] > end )||(lift[i] < start && lift[i] < end)) {
					min = val;
					minIndex = i;
					minStops = noOfStops;
				}
			}
			//module 3
			if(val < min && minStops > noOfStops) {
				min = val;
				minIndex = i;
				minStops = noOfStops;
			}
		}
		//module 2
		if(minIndex != -1) lift[minIndex] = end;
		return minIndex+1;
	}
	private int generateStops(int i, int start, int end,int[] lift) {
		switch(i) {
		case 1:
		case 2:
			if(start<=5 && end <=5) return Math.abs(end - start);
			break;
		case 3:
		case 4:
			if((start >= 6||start==0) && start<=10 && (end>= 6 || end==0) &&end <=10) {
				if(start == 0) return lift[i-1]+ Math.abs(end - 6)+1;
				else if(end == 0) return Math.abs(start - lift[i-1])+1;
				return Math.abs(end - start);
			}
			break;
		case 5:
			return Math.abs(end - start);
		}
		return 0;
	}
	private boolean checkLift(int i, int start, int end) {
		switch(i) {
		case 1:
		case 2:
			if(start<=5 && end <=5) return true;
			break;
		case 3:
		case 4:
			if((start >= 6||start==0) && start<=10 && (end>= 6 || end==0) &&end <=10) return true;
			break;
		case 5:
			return true;
		}
		return false;
	}

}

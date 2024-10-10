package com.zsgs.taxi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Repository {
	static Repository repository ; 
	char taxiList[][];
	
	List<Taxi> taxi = new ArrayList<>();
	boolean taxiBookedList[][];
	private Repository() {
		for(int i=0;i<4;i++) {
			taxi.add(new Taxi());
		}
		taxiList = new char[4][];
		taxiBookedList = new boolean[4][];
		for(int i=0;i<4;i++) {
			taxiBookedList[i] = new boolean[24];
			taxiList[i] = new char[24];
		}
		
		for(int i=0;i<taxiList.length;i++) {
			for(int j=0;j<taxiList[i].length;j++) {
				taxiList[i][j] = '.';
			}
		}
		
	}
	public static Repository getInstance() {
		if(repository == null)
			repository = new Repository();
		return repository;
	}
	public void display() {
		for(int i=1;i<=24;i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		for(int i=0;i<taxiList.length;i++) {
			for(int j=0;j<taxiList[i].length;j++) {
				if(j>=9) {
					System.out.print(" ");
				}
				System.out.print(taxiList[i][j] + " ");
			}
			System.out.println();
		}
		
		for(int i=0;i<taxiList.length;i++) {
			for(int j=0;j<taxiList[i].length;j++) {
				if(j>=9) {
					System.out.print(" ");
				}
				if(taxiBookedList[i][j])
					System.out.print(1 + " ");
				else
					System.out.print(0 + " ");
					
			}
			System.out.println();
		}
	}
	public void displayTaxi() {
		for(Taxi taxiName : taxi) {
			
			taxiName.displayTaxi();
		}
		System.out.println("-----------------------------------------------------");
	}
	public int book(int customerId, char pickUpPoint, char dropPoint, int pickUpTime) {
		int taxiNo = searchTaxi(pickUpTime-1,pickUpPoint,dropPoint);
		if(taxiNo == -1)
			return -1;
		for(int i=pickUpTime-1;i<taxiList[taxiNo].length;i++) {
			taxiList[taxiNo][i] = dropPoint;
		}
		for(int i=pickUpTime-1;i<pickUpTime + (dropPoint-pickUpPoint)-1;i++) {
			taxiBookedList[taxiNo][i] = true;
		}
		
		return taxiNo;
	}
	private int searchTaxi(int pickUpTime,char pickUpPoint, char dropPoint) {
		int arr[] = new int[4];
		Arrays.fill(arr, -1);
		for(int j=0;j<taxiBookedList.length;j++) { 
			boolean isFree = true;
			for(int i=pickUpTime;i<pickUpTime + (dropPoint-'A');i++) {
				if(taxiBookedList[j][i]) {
					isFree = false;
				}
			}
			if(isFree) {
				arr[j] = Math.abs(pickUpPoint - taxiList[j][pickUpTime]);
			}
		}
		int min =Integer.MAX_VALUE;
		int minIndex = -1;
		for(int x=0;x<arr.length;x++) {
			if(arr[x] == -1)
				continue;
			if(min > arr[x]) {
				min = arr[x];
				minIndex = x;
			}
			for(int y=x+1;y<arr.length;y++) {
				if(arr[y] == -1)
					continue;
				if(arr[x] == arr[y]) {
					if(taxi.get(x).getEarning() < taxi.get(y).getEarning() ) {
						if(min > arr[x]) {
							min = arr[x];
							minIndex = x;
						}
					}else {
						if(min > arr[y]) {
							min = arr[y];
							minIndex = y;
						}
					}
				}else {
					if(min > arr[y]) {
						min = arr[y];
						minIndex = y;
					}
				}
			}
		}
		return minIndex;
	}
	
}

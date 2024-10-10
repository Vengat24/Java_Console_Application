package com.zsgs.taxi;

import java.util.Scanner;

public class Booking {

	private int customerId;
	private char pickUpPoint;
	private char dropPoint;
	private int pickUpTime;
	private int taxiNo;
	private static int idGen = 1;
	private int bookingId;
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public char getPickUpPoint() {
		return pickUpPoint;
	}

	public void setPickUpPoint(char pickUpPoint) {
		this.pickUpPoint = pickUpPoint;
	}

	public char getDropPoint() {
		return dropPoint;
	}

	public void setDropPoint(char dropPoint) {
		this.dropPoint = dropPoint;
	}

	public int getPickUpTime() {
		return pickUpTime;
	}

	public void setPickUpTime(int pickUpTime) {
		this.pickUpTime = pickUpTime;
	}

	public int getTaxiNo() {
		return taxiNo;
	}

	public void setTaxiNo(int taxiNo) {
		this.taxiNo = taxiNo;
	}

	Booking(){
		System.out.println("-----------------------------------------------------");
		Scanner scanner = new Scanner(System.in);
		System.out.print("Customer ID : ");
		customerId = scanner.nextInt();
		System.out.print("Pickup Point : ");
		pickUpPoint = scanner.next().charAt(0);
		System.out.print("Drop Point : ");
		dropPoint = scanner.next().charAt(0);
		System.out.print("Pickup Time : ");
		pickUpTime = scanner.nextInt();
		bookTaxi();
		bookingId = idGen++;
		
		Repository.getInstance().taxi.get(taxiNo-1).earningList.add(new TaxiEarning(bookingId,customerId,pickUpPoint,dropPoint,pickUpTime));
	}
	
	private void bookTaxi() {
		System.out.println("-----------------------------------------------------");
		taxiNo = Repository.getInstance().book(customerId,pickUpPoint,dropPoint,pickUpTime)+1;
		if(taxiNo != -1) {
			System.out.println("Taxi can be allotted");
			System.out.println("Taxi-"+ taxiNo + " is allotted");
		}else {
			System.out.println("No Taxi is Available..!");
		}
		System.out.println("-----------------------------------------------------");
	}
}

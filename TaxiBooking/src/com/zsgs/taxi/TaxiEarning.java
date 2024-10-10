package com.zsgs.taxi;

public class TaxiEarning {
	private int bookingId;
	private int customerId;
	private char pickUpPoint;
	private char dropPoint;
	private int pickUpTime;
	private int dropTime;
	private int earning;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

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

	public int getDropTime() {
		return dropTime;
	}

	public void setDropTime(int dropTime) {
		this.dropTime = dropTime;
	}

	public int getEarning() {
		return earning;
	}

	public void setEarning(int earning) {
		this.earning = earning;
	}

	
	public TaxiEarning(int bookingId, int customerId, char pickUpPoint, char dropPoint, int pickUpTime) {
		this.bookingId = bookingId;
		this.customerId = customerId;
		this.pickUpPoint = pickUpPoint;
		this.dropPoint = dropPoint;
		this.pickUpTime = pickUpTime;
		
		dropTime = pickUpTime + (dropPoint - pickUpPoint);
		earning = ((Math.abs(pickUpPoint - dropPoint) * 15) - 5 )*10 + 100;
	}

}








package main;

public class Details {
      int bookingId;
      int customerId;
      char from;
      char to;
      int pickUpTime;
      int dropTime;
      int amount;
	public Details(int bookingId, int customerId, char from, char to, int pickUpTime, int dropTime, int amount) {
		super();
		this.bookingId = bookingId;
		this.customerId = customerId;
		this.from = from;
		this.to = to;
		this.pickUpTime = pickUpTime;
		this.dropTime = dropTime;
		this.amount = amount;
	}
	public String toString() {
		return bookingId+"                  "+customerId
				+"      "+from+"    "+to+"     "
	        +pickUpTime+"     "+dropTime+
				"    "+amount;
	}
}
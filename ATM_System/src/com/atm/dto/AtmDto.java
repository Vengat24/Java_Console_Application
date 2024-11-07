package com.atm.dto;

import java.util.ArrayList;
import java.util.List;

import com.atm.view.AtmView;

public class AtmDto {
	private static int Amount;
	private static int thousandCount;
	private static int fiveHundredCount;
	private static int hundredCount;
	
	private static AtmDto atm;
	
	private List<User> userList;
	
	private AtmDto() {
		userList = new ArrayList<>();
	}
	public void loadMoney() {
		AtmView atmview = new AtmView();
		Amount = atmview.getAmt();
		feedMoney(Amount);
	}
	private void feedMoney(int amt) {
		thousandCount = (amt *20) / 100;
		hundredCount = (amt * 40) / 100;
		fiveHundredCount = hundredCount;
	}
	public static AtmDto getAtm() {
		if(atm == null) atm = new AtmDto();
		return atm;
	}
	
	public List<User> getUserList(){
		return userList;
	}
	
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
	public int getThousandCount() {
		return thousandCount;
	}
	public void setThousandCount(int thousandCount) {
		this.thousandCount = thousandCount;
	}
	public int getFiveHundredCount() {
		return fiveHundredCount;
	}
	public void setFiveHundredCount(int fiveHundredCount) {
		this.fiveHundredCount = fiveHundredCount;
	}
	public int getHundredCOunt() {
		return hundredCount;
	}
	public void setHundredCOunt(int hundredCOunt) {
		this.hundredCount = hundredCOunt;
	}
	public static boolean checkBalance(int withdrawamt) {
		if(withdrawamt > Amount) return false;
		if(withdrawamt < 5000) {
			return thousandCount >= 3 && hundredCount > 6 && fiveHundredCount > 6;
		}else {
			return thousandCount > 5 && hundredCount > 10 && fiveHundredCount > 10;
		}
	}
	public static int[] debitMoney(int withdrawamt) {
		int thousandDebitCount = 0;
		int hundredDebitCount = 0;
		int fiveHundredDebitCount =0;
		
		while(1000 <= withdrawamt) {
			withdrawamt -= 1000;
			thousandDebitCount++;
		}
		while(500 <= withdrawamt) {
			withdrawamt -= 500;
			fiveHundredDebitCount++;
		}
		while(100 <= withdrawamt) {
			withdrawamt -= 100;
			hundredDebitCount++;
		}
		if(withdrawamt != 0) {
			return null;
		}else {
			return new int[] {hundredDebitCount,fiveHundredDebitCount,thousandDebitCount};
		}
	}
	

}

package com.invoice.view;

import java.util.List;
import java.util.Scanner;

import com.invoice.dto.Item;
import com.invoice.dto.Repository;
import com.invoice.viewmodel.InvoiceViewModel;

public class InvoiceView {
	Repository repo = Repository.getInstance();
	Scanner scanner = new Scanner(System.in);
	public int cusId;
	InvoiceView(boolean newInvoice){
		if(newInvoice) {
			int ch;
			System.out.println("1)Existing Customer  2)New Customer");
			System.out.print("Enter Your Choice : ");
			ch = scanner.nextInt();
			if(ch == 1) {
				System.out.print("Enter Customer Id : ");
				cusId = scanner.nextInt();
			}else {
				CustomerView customer = new CustomerView();
				cusId = customer.cusId;
			}
		}
		InvoiceViewModel invoice = new InvoiceViewModel(this,newInvoice);
		
	}
	public void displayItems() {
		List<Item> itemList = repo.getItemList();
		System.out.println("Select the Items");
		for(Item item : itemList) {
			System.out.println(item.getId()+"."+item.getItemName()+" Rs."+item.getPrice());
		}
		
	}
	public boolean getContinue() {
		int ch;
		System.out.print("Are you want to add one more item / yes 1 or no 0 : ");
		ch = scanner.nextInt();
		return ch == 1;
		
	}
	public void displayInvoiceNo(int id) {
		System.out.println("Your Invoice No : " + id);
	}
	public int getInvoiceNo() {
		System.out.print("Enter Invoice Number : ");
		return scanner.nextInt();
	}
	

}

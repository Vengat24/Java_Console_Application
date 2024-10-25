package com.invoice.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.invoice.dto.Customer;
import com.invoice.dto.Invoice;
import com.invoice.dto.Item;
import com.invoice.dto.Repository;

public class MainView {
	static Repository repo = Repository.getInstance();
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		loadInvoice();
		int ch;
		while(true) {
			System.out.println(" 1)Add Customer \n 2)Add Invoice \n 3)Add Item to Invoice \n 4)List all Customers \n 5)List all Invoice \n 6)List all Invoice of a Customer \n 7)Display an Invoice");
			System.out.print("Enter Your Choice : ");
			ch = scanner.nextInt();
			switch(ch) {
			case 1:
				CustomerView customer = new CustomerView();
				break;
			case 2:
				InvoiceView invoice = new InvoiceView(true);
				break;
			case 3:
				invoice = new InvoiceView(false);
				break;
			case 4:
				List<Customer> cusList = repo.getCustomerList();
				if(cusList.size() == 0) {
					System.out.println("No Data Found!");
					break;
				}
				System.out.println("Cus_Id   Cust_name      Mobile       Address");
				for(Customer cus : cusList) {
					System.out.printf("%-8s %-14s %-12s %-30s%n", cus.getCusId(), cus.getName(), cus.getPhoneNo(), cus.getAddress());
				}
				break;
			case 5:
				List<Invoice> invoiceList = repo.getInvoiceList();
				System.out.println("------------------------------------");
				if(invoiceList.size() == 0) {
					System.out.println("No Data Found!");
					System.out.println("------------------------------------");
					break;
				}
				for(Invoice invc : invoiceList) {
					System.out.println("Invoice No : " + invc.getId());
					System.out.println("Customer No : " + invc.getCusId());
					displayInvoice(invc);
				}
				System.out.println("-------------------------------------");
				break;
			case 6:
				System.out.print("Enter Customer Id : ");
				int cusId = scanner.nextInt();
				List<Invoice> cusInvoiceList = new ArrayList<>();
				for(Invoice inv : repo.getInvoiceList()) {
					if(inv.getCusId() == cusId) {
						cusInvoiceList.add(inv);
					}
				}
				System.out.println("------------------------------------");
				if(cusInvoiceList.size() == 0) {
					System.out.println("No Data Found!");
					System.out.println("------------------------------------");
					break;
				}
				int totalitem=0;
				int totalprice = 0;
				for(Invoice in : cusInvoiceList) {
					
					int[] res = displayInvoice(in);
					totalitem += res[0];
					totalprice += res[1];
				}
				System.out.println("Total Nomber of Items Bought by this customer : "+totalitem);
				System.out.println("Total amount spent by this customer : "+ totalprice);
				System.out.println("-------------------------------------");
				break;
			case 7:
				System.out.print("Enter Invoice No : ");
				int invoiceNo = scanner.nextInt();
				displayInvoice(repo.getInvoiceList().get(invoiceNo-1));
				break;
			default : 
				System.out.println("Thank You Visit Again");
				System.exit(0);
			}
		}
	}

	private static int[] displayInvoice(Invoice invc) {
		System.out.println("------------------------------");
		System.out.println("item_Name   unit_price   No_Of_Item");
		int totalItem = 0;
		int totalPrice = 0;
		int itemArr[] = invc.itemArr;
		for(int i=0;i<itemArr.length;i++) {
			if(itemArr[i] !=0) {
				totalItem += itemArr[i];
				Item item = repo.getItemList().get(i);
				totalPrice += item.getPrice();
				System.out.println(item.getItemName() + "   "+item.getPrice()+"   "+itemArr[i]);
			}
		}
		
		System.out.println("-------------------------------");
		System.out.println("TotalItems : "+totalItem + "    Total Price  : "+totalPrice);
		System.out.println("-------------------------------");
		return new int[] {totalItem,totalPrice};
		
	}

	private static void loadInvoice() {
		Item item1 = new Item("Headphone",400);
		Item item2 = new Item("Speaker",1000);
		Item item3 = new Item("SD Card",500);
		Item item4 = new Item("Battery",6000);
		
		
		repo.addItem(item1);
		repo.addItem(item2);
		repo.addItem(item3);
		repo.addItem(item4);
	
		
		
	}

}

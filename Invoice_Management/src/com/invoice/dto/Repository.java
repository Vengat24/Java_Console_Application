package com.invoice.dto;

import java.util.ArrayList;
import java.util.List;

public class Repository {
	static Repository repo ;
	List<Customer> cusList;
	List<Invoice> invoiceList;
	List<Item> itemList;
	private Repository() {
		cusList = new ArrayList<>();
		invoiceList = new ArrayList<>(); 
		itemList = new ArrayList<>();
	}
	public static Repository getInstance() {
		if(repo == null) repo = new Repository();
		return repo;
	}
	public void addCustomer(Customer customer) {
		cusList.add(customer);		
	}
	public void addItem(Item item) {
		itemList.add(item);
	}
	public List<Item> getItemList() {
		return itemList;
	}
	public List<Customer> getCustomerList() {
		return cusList;
	}
	public List<Invoice> getInvoiceList() {
		return invoiceList;
	}
	public void addInvoice(Invoice invoice) {
		invoiceList.add(invoice);
		
	}

}

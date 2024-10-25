package com.invoice.viewmodel;

import java.util.Arrays;
import java.util.Scanner;

import com.invoice.dto.Invoice;
import com.invoice.dto.Repository;
import com.invoice.view.InvoiceView;

public class InvoiceViewModel {
	Repository repo = Repository.getInstance();
	Scanner scanner = new Scanner(System.in);
	public InvoiceViewModel(InvoiceView invoiceView,boolean newInvoice) {
		Invoice invoice ;
		if(newInvoice) {
			invoice = new Invoice(invoiceView.cusId);
		}else {
			int invoiceNo = invoiceView.getInvoiceNo();
			invoice = repo.getInvoiceList().get(invoiceNo);
		}
		
		while(true) {
			invoiceView.displayItems();
			System.out.print("Enter Your Choice : ");
			int itemNo = scanner.nextInt();
			invoice.itemArr[itemNo-1]++;
			if(!invoiceView.getContinue()){
				break;
			}
		}
		if(newInvoice) {
			invoiceView.displayInvoiceNo(invoice.getId());
			repo.addInvoice(invoice);
		}
	}
	

}

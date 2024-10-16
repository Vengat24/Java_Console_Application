package com.market.view;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.market.dao.Product;
import com.market.dao.User;
import com.market.viewmodel.SellerViewModel;

public class SellerView {

	public SellerView(User loggedUser) throws IOException {
		Scanner scanner = new Scanner(System.in);
		SellerViewModel sellerViewModel = new SellerViewModel(loggedUser);
		outer : while(true) {
			System.out.println("1)View Items  2)Add Items");
			System.out.println("Enter your Choice : ");
			int ch = scanner.nextInt();
			switch(ch) {
			case 1:
				List<Product> cart = loggedUser.getCart();
				for(Product pro : cart) {
					System.out.println(pro.getName()+" "+pro.getPrice());
				}
				break;
			case 2:
				System.out.print("Enter Product Name : ");
				String itemName = scanner.next();
				System.out.print("Enter Product Price : ");
				int price = scanner.nextInt();
				sellerViewModel.addItem(itemName,price);
				break;
			default:
				break outer;
			}
		}
	}
}

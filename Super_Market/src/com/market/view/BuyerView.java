package com.market.view;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.market.dao.Product;
import com.market.dao.Repository;
import com.market.dao.User;
import com.market.viewmodel.BuyerViewModel;

public class BuyerView {

	Repository repository = Repository.getInstance();
	static Scanner scanner = new Scanner(System.in);
	public BuyerView(User loggedUser) throws IOException {
		outer : while(true) {
			System.out.println("1)Order Items  2)View Cart");
			System.out.println("Enter your Choice : ");
			int ch = scanner.nextInt();
			switch(ch) {
			case 1:
				List<User> sellerList = repository.getSellerList();
				int id = 1;
				for(User seller : sellerList) {
					System.out.println(id++ + " " + seller.getName());
				}
				System.out.print("Choose Seller : ");
				int sellerId = scanner.nextInt();
				BuyerViewModel buyer = new BuyerViewModel(sellerId,loggedUser);
				break;
			case 2:
				BuyerViewModel.displayCart(loggedUser);
				break;
			default :
				break outer;
			}
		}
	}
	public static int printItems(User seller) {
		int id = 1;
		for(Product pro : seller.getCart()) {
			System.out.println(id++ +" "+pro.getName()+" "+pro.getPrice());
		}
		System.out.print("Enter Product Id : ");
		int proId = scanner.nextInt();
		return proId;
	}
	

}

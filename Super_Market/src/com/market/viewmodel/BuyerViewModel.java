package com.market.viewmodel;

import java.io.IOException;
import java.util.List;

import com.market.dao.Product;
import com.market.dao.Repository;
import com.market.dao.User;
import com.market.view.BuyerView;

public class BuyerViewModel {
	Repository repository = Repository.getInstance();
	public BuyerViewModel(int sellerId,User user) throws IOException {
		List<User> sellerList = repository.getSellerList();
		User seller = sellerList.get(sellerId-1);
		int itemId = BuyerView.printItems(seller);
		user.getCart().add(seller.getCart().get(itemId-1));
	}
	public static void displayCart(User loggedUser) {
		int total = 0;
		for(Product pro : loggedUser.getCart()) {
			total += pro.getPrice();
			System.out.println(pro.getName() + " "+ pro.getPrice());
		}
		System.out.println("Total : "+ total);
		
	}

}

package com.market.viewmodel;

import java.io.IOException;
import java.util.List;

import com.market.dao.Product;
import com.market.dao.Repository;
import com.market.dao.User;

public class SellerViewModel {

	User loggedUser;
	public SellerViewModel(User loggedUser) {
		this.loggedUser = loggedUser;
	}


	public void addItem(String itemName, int price) throws IOException {
		List<Product> cart = loggedUser.getCart();
		Repository.getInstance().addToCart(loggedUser,itemName,price);
		cart.add(new Product(itemName,price));
		
	}

}

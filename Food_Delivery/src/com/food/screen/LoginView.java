package com.food.screen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.food.dao.AgentDao;
import com.food.dao.CartDao;
import com.food.dao.Repository;
import com.food.dao.RestaurantDao;
import com.food.dao.RestaurantDao.Menu;
import com.food.dao.User;
import com.food.viewmodel.BookOrder;
import com.food.viewmodel.LoginViewModel;
import com.food.viewmodel.RestaurantViewModel;

public class LoginView {
	Scanner scanner = new Scanner(System.in);
	public void login() {
		System.out.println("User Type : 1)Admin  2)Customer  3)Delivery Agent");
		System.out.print("Enter your choice : ");
		int ch = scanner.nextInt();
		if(ch<=0 || ch>3) {
			System.out.println("------------------------------------------");
			return;
		}
		System.out.print("Enter your name :");
		String name = scanner.next();
		System.out.print("Enter Password : ");
		String password = scanner.next();
		LoginViewModel loginViewModel = new LoginViewModel();
		User loggedUser = loginViewModel.checkUser(ch,name,password);
		System.out.println("------------------------------------------");
		if(loggedUser != null) {
			System.out.println("Welcome back "+ name);
			if(ch == 1) {
				Admin admin = loginViewModel.getAdmin(loggedUser);
				admin.main();
				return;
			}
			else if(ch == 3) {
				System.out.println("1)Reset Status 2)Logout");
				if(scanner.nextInt() == 1) {
					AgentDao agent = loginViewModel.getAgent(loggedUser);
					agent.setStatus(true);
					System.out.println("Status Reseted Successfully..");
				}
				return;
			}
			CartDao cart =null;
		outer :while(true) {
				System.out.println("------------------------------------------");
				System.out.println("1)View Restaurant  2)View Cart  3)Check Out");
				System.out.print("Enter your choice : ");
				int op = scanner.nextInt();
				int resId=0;
				switch(op) {
				case 1:
					RestaurantView resView = new RestaurantView();
						resView.displayRestaurant(loggedUser);
						System.out.println("------------------------------------------");
						System.out.print("Enter Restaurant Id to view Menu or 0 to go back : ");
						resId = scanner.nextInt();
						if(resId != 0) {
							resView.displayMenu(resId);
					inner:	while(true) {
						System.out.println("------------------------------------------");
								System.out.print("Enter Menu id to Order or 0 to go back : ");
								int menuId = scanner.nextInt();				
								if(menuId != 0) {					
									Menu menu = new RestaurantViewModel().getMenu(resId, menuId);
									if(cart == null) {
										cart = new CartDao(loggedUser,resId,menu,false);
									}		
									else {
										cart.addMenu(menu);
									}
									System.out.println("Added to cart");
									System.out.println("------------------------------------------");
								}else {
									break inner;
								}
							}
						}else {
							break;
						}
					break;
				case 2:
					int menuno = 1;
					System.out.println("------------------------------------------");
					if(cart == null) {
						System.out.println("Cart is Empty !");
						break;
					}
					List<Menu> menuList = cart.getMenulist();
					for(Menu menu : menuList) {
						System.out.println(menuno++ +" "+menu.getMenuName()+" "+menu.getPrice());
					}
					System.out.println("Total : "+cart.getTotal());
					break;
				case 3:
					System.out.println("------------------------------------------");
					if(resId == -1||cart == null) {
						System.out.println("No item is Added to cart");
						break;
					}
					int userloc[] =loggedUser.getLoc();
					RestaurantDao res =  repository.getRestaurantList().get(resId);
					int resloc[] = res.getLocation();
					float total = (resloc[0]-userloc[0])*(resloc[0]-userloc[0]) + (resloc[1]-userloc[1])*(resloc[1]-userloc[1]);
					total = ((float) Math.sqrt(total) * 10 )+ cart.getTotal() ;
					System.out.printf("Total Cost : %.2f \n" ,total);
					System.out.println("------------------------------------------");
					System.out.println("1)Book Order  2)Cancel Order");
					int or = scanner.nextInt();
					if(or == 1) {
						BookOrder book = new BookOrder(loggedUser,cart,res);
						AgentDao agent = book.getAgent();
						if(agent == null) {
							System.out.println("Sorry No Agent is Available!");
						}else {
							System.out.println("Your order will be delivered by " +agent.getUserName());
						}
						System.out.println("------------------------------------------");
						
					}
						resId = -1;
						cart = null;
					break;
				default :
					break outer;
				}
			}
		}else {
			System.out.println("Invalid User ");
			login();
		}
	}
	static Repository repository = Repository.getInstance();
	public void displayUser() {
		System.out.println("Admin : ");
		for (User admin : repository.getAdminList()) {
			int loc[] = admin.getLoc();
	         System.out.println(admin.getUserName()+" "+admin.getPassword()+" ("+loc[0] + ","+loc[1] + ")");
	    }
		System.out.println("Customers : ");
		for (User cus : repository.getCusList()) {
			int loc[] = cus.getLoc();
	         System.out.println(cus.getUserName()+" "+cus.getPassword()+" "+" ("+loc[0] + ","+loc[1] + ")");
	    }
		System.out.println("Agent : ");
		for (AgentDao agent : repository.getAgentList()) {
			int loc[] = agent.getLoc();
		     System.out.println(agent.getAgentId()+" "+agent.getUserName()+" "+agent.getPassword()+" ("+loc[0] + ","+loc[1] + ")"+" "+agent.getStatus());
		}
	}
}












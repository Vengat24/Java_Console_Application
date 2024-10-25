package com.invoice.dto;

public class Invoice {
	Repository repo = Repository.getInstance();
	private static int genId = 0;
	private int id;
	private int cusId;
	public int[]itemArr;

	public Invoice(int cusId) {
		this.cusId = cusId;
		itemArr = new int[repo.getItemList().size()];
		id = genId++;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
	public int getCusId() {
		return cusId;
	}

	public void setCusId(int cusId) {
		this.cusId = cusId;
	}

	public void setId(int id) {
		this.id = id;
	}


}

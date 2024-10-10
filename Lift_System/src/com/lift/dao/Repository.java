package com.lift.dao;

public class Repository {
	private static Repository repository;
	private static int lift[];
	private Repository() {
		lift = new int[5];
	}
	public static Repository getInstance() {
		if(repository == null)
			repository = new Repository();
		return repository;
	}
	public int[] getLift() {
		return lift;
	}
}

package com.game;

public class Repository {
	static private int boxSize = 3;
	static private char[][] box = new char[boxSize][boxSize];
	static Repository repository;
	private Repository() {
		for(int i = 0;i<box.length;i++){
			for(int j=0;j<box.length;j++) {
				box[i][j]= '-';
			}
		}
	}
	public int getBoxSize() {
		return boxSize;
	}
	public static Repository getInstance() {
		if(repository == null) {
			repository = new Repository();
		}
		return repository;
	}
	public void displayBox() {
		for(int i = 0;i<box.length;i++){
			for(int j=0;j<box.length;j++) {
				System.out.print(box[i][j] +" ");
			}
			System.out.println();
		}
	}
	public char[][] getBox(){
		return box;
	}
}

package model;

import java.io.Serializable;

public class CandyMachine extends Machine implements Serializable{
	
	private Candy firstCandy;
	
	public CandyMachine() {
		super();
		firstCandy = null;
	}

	public Candy getFirstCandy() {
		return firstCandy;
	}

	public void setFirstCandy(Candy firstCandy) {
		this.firstCandy = firstCandy;
	}
}

package model;

public class CandyMachine extends Machine {
	
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

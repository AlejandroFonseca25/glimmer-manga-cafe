package model;

@SuppressWarnings("serial")
public class HardCandy extends Candy{
	
	private boolean acid;
	private boolean stuffed;
	
	public HardCandy(String name, String brand, int quantity, int price, double sugarQuantity, boolean acid, boolean stuffed) {
		super(name, brand, quantity, price, sugarQuantity);
		this.acid = acid;
		this.stuffed = stuffed;
	}

}

package model;

@SuppressWarnings("serial")
public class SoftCandy extends Candy{
	
	private boolean milk;
	
	public SoftCandy(String name, String brand, int quantity, String sugarQuantity, int price, boolean milk) {
		super(name, brand, quantity, sugarQuantity, price);
		this.setMilk(milk);
	}

	public boolean isMilk() {
		return milk;
	}

	public void setMilk(boolean milk) {
		this.milk = milk;
	}
	
}

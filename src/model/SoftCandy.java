package model;

@SuppressWarnings("serial")
public class SoftCandy extends Candy{
	
	private boolean milk;
	
	public SoftCandy(String name, String brand, int quantity, int price, double sugarQuantity, boolean milk) {
		super(name, brand, quantity, price, sugarQuantity);
		this.milk = milk;
	}
	
}

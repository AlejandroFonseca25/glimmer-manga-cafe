package model;

public class Drink extends FoodType{
	
	private boolean carbonated;
	private double milliliters;
	
	public Drink(String name, String brand, int quantity, int price, boolean carbonated, 
			double milliliters) {
		super(name, brand, quantity, price);
		this.carbonated = carbonated;
		this.milliliters = milliliters;
	}

	public boolean isCarbonated() {
		return carbonated;
	}

	public double getMilliliters() {
		return milliliters;
	}

	public void setCarbonated(boolean carbonated) {
		this.carbonated = carbonated;
	}

	public void setMilliliters(double milliliters) {
		this.milliliters = milliliters;
	}	
}

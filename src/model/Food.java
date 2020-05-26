package model;

import interfaces.Calculable;

@SuppressWarnings("serial")
public class Food extends FoodType implements Calculable{
	
	private boolean gluten;
	private double grams;
	
	public Food(String name, String brand, int quantity, int price, boolean gluten, double grams) {
		super(name, brand, quantity, price);
		this.gluten = gluten;
		this.grams = grams;
		calculateIVA();
	}

	public boolean isGluten() {
		return gluten;
	}

	public double getGrams() {
		return grams;
	}

	public void setGluten(boolean gluten) {
		this.gluten = gluten;
	}

	public void setGrams(double grams) {
		this.grams = grams;
	}

	@Override
	public void calculateIVA() {
		this.setPrice(this.getPrice() + (this.getPrice()*0.19));
		
	}
}

package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FoodMachine extends Machine implements Serializable{
	
	private FoodType firstFood;
	
	public FoodMachine() {
		super();
		firstFood = null;
	}

	public FoodType getFirstFood() {
		return firstFood;
	}

	public void setFirstFood(FoodType firstFood) {
		this.firstFood = firstFood;
	}
}

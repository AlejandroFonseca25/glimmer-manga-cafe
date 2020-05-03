package model;

public class FoodMachine extends Machine {
	
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

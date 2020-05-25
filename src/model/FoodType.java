package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class FoodType implements Serializable{
	
	private String name;
	private String brand;
	private int quantity;
	private int price;
	private String systemID;
	private FoodType next;
	private FoodType prev;
	
	public FoodType(String name, String brand, int quantity, int price) {
		super();
		this.name = name;
		this.brand = brand;
		this.quantity = quantity;
		this.price = price;
		systemID = null;
		next = null;
		prev = null;
	}

	public String getName() {
		return name;
	}

	public String getBrand() {
		return brand;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getPrice() {
		return price;
	}
	
	public String getSystemID() {
		return systemID;
	}

	public FoodType getNext() {
		return next;
	}

	public FoodType getPrev() {
		return prev;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setSystemID(String systemID) {
		this.systemID = systemID;
	}

	public void setNext(FoodType next) {
		this.next = next;
	}

	public void setPrev(FoodType prev) {
		this.prev = prev;
	}
}


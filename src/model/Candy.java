package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class Candy implements Serializable{
	
	private String name;
	private String brand;
	private int quantity;
	private String sugarQuantity;
	private int price;
	private String systemID;
	private Candy next;
	private Candy prev;
	
	public Candy(String name, String brand, int quantity, String sugarQuantity, int price) {
		this.name = name;
		this.brand = brand;
		this.quantity = quantity;
		this.setSugarQuantity(sugarQuantity);
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

	public Candy getNext() {
		return next;
	}

	public Candy getPrev() {
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

	public void setNext(Candy next) {
		this.next = next;
	}

	public void setPrev(Candy prev) {
		this.prev = prev;
	}

	public String getSugarQuantity() {
		return sugarQuantity;
	}

	public void setSugarQuantity(String sugarQuantity) {
		this.sugarQuantity = sugarQuantity;
	}
}

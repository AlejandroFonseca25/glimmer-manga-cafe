package model;

public class Candy {
	
	private String name;
	private String brand;
	private int quantity;
	private int price;
	private double sugarQuantity;
	private String systemID;
	private Candy next;
	private Candy prev;
	
	public Candy(String name, String brand, int quantity, int price, double sugarQuantity) {
		this.name = name;
		this.brand = brand;
		this.quantity = quantity;
		this.price = price;
		this.sugarQuantity = sugarQuantity;
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

	public double getSugarQuantity() {
		return sugarQuantity;
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

	public void setSugarQuantity(double sugarQuantity) {
		this.sugarQuantity = sugarQuantity;
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
}

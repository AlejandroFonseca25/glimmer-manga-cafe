package model;

@SuppressWarnings("serial")
public class HardCandy extends Candy{
	
	private boolean acid;
	
	public HardCandy(String name, String brand, int quantity, String sugarQuantity, int price, boolean acid) {
		super(name, brand, quantity, sugarQuantity, price);
		this.setAcid(acid);
	}

	public boolean isAcid() {
		return acid;
	}

	public void setAcid(boolean acid) {
		this.acid = acid;
	}
}

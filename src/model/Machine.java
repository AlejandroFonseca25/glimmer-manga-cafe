package model;

public abstract class Machine {
	
	private int money;
	
	public Machine () {
		money = 0;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
}

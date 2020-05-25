package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class Machine implements Serializable{
	
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

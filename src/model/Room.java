package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Room implements Serializable{
	
	private String name;
	private boolean enabled;
	private boolean occupied;
	private long time;
	
	public Room(String name) {
		super();
		this.name = name;
		enabled = true;
		occupied = false;
		time = 0;
	}

	public String getName() {
		return name;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public long getTime() {
		return time;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	public void setTime(long time) {
		this.time = time;
	}
}

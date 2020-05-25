package model;

import java.io.Serializable;
import java.time.LocalDateTime;

@SuppressWarnings("serial")
public class Room implements Serializable{
	
	private String name;
	private boolean enabled;
	private boolean occupied;
	private LocalDateTime time;
	private Client occupant;
	
	public Room(String name) {
		super();
		this.name = name;
		enabled = true;
		occupied = false;
		time = null;
		occupant = null;
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

	public Client getOccupant() {
		return occupant;
	}

	public LocalDateTime getTime() {
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

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public void setOccupant(Client occupant) {
		this.occupant = occupant;
	}
}

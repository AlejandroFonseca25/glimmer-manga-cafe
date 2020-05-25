package model;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class Manga implements Serializable{
	
	private String name;
	private LocalDate publishingDate;
	private String genre;
	private boolean available;
	private String systemId;
	private Manga left;
	private Manga right;
	private Manga father;
	
	public Manga(String name, LocalDate publishingDate, String genre, char bookshelf) {
		
		super();
		this.name = name;
		this.publishingDate = publishingDate;
		this.genre = genre;
		available = true;
		systemId = null;
		left = null;
		right = null;
		father = null; 
	}

	public String getName() {
		return name;
	}

	public LocalDate getPublishingDate() {
		return publishingDate;
	}

	public String getGenre() {
		return genre;
	}

	public boolean isAvailable() {
		return available;
	}

	public String getSystemId() {
		return systemId;
	}

	public Manga getLeft() {
		return left;
	}

	public Manga getRight() {
		return right;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPublishingDate(LocalDate publishingDate) {
		this.publishingDate = publishingDate;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public void setLeft(Manga left) {
		this.left = left;
	}

	public void setRight(Manga right) {
		this.right = right;
	}
}

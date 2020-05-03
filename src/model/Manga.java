package model;

import java.time.LocalDate;

public class Manga {
	
	private String name;
	private LocalDate publishingDate;
	private String genre;
	private char bookshelf;
	private boolean available;
	private String systemId;
	private Manga left;
	private Manga right;
	
	public Manga(String name, LocalDate publishingDate, String genre, char bookshelf) {
		
		super();
		this.name = name;
		this.publishingDate = publishingDate;
		this.genre = genre;
		this.bookshelf = bookshelf;
		available = true;
		systemId = null;
		left = null;
		right = null;
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

	public char getBookshelf() {
		return bookshelf;
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

	public void setBookshelf(char bookshelf) {
		this.bookshelf = bookshelf;
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

package com.example.Bookstore.domain;

public class Book {
	private String title;
	private String author;
	private long year;
	private String ISBN;
	private long price;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public long getYear() {
		return year;
	}
	public void setYear(long year) {
		this.year = year;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
}

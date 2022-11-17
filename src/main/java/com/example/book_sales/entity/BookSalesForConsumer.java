package com.example.book_sales.entity;

public class BookSalesForConsumer {

	private String bookTitle;

	private String isbn;

	private String author;

	private Integer price;

	private Integer purchaseQuantity;

	private Integer totalPrice;

	public BookSalesForConsumer() {

	}

	public BookSalesForConsumer(String bookTitle, String isbn, String author, Integer price, Integer purchaseQuantity,
			Integer totalPrice) {
		this.bookTitle = bookTitle;
		this.isbn = isbn;
		this.author = author;
		this.price = price;
		this.purchaseQuantity = purchaseQuantity;
		this.totalPrice = totalPrice;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getPurchaseQuantity() {
		return purchaseQuantity;
	}

	public void setPurchaseQuantity(Integer purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

}
